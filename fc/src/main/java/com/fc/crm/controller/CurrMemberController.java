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

import com.fc.crm.domain.CurrMemberDO;
import com.fc.crm.service.CurrMemberService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-22 14:55:13
 */
 
@Controller
@RequestMapping("/crm/currMember")
public class CurrMemberController extends BaseController {
	@Autowired
	private CurrMemberService currMemberService;
	
	@GetMapping()
	@RequiresPermissions("crm:currMember:currMember")
	String CurrMember(){
	    return "crm/currMember/currMember_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
//	@RequiresPermissions("crm:currMember:currMember")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  currMemberService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
//	@RequiresPermissions("crm:currMember:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("currMember", new CurrMemberDO());
		mv.setViewName("crm/currMember/currMember_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
//	@RequiresPermissions("crm:currMember:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CurrMemberDO currMember = currMemberService.get(id);
		mv.addObject("currMember", currMember);
		mv.setViewName("crm/currMember/currMember_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("crm:currMember:add")
	public R save( CurrMemberDO currMember){
		if(currMemberService.save(currMember)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("crm:currMember:edit")
	public R update( CurrMemberDO currMember){
		currMemberService.update(currMember);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("crm:currMember:remove")
	public R remove( Integer id){
		if(currMemberService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("crm:currMember:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		currMemberService.batchRemove(ids);
		return R.ok();
	}
	
}
