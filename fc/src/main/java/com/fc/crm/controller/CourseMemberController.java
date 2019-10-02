package com.fc.crm.controller;

import java.util.List;
import java.util.Map;

import com.fc.crm.domain.CoursePackagesDO;
import com.fc.crm.vo.CourseMemberVO;
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

import com.fc.crm.domain.CourseMemberDO;
import com.fc.crm.service.CourseMemberService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-10-02 15:20:41
 */
 
@Controller
@RequestMapping("/crm/courseMember")
public class CourseMemberController extends BaseController {
	@Autowired
	private CourseMemberService courseMemberService;
	
	@GetMapping()
	@RequiresPermissions("crm:courseMember:courseMember")
	String CourseMember(){
	    return "crm/courseMember/courseMember_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:courseMember:courseMember")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  courseMemberService.list(query);
			}
        });
	}
	/**
	 * 跳转到课程列表页面
	 */
	@GetMapping("/courseList")
	ModelAndView courseList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("courseMember", new CourseMemberDO());
		mv.setViewName("crm/commonList/courseList");
		return mv;
	}
	/**
	 * 跳转到会员列表页面
	 */
	@GetMapping("/memberList")
	ModelAndView memberList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("courseMember", new CourseMemberDO());
		mv.setViewName("crm/commonList/memberList");
		return mv;
	}
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:courseMember:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("courseMember", new CourseMemberDO());
		mv.setViewName("crm/courseMember/courseMember_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:courseMember:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CourseMemberDO courseMember = courseMemberService.get(id);
		mv.addObject("courseMember", courseMember);
		mv.setViewName("crm/courseMember/courseMember_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:courseMember:add")
	public R save( CourseMemberVO courseMember){
		if(courseMemberService.save(courseMember)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:courseMember:edit")
	public R update( CourseMemberDO courseMember){
		courseMemberService.update(courseMember);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:courseMember:remove")
	public R remove( Integer id){
		if(courseMemberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:courseMember:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		courseMemberService.batchRemove(ids);
		return R.ok();
	}
	
}
