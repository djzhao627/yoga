package com.fc.crm.controller;

import java.util.List;
import java.util.Map;

import com.fc.crm.vo.CurriculumVO;
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

import com.fc.crm.domain.CurriculumDO;
import com.fc.crm.service.CurriculumService;
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
@RequestMapping("/crm/curriculum")
public class CurriculumController extends BaseController {
	@Autowired
	private CurriculumService curriculumService;
	
	@GetMapping()
	@RequiresPermissions("crm:curriculum:curriculum")
	String Curriculum(){
	    return "crm/curriculum/curriculum_list";
	}
	
	/**
	 * 分页列表查询
	 */
	@ResponseBody
	@GetMapping("/listPage")
	@RequiresPermissions("crm:curriculum:curriculum")
	public PageUtils list(@RequestParam Map<String, Object> params){

		//根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {
			
			@Override
			public List<?> getPageRows(Query query){
				return  curriculumService.list(query);
			}
        });
	}
	
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("crm:curriculum:add")
	ModelAndView add(){
	    ModelAndView mv = new ModelAndView();
		mv.addObject("curriculum", new CurriculumVO());
		mv.setViewName("crm/curriculum/curriculum_edit");
		return mv;
	}
	
	/**
	 * 跳转到修改页面
	 */
	@GetMapping("/edit/{id}")
	@RequiresPermissions("crm:curriculum:edit")
	ModelAndView edit(@PathVariable("id") Integer id){
	    ModelAndView mv = new ModelAndView();
		CurriculumDO curriculum = curriculumService.get(id);
		mv.addObject("curriculum", curriculum);
		mv.setViewName("crm/curriculum/curriculum_edit");
		return mv;
	}
	
	/**
	 * 新增方法
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("crm:curriculum:add")
	public R save( CurriculumVO curriculum){
		if(curriculumService.save(curriculum)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改方法
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("crm:curriculum:edit")
	public R update( CurriculumVO curriculum){
		curriculumService.update(curriculum);
		return R.ok();
	}
	
	/**
	 * 单条删除方法
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("crm:curriculum:remove")
	public R remove( Integer id){
		if(curriculumService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 批量删除方法
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("crm:curriculum:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		curriculumService.batchRemove(ids);
		return R.ok();
	}
	
}
