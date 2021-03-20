package cn.wewintech.sale.customerback.controller;

import java.util.HashMap;
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

import cn.wewintech.sale.customer.domain.CustomerDO;
import cn.wewintech.sale.customer.service.CustomerService;
import cn.wewintech.sale.customerback.domain.CustomerBackDO;
import cn.wewintech.sale.customerback.service.CustomerBackService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;

/**
 * 客户回访
 * 
 * @author 
 * @email 
 * @date 2020-05-12 09:19:30
 */
 
@Controller
@RequestMapping("/sale/customerBack")
public class CustomerBackController {
	@Autowired
	private CustomerBackService customerBackService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("sale:customerBack:customerBack")
	String CustomerBack(){
	    return "sale/customerBack/customerBack";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sale:customerBack:customerBack")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CustomerDO> customerList = customerService.list(query);
		for (CustomerDO customerDO : customerList) {
			customerDO.setCustomerType(dictService.findNameByValueAndType(customerDO.getCustomerType(), "customer_type"));
			customerDO.setType(dictService.findNameByValueAndType(customerDO.getType(), "type"));
			customerDO.setCustomerResource(dictService.findNameByValueAndType(customerDO.getCustomerResource(), "customer_resource"));
		}
		int total = customerService.count(query);
		PageUtils pageUtils = new PageUtils(customerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{id}")
	@RequiresPermissions("sale:customerBack:add")
	String add(@PathVariable("id") String id,Model model){
		CustomerDO customerDO = customerService.get(id);
		customerDO.setCustomerType(dictService.findNameByValueAndType(customerDO.getCustomerType(), "customer_type"));
		customerDO.setType(dictService.findNameByValueAndType(customerDO.getType(), "type"));
		customerDO.setCustomerResource(dictService.findNameByValueAndType(customerDO.getCustomerResource(), "customer_resource"));
	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("customerId", id);
		List<CustomerBackDO> list = customerBackService.list(params);
		
		
		model.addAttribute("customerDO", customerDO);
		model.addAttribute("list", list);
		
	    return "sale/customerBack/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sale:customerBack:edit")
	String edit(@PathVariable("id") String id,Model model){
		CustomerBackDO customerBack = customerBackService.get(id);
		
		model.addAttribute("customerBack", customerBack);
	    return "sale/customerBack/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sale:customerBack:add")
	public ResultObject save(@RequestBody CustomerBackDO customerBack){
		if(customerBackService.save(customerBack)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sale:customerBack:edit")
	public ResultObject update( CustomerBackDO customerBack){
		customerBackService.update(customerBack);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sale:customerBack:remove")
	public ResultObject remove( String id){
		if(customerBackService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sale:customerBack:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		customerBackService.batchRemove(ids);
		return ResultObject.ok();
	}
	/**
	 * 
	 * @param ids
	 * @return
	 */
	@GetMapping( "/backlist")
	@RequiresPermissions("sale:customerBack:backlist")
	public String backlist(@RequestParam("customerId") String customerId,Model model){
		model.addAttribute("customerId", customerId);
		return "sale/customerBack/backlist";
	}
	
	@ResponseBody
	@GetMapping("/backtable")
	public List<CustomerBackDO> backTable(@RequestParam Map<String, Object> params){
		//查询列表数据
		
		List<CustomerBackDO> list = customerBackService.list(params);
		return list;
	}
	
}
