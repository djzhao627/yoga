package com.bootdo.pfd.person.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.pfd.person.domain.PersonDO;
import com.bootdo.pfd.person.service.PersonService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-26 20:31:21
 */
 
@Controller
@RequestMapping("/person/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping()
	@RequiresPermissions("person:person:person")
	String Person(){
	    return "person/person/person";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("person:person:person")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PersonDO> personList = personService.list(query);
		int total = personService.count(query);
		PageUtils pageUtils = new PageUtils(personList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("person:person:add")
	String add(){
	    return "person/person/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("person:person:edit")
	String edit(@PathVariable("id") String id,Model model){
		PersonDO person = personService.get(id);
		model.addAttribute("person", person);
	    return "person/person/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("person:person:add")
	public R save( PersonDO person){
		if(personService.save(person)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("person:person:edit")
	public R update( PersonDO person){
		personService.update(person);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("person:person:remove")
	public R remove( String id){
		if(personService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("person:person:batchRemove")
	public R remove(@RequestParam("ids[]") String[] ids){
		personService.batchRemove(ids);
		return R.ok();
	}
	
}
