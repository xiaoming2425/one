package cn.wewintech.work.backAccount.controller;

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

import cn.wewintech.work.backAccount.domain.BackAccountAssureDO;
import cn.wewintech.work.backAccount.service.BackAccountAssureService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 回款申请确认
 * 
 * @author 
 * @email 
 * @date 2020-06-03 17:37:08
 */
 
@Controller
@RequestMapping("/work/backAccountAssure")
public class BackAccountAssureController {
	@Autowired
	private BackAccountAssureService backAccountAssureService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("work:backAccountAssure:backAccountAssure")
	String BackAccountAssure(){
	    return "work/backAccountAssure/backAccountAssure";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:backAccountAssure:backAccountAssure")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BackAccountAssureDO> backAccountAssureList = backAccountAssureService.list(query);
		for (BackAccountAssureDO backAccountAssureDO : backAccountAssureList) {
			backAccountAssureDO.setAuditState(dictService.findNameByValueAndType(backAccountAssureDO.getAuditState(), "audit_state"));
		}
		int total = backAccountAssureService.count(query);
		PageUtils pageUtils = new PageUtils(backAccountAssureList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:backAccountAssure:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/backAccountAssure/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:backAccountAssure:edit")
	String edit(@PathVariable("id") String id,Model model){
		BackAccountAssureDO backAccountAssure = backAccountAssureService.get(id);
		model.addAttribute("backAccountAssure", backAccountAssure);
	    return "work/backAccountAssure/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:backAccountAssure:add")
	public ResultObject save( BackAccountAssureDO backAccountAssure){
		if(backAccountAssureService.save(backAccountAssure)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:backAccountAssure:edit")
	public ResultObject update( BackAccountAssureDO backAccountAssure){
		backAccountAssureService.update(backAccountAssure);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:backAccountAssure:remove")
	public ResultObject remove( String id){
		if(backAccountAssureService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:backAccountAssure:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		backAccountAssureService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
