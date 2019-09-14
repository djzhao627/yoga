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

import com.fc.crm.domain.CoursePackagesDO;
import com.fc.crm.service.CoursePackagesService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-14 16:30:50
 */
 
@Controller
@RequestMapping("/crm/coursePackages")
public class CoursePackagesController extends BaseController {
	@Autowired
	private CoursePackagesService coursePackagesService;
	
	@GetMapping()
	@RequiresPermissions("crm:coursePackages:coursePackages")
	String CoursePackages(){
	    return "crm/coursePackages/coursePackages_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:coursePackages:coursePackages")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  coursePackagesService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:coursePackages:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("coursePackages", new CoursePackagesDO());
		mv.setViewName("crm/coursePackages/coursePackages_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:coursePackages:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CoursePackagesDO coursePackages = coursePackagesService.get(id);
		mv.addObject("coursePackages", coursePackages);
		mv.setViewName("crm/coursePackages/coursePackages_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:coursePackages:add")
	public R save( CoursePackagesDO coursePackages){
		if(coursePackagesService.save(coursePackages)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:coursePackages:edit")
	public R update( CoursePackagesDO coursePackages){
		coursePackagesService.update(coursePackages);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:coursePackages:remove")
	public R remove( Integer id){
		if(coursePackagesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:coursePackages:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		coursePackagesService.batchRemove(ids);
		return R.ok();
	}
	
}
