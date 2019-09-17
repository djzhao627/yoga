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

import com.fc.crm.domain.StockDO;
import com.fc.crm.service.StockService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 
 * @author fengchi
 * @date 2019-09-08 14:56:31
 */
 
@Controller
@RequestMapping("/crm/stock")
public class StockController extends BaseController {
	@Autowired
	private StockService stockService;
	
	@GetMapping()
//	@RequiresPermissions("crm:stock:stock")
	String Stock(){
	    return "crm/stock/stock_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
//	@RequiresPermissions("crm:stock:stock")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  stockService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
//	@RequiresPermissions("crm:stock:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("stock", new StockDO());
		mv.setViewName("crm/stock/stock_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{goodsId}")
//	@RequiresPermissions("crm:stock:edit")
	ModelAndView edit(@PathVariable("goodsId") Integer goodsId){
	    ModelAndView mv = new ModelAndView();
		StockDO stock = stockService.get(goodsId);
		mv.addObject("stock", stock);
		mv.setViewName("crm/stock/stock_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("crm:stock:add")
	public R save( StockDO stock){
		if(stockService.save(stock)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("crm:stock:edit")
	public R update( StockDO stock){
		stockService.update(stock);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("crm:stock:remove")
	public R remove( Integer goodsId){
		if(stockService.remove(goodsId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("crm:stock:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] goodsIds){
		stockService.batchRemove(goodsIds);
		return R.ok();
	}
	
}
