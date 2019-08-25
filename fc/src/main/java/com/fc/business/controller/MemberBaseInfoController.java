package com.fc.business.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.business.domain.MemberBaseInfoDO;
import com.fc.business.service.MemberBaseInfoService;
import com.fc.common.utils.PageUtils;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 会员信息表
 * @author fengchi
 * @date 2019-08-19 21:40:52
 */
 
@Controller
@RequestMapping("/business/memberBaseInfo")
public class MemberBaseInfoController extends BaseController {
	@Autowired
	private MemberBaseInfoService memberBaseInfoService;
	
	@GetMapping()
	@RequiresPermissions("business:memberBaseInfo:memberBaseInfo")
	String memberBaseInfo(){
	    return "business/memberBaseInfo/customInfo";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("business:memberBaseInfo:memberBaseInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  memberBaseInfoService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("business:memberBaseInfo:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("memberBaseInfo", new MemberBaseInfoDO());
		mv.setViewName("business/memberBaseInfo/add");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("business:memberBaseInfo:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		MemberBaseInfoDO memberBaseInfo = memberBaseInfoService.get(id);
		mv.addObject("memberBaseInfo", memberBaseInfo);
		mv.setViewName("business/memberBaseInfo/edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:memberBaseInfo:add")
	public R save( MemberBaseInfoDO memberBaseInfo){
		if(memberBaseInfoService.save(memberBaseInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:memberBaseInfo:edit")
	public R update( MemberBaseInfoDO memberBaseInfo){
		memberBaseInfoService.update(memberBaseInfo);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:memberBaseInfo:remove")
	public R remove( Integer id){
		if(memberBaseInfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:memberBaseInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		memberBaseInfoService.batchRemove(ids);
		return R.ok();
	}
	
}
