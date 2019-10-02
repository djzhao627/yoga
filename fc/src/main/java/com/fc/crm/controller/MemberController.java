package com.fc.crm.controller;

import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;
import com.fc.common.utils.PageUtils;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.crm.domain.MemberDO;
import com.fc.crm.service.MemberService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * @author fengchi
 * @date 2019-08-19 21:40:52
 */
 
@Controller
@RequestMapping("/crm/member")
public class MemberController extends BaseController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping()
	@RequiresPermissions("crm:member:member")
	String memberBaseInfo(){
	    return "crm/member/member";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:member:member")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  memberService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:member:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		MemberDO member = new MemberDO();
		mv.addObject("memberBaseInfo", member);
		mv.setViewName("crm/member/edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:member:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		MemberDO member = memberService.get(id);
		mv.addObject("memberBaseInfo", member);
		mv.setViewName("crm/member/edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:member:add")
	public R save( MemberDO member){
		if(memberService.save(member)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:member:edit")
	public R update( MemberDO member){
		memberService.update(member);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:member:remove")
	public R remove( Integer id){
		if(memberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:member:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		memberService.batchRemove(ids);
		return R.ok();
	}
	
}
