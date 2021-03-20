package cn.wewintech.work.invoice.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wewintech.work.invoice.domain.InvoiceDO;
import cn.wewintech.work.invoice.service.InvoiceService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.IdUtils;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 开票申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 14:43:34
 */
 
@Controller
@RequestMapping("/work/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private DictService dictService;
	@Autowired
	private SeqnoService seqNoService;
	
	@GetMapping()
	@RequiresPermissions("work:invoice:invoice")
	String Invoice(){
	    return "work/invoice/invoice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:invoice:invoice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<InvoiceDO> invoiceList = invoiceService.list(query);
		for (InvoiceDO invoiceDO : invoiceList) {
			invoiceDO.setInvoiceType(dictService.findNameByValueAndType(invoiceDO.getInvoiceType(), "invoice_type"));
			invoiceDO.setSpecializeType(dictService.findNameByValueAndType(invoiceDO.getSpecializeType(), "specialize_type"));
			invoiceDO.setBackCostType(dictService.findNameByValueAndType(invoiceDO.getBackCostType(), "back_cost_type"));
			invoiceDO.setContractProgress(dictService.findNameByValueAndType(invoiceDO.getContractProgress(), "contract_progress"));
			invoiceDO.setAuditState(dictService.findNameByValueAndType(invoiceDO.getAuditState(), "audit_state"));
		}
		int total = invoiceService.count(query);
		PageUtils pageUtils = new PageUtils(invoiceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:invoice:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/invoice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:invoice:edit")
	String edit(@PathVariable("id") String id,Model model){
		//InvoiceDO invoice = invoiceService.get(id);
		//model.addAttribute("invoice", invoice);
	    return "work/invoice/edit";
	}
	
	@GetMapping("/view/{id}")
	String view(@PathVariable("id") String id,Model model){
	    InvoiceDO invoice = invoiceService.get(id);
	    List<InvoiceDO> findlist = invoiceService.find(id);
		model.addAttribute("invoice", invoice);
		model.addAttribute("findlist", findlist);
	    return "work/invoice/view";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:invoice:add")
	public ResultObject save( InvoiceDO invoice){		
		invoiceService.save(invoice);
		
		InvoiceDO invoiceDO = new InvoiceDO();
		String[] split = invoice.getStr().split(";");
		if (!StringUtils.isEmpty(split)) {

		for (int i = 0; i < split.length; i++) {
			String[] arr2 = split[i].split(",");
			invoiceDO.setInvoiceId(invoice.getId());
			for (int j = 0; j < arr2.length-2; j++) {
				
				if(!StringUtils.isEmpty(arr2[j])) {
					invoiceDO.setInvoiceName(arr2[j]);
				}
				if(!StringUtils.isEmpty(arr2[j+1])) {
					invoiceDO.setAmount(new BigDecimal(arr2[j+1]));
				}
				if(!StringUtils.isEmpty(arr2[j+2])) {
					invoiceDO.setProjectName(arr2[j+2]);
				}
				invoiceDO.setId(IdUtils.getUuid());
				invoiceService.saveInvoice(invoiceDO);
			}
		}
		
		}
	
		return ResultObject.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:invoice:edit")
	public ResultObject update( InvoiceDO invoice){
		invoiceService.update(invoice);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:invoice:remove")
	public ResultObject remove( String id){
		if(invoiceService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:invoice:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		invoiceService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
