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

import com.fc.crm.domain.CampaignDO;
import com.fc.crm.service.CampaignService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-14 15:03:03
 */
 
@Controller
@RequestMapping("/crm/campaign")
public class CampaignController extends BaseController {
	@Autowired
	private CampaignService campaignService;
	
	@GetMapping()
	@RequiresPermissions("crm:campaign:campaign")
	String Campaign(){
	    return "crm/campaign/campaign_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:campaign:campaign")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  campaignService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:campaign:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("campaign", new CampaignDO());
		mv.setViewName("crm/campaign/campaign_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:campaign:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CampaignDO campaign = campaignService.get(id);
		mv.addObject("campaign", campaign);
		mv.setViewName("crm/campaign/campaign_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:campaign:add")
	public R save( CampaignDO campaign){
		if(campaignService.save(campaign)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:campaign:edit")
	public R update( CampaignDO campaign){
		campaignService.update(campaign);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:campaign:remove")
	public R remove( Integer id){
		if(campaignService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:campaign:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		campaignService.batchRemove(ids);
		return R.ok();
	}
	
}
