package com.fc.crm.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.crm.domain.SomatometricRecordDO;
import com.fc.crm.service.SomatometricRecordService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-14 15:03:04
 */
 
@Controller
@RequestMapping("/crm/somatometricRecord")
public class SomatometricRecordController extends BaseController {
	@Autowired
	private SomatometricRecordService somatometricRecordService;
	
	@GetMapping()
	@RequiresPermissions("crm:somatometricRecord:somatometricRecord")
	String SomatometricRecord(){
	    return "crm/somatometricRecord/somatometricRecord_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:somatometricRecord:somatometricRecord")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  somatometricRecordService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:somatometricRecord:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("somatometricRecord", new SomatometricRecordDO());
		mv.setViewName("crm/somatometricRecord/somatometricRecord_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:somatometricRecord:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		SomatometricRecordDO somatometricRecord = somatometricRecordService.get(id);
		mv.addObject("somatometricRecord", somatometricRecord);
		mv.setViewName("crm/somatometricRecord/somatometricRecord_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:somatometricRecord:add")
	public R save( SomatometricRecordDO somatometricRecord){
		if(somatometricRecordService.save(somatometricRecord)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:somatometricRecord:edit")
	public R update( SomatometricRecordDO somatometricRecord){
		somatometricRecordService.update(somatometricRecord);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:somatometricRecord:remove")
	public R remove( Integer id){
		if(somatometricRecordService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:somatometricRecord:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		somatometricRecordService.batchRemove(ids);
		return R.ok();
	}
	
}
