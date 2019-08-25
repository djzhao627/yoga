package com.fc.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fc.business.domain.CustomFollowPlanDO;
import com.fc.business.service.CustomFollowPlanService;
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
 * @author fengchi
 * @date 2019-08-23 22:38:51
 */

@Controller
@RequestMapping("/business/customFollowPlan")
public class CustomFollowPlanController extends BaseController {
    private String prefix = "business/customFollowPlan";
    @Autowired
    private CustomFollowPlanService customFollowPlanService;

    @GetMapping()
    @RequiresPermissions("business:customFollowPlan:customFollowPlan")
    String customFollowPlanDO() {
        return "business/customFollowPlan/customFollowPlan";
    }

    /**
     * 分页列表查询
     */
    @ResponseBody
    @GetMapping("/listPage")
//	@RequiresPermissions("business:customFollowPlan:customFollowPlan")
    public PageUtils list(@RequestParam Map<String, Object> params) {

        //根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {

            @Override
            public List<?> getPageRows(Query query) {
                return customFollowPlanService.list(query);
            }
        });
    }

    /**
     * 跳转到新增页面
     */
    @GetMapping("/add")
    @RequiresPermissions("business:customFollowPlan:add")
    ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("customFollowPlan", new CustomFollowPlanDO());
        mv.setViewName("business/customFollowPlan/add");
        return mv;
    }

    /**
     * 跳转到修改页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("business:customFollowPlan:edit")
    ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        CustomFollowPlanDO customFollowPlanDO = customFollowPlanService.get(id);
        mv.addObject("customFollowPlan", customFollowPlanDO);
        mv.setViewName("business/customFollowPlan/edit");
        return mv;
    }

    /**
     * 新增方法
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("business:customFollowPlan:add")
    public R save(CustomFollowPlanDO customFollowPlanDO) {
        if (customFollowPlanService.save(customFollowPlanDO) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改方法
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("business:customFollowPlan:edit")
    public R update(CustomFollowPlanDO customFollowPlanDO) {
        customFollowPlanService.update(customFollowPlanDO);
        return R.ok();
    }

    /**
     * 单条删除方法
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("business:customFollowPlan:remove")
    public R remove(Integer id) {
        if (customFollowPlanService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除方法
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("business:customFollowPlan:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        customFollowPlanService.batchRemove(ids);
        return R.ok();
    }

    @GetMapping("/customerList/{id}")
    ModelAndView customerList(@PathVariable("id") Integer id) {
//		Map<String, Object> params =new HashMap<>();
//		PageUtils pageList = getPageList(params, new IPageDefine() {
//			@Override
//			public List<?> getPageRows(Query query) {
//
//				return customFollowPlanService.list(query);
//			}
//		});
        ModelAndView mv = new ModelAndView();
        mv.addObject("customId", id);
        mv.setViewName("business/customFollowPlan/customFollowPlan");
//		return  prefix + "/customFollowPlanDO_list";
        return mv;
    }
}
