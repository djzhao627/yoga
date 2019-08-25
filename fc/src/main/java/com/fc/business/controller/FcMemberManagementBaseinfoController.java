package com.fc.business.controller;

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

import com.fc.business.domain.FcMemberManagementBaseinfoDO;
import com.fc.business.service.FcMemberManagementBaseinfoService;
import com.fc.common.utils.PageUtils;
import com.github.pagehelper.PageInfo;
import com.fc.common.utils.Query;
import com.fc.common.utils.R;
import com.fc.common.controller.BaseController;
import com.fc.common.controller.IPageDefine;

/**
 * 会员信息表
 *
 * @author fengchi
 * @date 2019-08-19 21:40:52
 */

@Controller
@RequestMapping("/business/fcMemberManagementBaseinfo")
public class FcMemberManagementBaseinfoController extends BaseController {
    @Autowired
    private FcMemberManagementBaseinfoService fcMemberManagementBaseinfoService;

    @GetMapping()
    @RequiresPermissions("business:fcMemberManagementBaseinfo:fcMemberManagementBaseinfo")
    String FcMemberManagementBaseinfo() {
        return "business/fcMemberManagementBaseinfo/customInfo";
    }

    /**
     * 分页列表查询
     */
    @ResponseBody
    @GetMapping("/listPage")
    @RequiresPermissions("business:fcMemberManagementBaseinfo:fcMemberManagementBaseinfo")
    public PageUtils list(@RequestParam Map<String, Object> params) {

        //根据分页参数(格式：{limit=10, offset=0} )，然后进行分页查询
        return getPageList(params, new IPageDefine() {

            @Override
            public List<?> getPageRows(Query query) {
                return fcMemberManagementBaseinfoService.list(query);
            }
        });
    }

    /**
     * 跳转到新增页面
     */
    @GetMapping("/add")
    @RequiresPermissions("business:fcMemberManagementBaseinfo:add")
    ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("fcMemberManagementBaseinfo", new FcMemberManagementBaseinfoDO());
        mv.setViewName("business/fcMemberManagementBaseinfo/add");
        return mv;
    }

    /**
     * 跳转到修改页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("business:fcMemberManagementBaseinfo:edit")
    ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo = fcMemberManagementBaseinfoService.get(id);
        mv.addObject("fcMemberManagementBaseinfo", fcMemberManagementBaseinfo);
        mv.setViewName("business/fcMemberManagementBaseinfo/edit");
        return mv;
    }

    /**
     * 新增方法
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("business:fcMemberManagementBaseinfo:add")
    public R save(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo) {
        if (fcMemberManagementBaseinfoService.save(fcMemberManagementBaseinfo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改方法
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("business:fcMemberManagementBaseinfo:edit")
    public R update(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo) {
        fcMemberManagementBaseinfoService.update(fcMemberManagementBaseinfo);
        return R.ok();
    }

    /**
     * 单条删除方法
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("business:fcMemberManagementBaseinfo:remove")
    public R remove(Integer id) {
        if (fcMemberManagementBaseinfoService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 批量删除方法
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("business:fcMemberManagementBaseinfo:batchRemove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        fcMemberManagementBaseinfoService.batchRemove(ids);
        return R.ok();
    }

}
