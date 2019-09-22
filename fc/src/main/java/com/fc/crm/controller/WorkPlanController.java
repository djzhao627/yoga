package com.fc.crm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fc.common.config.FcConfig;
import com.fc.common.utils.*;
import com.fc.system.domain.UserDO;
import com.fc.system.service.SessionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;
import com.github.pagehelper.PageInfo;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

import javax.servlet.http.HttpServletRequest;

/**
 * 工作计划
 *
 * @author fengchi
 * @date 2019-08-26 22:59:56
 */

@Controller
@RequestMapping("/crm/workPlan")
public class WorkPlanController extends BaseController {
    @Autowired
    private WorkPlanService workPlanService;

    @Autowired
    private FcConfig fcConfig;

    @GetMapping()
    @RequiresPermissions("crm:workPlan:workPlan")
    String WorkPlan() {
        return "crm/workPlan/workPlan_list";
    }

    @GetMapping("/personLiable")
    String personLiable() {
        return "crm/workPlan/personLiable";
    }

    @GetMapping("/helper")
    String helper() {
        return "crm/workPlan/helper";
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
    ModelAndView edit(@PathVariable("id") String id) {
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

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @RequiresPermissions("crm:workPlan:edit")
    public R uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, String id) {
        try {
            WorkPlanDO workPlan = new WorkPlanDO(id);
            String fileName = file.getOriginalFilename();
            String fileId = FileUtil.renameToUUID(fileName);
            workPlan.setTaskAnnex(fileName);
            workPlan.setTaskAnnexPath("/files/" + fileId);
            workPlan.setLastModifyAuthor(getUserId());
            workPlan.setLastModifyTime(DateUtils.getDateTime());
            //FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
            FileUtil.uploadFile(file.getBytes(), fcConfig.getUploadPath(), fileId);
            workPlanService.update(workPlan);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 单条删除方法
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("crm:workPlan:remove")
    public R remove(String id) {
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
    public R remove(@RequestParam("ids[]") String[] ids) {
        workPlanService.batchRemove(ids);
        return R.ok();
    }

    /**
     * 批量作废方法
     */
    @PostMapping("/batchScrapped")
    @ResponseBody
    @RequiresPermissions("crm:workPlan:batchScrapped")
    public R batchScrapped(@RequestParam("ids[]") String[] ids) {
        workPlanService.batchRemove(ids);
        return R.ok();
    }

    /**
     * 批量发布方法
     */
    @PostMapping("/batchPublic")
    @ResponseBody
    @RequiresPermissions("crm:workPlan:batchPublic")
    public R publicWorkPlan(@RequestParam("ids[]") String[] ids) {
        workPlanService.publicWorkPlan(ids);
        return R.ok();
    }
}
