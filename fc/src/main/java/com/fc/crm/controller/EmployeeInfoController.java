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

import com.fc.crm.domain.EmployeeInfoDO;
import com.fc.crm.service.EmployeeInfoService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-22 17:11:28
 */
 
@Controller
@RequestMapping("/crm/employeeInfo")
public class EmployeeInfoController extends BaseController {
	@Autowired
	private EmployeeInfoService employeeInfoService;
	
	@GetMapping()
	@RequiresPermissions("crm:employeeInfo:employeeInfo")
	String EmployeeInfo(){
	    return "crm/employeeInfo/employeeInfo_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:employeeInfo:employeeInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  employeeInfoService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:employeeInfo:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("employeeInfo", new EmployeeInfoDO());
		mv.setViewName("crm/employeeInfo/employeeInfo_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{phonenumber}")
	@RequiresPermissions("crm:employeeInfo:edit")
	ModelAndView edit(@PathVariable("phonenumber") String phonenumber){
	    ModelAndView mv = new ModelAndView();
		EmployeeInfoDO employeeInfo = employeeInfoService.get(phonenumber);
		mv.addObject("employeeInfo", employeeInfo);
		mv.setViewName("crm/employeeInfo/employeeInfo_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:employeeInfo:add")
	public R save( EmployeeInfoDO employeeInfo){
		if(employeeInfoService.save(employeeInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:employeeInfo:edit")
	public R update( EmployeeInfoDO employeeInfo){
		employeeInfoService.update(employeeInfo);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:employeeInfo:remove")
	public R remove( String phonenumber){
		if(employeeInfoService.remove(phonenumber)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:employeeInfo:batchRemove")
	public R remove(@RequestParam("ids[]") String[] phonenumbers){
		employeeInfoService.batchRemove(phonenumbers);
		return R.ok();
	}
	
}
