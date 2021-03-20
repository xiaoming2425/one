package cn.wewintech.work.payAmount.controller;

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

import cn.wewintech.work.payAmount.domain.PayAmountDO;
import cn.wewintech.work.payAmount.service.PayAmountService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 付款申请
 * 
 * @author 
 * @email 
 * @date 2020-06-03 20:20:35
 */
 
@Controller
@RequestMapping("/work/payAmount")
public class PayAmountController {
	@Autowired
	private PayAmountService payAmountService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	@GetMapping()
	@RequiresPermissions("work:payAmount:payAmount")
	String PayAmount(){
	    return "work/payAmount/payAmount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:payAmount:payAmount")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PayAmountDO> payAmountList = payAmountService.list(query);
		for (PayAmountDO payAmountDO : payAmountList) {
			payAmountDO.setAuditState(dictService.findNameByValueAndType(payAmountDO.getAuditState(), "audit_state"));
		}
		int total = payAmountService.count(query);
		PageUtils pageUtils = new PageUtils(payAmountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:payAmount:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/payAmount/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:payAmount:edit")
	String edit(@PathVariable("id") String id,Model model){
		PayAmountDO payAmount = payAmountService.get(id);
		model.addAttribute("payAmount", payAmount);
	    return "work/payAmount/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:payAmount:add")
	public ResultObject save( PayAmountDO payAmount){
		if(payAmountService.save(payAmount)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:payAmount:edit")
	public ResultObject update( PayAmountDO payAmount){
		payAmountService.update(payAmount);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:payAmount:remove")
	public ResultObject remove( String id){
		if(payAmountService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:payAmount:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		payAmountService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
