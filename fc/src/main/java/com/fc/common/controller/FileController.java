package com.fc.common.controller;

import com.fc.common.config.FcConfig;
import com.fc.common.domain.FileDO;
import com.fc.common.service.FileService;
import com.fc.common.utils.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/common/sysFile")
public class FileController extends BaseController {

	@Autowired
	private FileService sysFileService;

	@Autowired
	private FcConfig fcConfig;

	@GetMapping()
	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "common/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			@Override
			public List<?> getPageRows(Query query){
				return sysFileService.list(query);
			}
        });
	}

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(Long id, Model model) {
		FileDO sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("common:info")
	public R info(@PathVariable("id") Long id) {
		FileDO sysFile = sysFileService.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:save")
	public R save(FileDO sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("common:update")
	public R update(@RequestBody FileDO sysFile) {
		sysFileService.update(sysFile);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public R remove(Long id, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = fcConfig.getUploadPath() + sysFileService.get(id).getUrl().replace("/files/", "");
		if (sysFileService.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return R.error("数据库记录删除成功，文件删除失败");
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		sysFileService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), fcConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}
	
	/*@RequestMapping(value="/uploadFilekkp",method = RequestMethod.POST)
	@ResponseBody
	public Map uploadFile(ModelMap model, @RequestParam(value="myfile") MultipartFile file, HttpServletRequest request,HttpServletResponse response) throws Exception {
		Map resultMap = new HashedMap();
		try {
            String uploadPath = commonConfig.getBup_path()+File.separator + "upload";
			//保存文件
			File dest = null;
			String newFileName="";
			if (file != null && !file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				 newFileName = generateNewFileName(fileName);
				// 获取文件的大小
				String path = uploadPath;
				dest = new File(path + File.separator +newFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdir();
				}
					file.transferTo(dest);
			}
			resultMap.put("code",ConstantUtil.SUCCESS);
			resultMap.put("msg",ConstantUtil.SUCCESS);
			resultMap.put("url",uploadPath+ File.separator + newFileName);
			resultMap.put("name",newFileName);
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("code","fail");
			resultMap.put("msg",e.getMessage());
			resultMap.put("url","");
			resultMap.put("name","");
		}
		return resultMap;
	}


	@RequestMapping(value="/uploadPortraitFile",method = RequestMethod.POST)
	@ResponseBody
	public Map uploadPortraitFile(ModelMap model, @RequestParam(value="myfile") MultipartFile file, HttpServletRequest request) throws Exception {
		Map resultMap = new HashedMap();
		try {
			String uploadPath = commonConfig.getHead_portrait_path()+File.separator + "upload";
			//保存文件
			File dest = null;
			String newFileName="";
			if (file != null && !file.isEmpty()) {
				String fileName = file.getOriginalFilename();
				newFileName = generateNewFileName(fileName);
				// 获取文件的大小
				String path = uploadPath;
				dest = new File(path + File.separator + newFileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdir();
				}
				file.transferTo(dest);
			}
			resultMap.put("code","success");
			resultMap.put("msg","success");
			resultMap.put("url",uploadPath+ File.separator + newFileName);
			resultMap.put("name",newFileName);
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("code","fail");
			resultMap.put("msg",e.getMessage());
			resultMap.put("url","");
			resultMap.put("name","");
		}
		return resultMap;
	}
	
	*//**
	 * Excel导出
	 *//*
	@RequestMapping(value = "/toDownExcelModel")
	public void toDownExcelModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String str = "attachment;filename=";
		String filename = request.getParameter("filename") == null ? "" : request.getParameter("filename");
		String filePath = request.getParameter("filePath") == null ? "" : request.getParameter("filePath");
		filename =  URLDecoder.decode(filename, ConstantUtil.UTF_8);
		filePath =  URLDecoder.decode(filePath, ConstantUtil.UTF_8);
		response.setCharacterEncoding(ConstantUtil.UTF_8);
		response.setContentType("application/vnd.ms-excel");
		InputStream fis = null;
		try {
			String agent = request.getHeader("USER-AGENT");
			if(agent.toLowerCase().indexOf("msie 7")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else if(agent.toLowerCase().indexOf("msie 8")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else if(agent.toLowerCase().indexOf("msie 9")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else if(agent.toLowerCase().indexOf("msie 10")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else if(agent.toLowerCase().indexOf("msie")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else if(agent.indexOf("opera")>ConstantUtil.INTEGER_ZERO){
				filename = new String(filename.getBytes(), ConstantUtil.ISO_8859_1);
			//}else if(agent.indexOf("opera")>ConstantUtil.INTEGER_ZERO){
				//filename = new String(filename.getBytes(), ConstantUtil.ISO_8859_1);
			}else if(agent.indexOf("firefox")>ConstantUtil.INTEGER_ZERO){
				filename = new String(filename.getBytes(), ConstantUtil.ISO_8859_1);
			}else if(agent.indexOf("webkit")>ConstantUtil.INTEGER_ZERO){
				filename = new String(filename.getBytes(), ConstantUtil.ISO_8859_1);
			}else if(agent.indexOf("ecko")>ConstantUtil.INTEGER_ZERO && agent.indexOf("rv:11")>ConstantUtil.INTEGER_ZERO){
				filename = java.net.URLEncoder.encode(filename, ConstantUtil.UTF_8);
			}else{
				filename = new String(filename.getBytes(), ConstantUtil.ISO_8859_1);
			}
			response.addHeader("Content-Disposition", str + filename);
			File downFile = new File(filePath);
			response.addHeader("Content-Length",String.valueOf(downFile.length()));
			fis = new FileInputStream(new File(filePath));
			request.setCharacterEncoding("UTF-8");
			byte[] bytes = new byte[1024];
			while (fis.read(bytes) != -1) {
				response.getOutputStream().write(bytes);
			}
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	*//**
	 * 生成新的文件名
	 * 新文件名： yyyyMMddHHmmss + "." + 文件的原始名称
	 * @param fileName 文件的原始名称 return timestamp + "." + fileName.substring(fileName.lastIndexOf(".") + 1)
	 *//*
	private String generateNewFileName(String fileName) {
		// 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
		// 上传文件的扩展名
		String fileExtName = fileName.substring(fileName.lastIndexOf(".".toCharArray()[0]) + 1);
		return timestamp + "." + fileExtName;
	}
*/

}
