package com.fc.crm.controller;

import java.util.List;
import java.util.Map;

import com.fc.crm.domain.CourseMemberDO;
import com.fc.crm.vo.CardsVO;
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

import com.fc.crm.domain.CardsDO;
import com.fc.crm.service.CardsService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-28 21:47:46
 */
 
@Controller
@RequestMapping("/crm/cards")
public class CardsController extends BaseController {
	@Autowired
	private CardsService cardsService;
	
	@GetMapping()
	@RequiresPermissions("crm:cards:cards")
	String Cards(){
	    return "crm/cards/cards_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:cards:cards")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  cardsService.list(query);
			}
        });
	}
	/**
	 * 跳转到会员列表页面
	 */
	@GetMapping("/memberList")
	ModelAndView memberList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("cards", new CardsDO());
		mv.setViewName("crm/commonList/memberList");
		return mv;
	}
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:cards:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("cards", new CardsVO());
		mv.setViewName("crm/cards/cards_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:cards:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CardsVO cards = cardsService.get(id);
		mv.addObject("cards", cards);
		mv.setViewName("crm/cards/cards_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:cards:add")
	public R save( CardsDO cards){
		if(cardsService.save(cards)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:cards:edit")
	public R update( CardsDO cards){
		cardsService.update(cards);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:cards:remove")
	public R remove( Integer id){
		if(cardsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:cards:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		cardsService.batchRemove(ids);
		return R.ok();
	}
	
}
