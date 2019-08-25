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

import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * @author fengchi
 * @date 2019-08-24 18:23:38
 */

@Controller
@RequestMapping("/crm/workPlan")
public class WorkPlanController extends BaseController {
    @Autowired
    private WorkPlanService workPlanService;

    @GetMapping()
    @RequiresPermissions("crm:workPlan:workPlan")
    String WorkPlan() {
        return "crm/workPlan/workPlan_list";
    }

    /**
     * 分页列表查询
     */
    @ResponseBody
    @GetMapping("/listPage")
    @RequiresPermissions("crm:workPlan:workPlan")
    public PageUtils list(@RequestParam Map<String, Object> params) {

        //根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {

            @Override
            public List<?> getPageRows(Query query) {
                return workPlanService.list(query);
            }
        });
    }

    /**
     * 跳转到新增页面
     */
    @GetMapping("/add/{deptId}/{deptName}")
    @RequiresPermissions("crm:workPlan:add")
    ModelAndView add(@PathVariable("deptId") String deptId, @PathVariable("deptName") String deptName) {
        ModelAndView mv = new ModelAndView();
        WorkPlanDO workPlanDO = new WorkPlanDO();
        workPlanDO.setDeptId(deptId);
        workPlanDO.setDeptName(deptName);
        mv.addObject("workPlan", workPlanDO);
        mv.setViewName("crm/workPlan/workPlan_edit");
        return mv;
    }

    /**
     * 跳转到修改页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("crm:workPlan:edit")
    ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        WorkPlanDO workPlan = workPlanService.get(id);
        mv.addObject("workPlan", workPlan);
        mv.setViewName("crm/workPlan/workPlan_edit");
        return mv;
    }

    /**
     * 新增方法
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("crm:workPlan:add")
    public R save(WorkPlanDO workPlan) {
        if (workPlanService.save(workPlan) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改方法
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("crm:workPlan:edit")
    public R update(WorkPlanDO workPlan) {
        workPlanService.update(workPlan);
        return R.ok();
    }

    /**
     * 单条删除方法
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("crm:workPlan:remove")
    public R remove(Integer id) {
        if (workPlanService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除方法
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("crm:workPlan:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        workPlanService.batchRemove(ids);
        return R.ok();
    }

}
