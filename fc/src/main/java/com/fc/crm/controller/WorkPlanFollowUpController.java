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

import com.fc.crm.domain.WorkPlanFollowUpDO;
import com.fc.crm.service.WorkPlanFollowUpService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * @author fengchi
 * @date 2019-09-05 22:39:01
 */

@Controller
@RequestMapping("/crm/workPlanFollowUp")
public class WorkPlanFollowUpController extends BaseController {
    @Autowired
    private WorkPlanFollowUpService workPlanFollowUpService;

    @GetMapping()
    @RequiresPermissions("crm:workPlanFollowUp:workPlanFollowUp")
    String WorkPlanFollowUp() {
        return "crm/workPlanFollowUp/workPlanFollowUp_list";
    }

    /**
     * 分页列表查询
     */
    @ResponseBody
    @PostMapping("/listPage")
    //@RequiresPermissions("crm:workPlanFollowUp:workPlanFollowUp")
    public PageUtils list(@RequestParam Map<String, Object> params) {

        //根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {

            @Override
            public List<?> getPageRows(Query query) {
                return workPlanFollowUpService.list(query);
            }
        });
    }

    /**
     * 跳转到新增页面
     */
    @GetMapping("/add")
    @RequiresPermissions("crm:workPlanFollowUp:add")
    ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("workPlanFollowUp", new WorkPlanFollowUpDO());
        mv.setViewName("crm/workPlanFollowUp/workPlanFollowUp_edit");
        return mv;
    }

    /**
     * 跳转到修改页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("crm:workPlanFollowUp:edit")
    ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        WorkPlanFollowUpDO workPlanFollowUp = workPlanFollowUpService.get(id);
        mv.addObject("workPlanFollowUp", workPlanFollowUp);
        mv.setViewName("crm/workPlanFollowUp/workPlanFollowUp_edit");
        return mv;
    }

    /**
     * 新增方法
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("crm:workPlanFollowUp:add")
    public R save(WorkPlanFollowUpDO workPlanFollowUp) {
        if (workPlanFollowUpService.save(workPlanFollowUp) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改方法
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("crm:workPlanFollowUp:edit")
    public R update(WorkPlanFollowUpDO workPlanFollowUp) {
        workPlanFollowUpService.update(workPlanFollowUp);
        return R.ok();
    }

    /**
     * 单条删除方法
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("crm:workPlanFollowUp:remove")
    public R remove(Integer id) {
        if (workPlanFollowUpService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除方法
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("crm:workPlanFollowUp:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        workPlanFollowUpService.batchRemove(ids);
        return R.ok();
    }

}
