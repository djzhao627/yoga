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

import com.fc.crm.domain.ClassroomDO;
import com.fc.crm.service.ClassroomService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-22 14:55:12
 */
 
@Controller
@RequestMapping("/crm/classroom")
public class ClassroomController extends BaseController {
	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping()
	@RequiresPermissions("crm:classroom:classroom")
	String Classroom(){
	    return "crm/classroom/classroom_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:classroom:classroom")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  classroomService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:classroom:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("classroom", new ClassroomDO());
		mv.setViewName("crm/classroom/classroom_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:classroom:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		ClassroomDO classroom = classroomService.get(id);
		mv.addObject("classroom", classroom);
		mv.setViewName("crm/classroom/classroom_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:classroom:add")
	public R save( ClassroomDO classroom){
		if(classroomService.save(classroom)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:classroom:edit")
	public R update( ClassroomDO classroom){
		classroomService.update(classroom);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:classroom:remove")
	public R remove( Integer id){
		if(classroomService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:classroom:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		classroomService.batchRemove(ids);
		return R.ok();
	}
	
}
