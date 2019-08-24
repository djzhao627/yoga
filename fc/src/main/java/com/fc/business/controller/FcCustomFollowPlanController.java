package com.fc.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fc.business.domain.FcCustomFollowPlanDO;
import com.fc.business.service.FcCustomFollowPlanService;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;
import com.fc.common.utils.PageUtils;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
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
/**
 * 
 * @author fengchi
 * @date 2019-08-23 22:38:51
 */
 
@Controller
@RequestMapping("/business/fcCustomFollowPlan")
public class FcCustomFollowPlanController extends BaseController {
	private String prefix="business/fcCustomFollowPlan"  ;
	@Autowired
	private FcCustomFollowPlanService fcCustomFollowPlanService;
	
	@GetMapping()
	@RequiresPermissions("business:fcCustomFollowPlan:fcCustomFollowPlan")
	String FcCustomFollowPlan(){
	    return "business/fcCustomFollowPlan/customFollowPlan";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("business:fcCustomFollowPlan:fcCustomFollowPlan")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  fcCustomFollowPlanService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("business:fcCustomFollowPlan:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("fcCustomFollowPlan", new FcCustomFollowPlanDO());
		mv.setViewName("business/fcCustomFollowPlan/add");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("business:fcCustomFollowPlan:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		FcCustomFollowPlanDO fcCustomFollowPlan = fcCustomFollowPlanService.get(id);
		mv.addObject("fcCustomFollowPlan", fcCustomFollowPlan);
		mv.setViewName("business/fcCustomFollowPlan/edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("business:fcCustomFollowPlan:add")
	public R save(FcCustomFollowPlanDO fcCustomFollowPlan){
		if(fcCustomFollowPlanService.save(fcCustomFollowPlan)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("business:fcCustomFollowPlan:edit")
	public R update( FcCustomFollowPlanDO fcCustomFollowPlan){
		fcCustomFollowPlanService.update(fcCustomFollowPlan);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("business:fcCustomFollowPlan:remove")
	public R remove( Integer id){
		if(fcCustomFollowPlanService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("business:fcCustomFollowPlan:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		fcCustomFollowPlanService.batchRemove(ids);
		return R.ok();
	}
	@GetMapping("/customerList/{id}")
	ModelAndView customerList(@PathVariable("id")Integer id) {
		Map<String, Object> params =new HashMap<>();
		params.put("custom_id",id);
		PageUtils pageList = getPageList(params, new IPageDefine() {
			@Override
			public List<?> getPageRows(Query query) {
				return fcCustomFollowPlanService.list(query);
			}
		});
		ModelAndView mv = new ModelAndView();
		mv.addObject("fcCustomFollowPlan", pageList);
		mv.setViewName("business/fcCustomFollowPlan/customFollowPlan");
//		return  prefix + "/fcCustomFollowPlan_list";
		return mv;
	}
}
