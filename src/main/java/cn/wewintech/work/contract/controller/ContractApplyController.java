package cn.wewintech.work.contract.controller;

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

import cn.wewintech.work.contract.domain.ContractApplyDO;
import cn.wewintech.work.contract.service.ContractApplyService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 合同申请
 * 
 * @author 
 * @email 
 * @date 2020-06-03 16:02:37
 */
 
@Controller
@RequestMapping("/work/contractApply")
public class ContractApplyController {
	@Autowired
	private ContractApplyService contractApplyService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("work:contractApply:contractApply")
	String ContractApply(){
	    return "work/contractApply/contractApply";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:contractApply:contractApply")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ContractApplyDO> contractApplyList = contractApplyService.list(query);
		for (ContractApplyDO contractApplyDO : contractApplyList) {
			contractApplyDO.setAuditState(dictService.findNameByValueAndType(contractApplyDO.getAuditState(), "audit_state"));
		}
		int total = contractApplyService.count(query);
		PageUtils pageUtils = new PageUtils(contractApplyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:contractApply:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		ContractApplyDO contractApply=new ContractApplyDO();
		contractApply.addData();
		model.addAttribute("applyUser", projectManager);
		model.addAttribute("contract", contractApply);
	    return "work/contractApply/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:contractApply:edit")
	String edit(@PathVariable("id") String id,Model model){
		ContractApplyDO contractApply = contractApplyService.get(id);
		model.addAttribute("contractApply", contractApply);
	    return "work/contractApply/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:contractApply:add")
	public ResultObject save( ContractApplyDO contractApply){
		if(contractApplyService.save(contractApply)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:contractApply:edit")
	public ResultObject update( ContractApplyDO contractApply){
		contractApplyService.update(contractApply);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:contractApply:remove")
	public ResultObject remove( String id){
		if(contractApplyService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:contractApply:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		contractApplyService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
