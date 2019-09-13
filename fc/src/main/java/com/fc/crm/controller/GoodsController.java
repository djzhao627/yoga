package com.fc.crm.controller;

import java.util.List;
import java.util.Map;

import com.fc.crm.vo.GoodsVO;
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

import com.fc.crm.domain.GoodsDO;
import com.fc.crm.service.GoodsService;
import com.fc.common.utils.PageUtils;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-08 14:56:30
 */
 
@Controller
@RequestMapping("/crm/goods")
public class GoodsController extends BaseController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping()
	@RequiresPermissions("crm:goods:goods")
	String Goods(){
	    return "crm/goods/goods_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:goods:goods")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  goodsService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:goods:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("goods", new GoodsVO());
		mv.setViewName("crm/goods/goods_add");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:goods:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		GoodsVO goods = goodsService.get(id);
		mv.addObject("goods", goods);
		mv.setViewName("crm/goods/goods_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:goods:add")
	public R save( GoodsVO goods){
		if(goodsService.save(goods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:goods:edit")
	public R update( GoodsVO goods){
		goodsService.update(goods);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:goods:remove")
	public R remove( Integer id){
		if(goodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:goods:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		goodsService.batchRemove(ids);
		return R.ok();
	}
	
}
