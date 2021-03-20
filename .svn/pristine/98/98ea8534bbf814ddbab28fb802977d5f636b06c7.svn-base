package cn.wewintech.sale.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
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

import com.alibaba.fastjson.JSON;

import com.sun.tools.internal.xjc.reader.Ring;

import cn.wewintech.sale.customer.domain.CustomerDO;
import cn.wewintech.sale.customer.service.CustomerService;
import cn.wewintech.system.domain.DeptDO;
import cn.wewintech.system.domain.UserDO;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.domain.TreeNode;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;

/**
 * 客户表
 * 
 * @author 
 * @email 
 * @date 2020-05-11 16:54:44
 */
 
@Controller
@RequestMapping("/sale/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DictService dictService;
	@Autowired
	private SeqnoService seqNoService;
	
	@GetMapping()
	@RequiresPermissions("sale:customer:customer")
	String Customer(){
	    return "sale/customer/customer";
	}
	//项目获取客户弹出层
	@GetMapping("/customerPro")
	String customerPro(){
	    return "sale/customer/customerPro";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sale:customer:customer")
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
	
	@GetMapping("/add")
	@RequiresPermissions("sale:customer:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.CUSTOMER_NO_002.getCode());
		model.addAttribute("customerNo", nextId);
	    return "sale/customer/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sale:customer:edit")
	String edit(@PathVariable("id") String id,Model model){
		CustomerDO customer = customerService.get(id);
		model.addAttribute("customer", customer);
	    return "sale/customer/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sale:customer:add")
	public ResultObject save( @RequestBody CustomerDO customer){
		if(customerService.save(customer)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sale:customer:edit")
	public ResultObject update( @RequestBody CustomerDO customer){
		customerService.update(customer);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sale:customer:remove")
	public ResultObject remove( String id){
		if(customerService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sale:customer:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		customerService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	
	/**
	 * 加载公司树形菜单
	 */
	@PostMapping( "/tree")
	@ResponseBody
	public String  tree(){

		List<TreeNode> findDeptList = customerService.findDeptList();
		
		String jsonString = JSON.toJSONString(findDeptList);
		return jsonString;

	}
	
	/**
	 * 加载公司人员树形菜单
	 */
	@SuppressWarnings("null")
	@PostMapping( "/userTree")
	@ResponseBody
	public String  userTree(){

		List<TreeNode> findDeptList = customerService.findDeptList();
		List<UserDO> findAllList = customerService.findAllList();
		List<TreeNode> intersection=new ArrayList<TreeNode>();
		intersection.addAll(findDeptList);
		for (TreeNode treeNode : findDeptList) {
			for (UserDO userDO : findAllList) {
				if (treeNode.getId().toString().equals(userDO.getDeptId().toString())) {
					
					intersection.add(new TreeNode(Integer.valueOf(userDO.getUserId().toString()), treeNode.getId(), userDO.getName(), false, true));
				}
			}
			
		}
		
		String jsonString = JSON.toJSONString(intersection);
		return jsonString;

	}
	
}
