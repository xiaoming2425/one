package cn.wewintech.work.receipt.controller;

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

import cn.wewintech.work.receipt.domain.ReceiptDO;
import cn.wewintech.work.receipt.service.ReceiptService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 报销申请
 * 
 * @author 
 * @email 
 * @date 2020-06-02 10:33:30
 */
 
@Controller
@RequestMapping("/work/receipt")
public class ReceiptController {
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("work:receipt:receipt")
	String Receipt(){
	    return "work/receipt/receipt";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:receipt:receipt")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ReceiptDO> receiptList = receiptService.list(query);
		int total = receiptService.count(query);
		PageUtils pageUtils = new PageUtils(receiptList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("work:receipt:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/receipt/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:receipt:edit")
	String edit(@PathVariable("id") String id,Model model){
		ReceiptDO receipt = receiptService.get(id);
		model.addAttribute("receipt", receipt);
	    return "work/receipt/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:receipt:add")
	public ResultObject save( ReceiptDO receipt){
		if(receiptService.save(receipt)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:receipt:edit")
	public ResultObject update( ReceiptDO receipt){
		receiptService.update(receipt);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:receipt:remove")
	public ResultObject remove( String id){
		if(receiptService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:receipt:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		receiptService.batchRemove(ids);
		return ResultObject.ok();
	}
	
}
