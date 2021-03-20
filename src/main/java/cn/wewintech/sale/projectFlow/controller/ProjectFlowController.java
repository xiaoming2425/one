package cn.wewintech.sale.projectFlow.controller;

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

import cn.wewintech.sale.projectFlow.domain.ProjectFlowDO;
import cn.wewintech.sale.projectFlow.service.ProjectFlowService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 
 * 
 * @author 
 * @email 
 * @date 2020-06-01 11:52:24
 */
 
@Controller
@RequestMapping("/sale/projectFlow")
public class ProjectFlowController {
	@Autowired
	private ProjectFlowService projectFlowService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private DictService dictService;
	
	@GetMapping()
	@RequiresPermissions("sale:projectFlow:projectFlow")
	String ProjectFlow(){
	    return "sale/projectFlow/projectFlow";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sale:projectFlow:projectFlow")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProjectFlowDO> projectFlowList = projectFlowService.list(query);
		int total = projectFlowService.count(query);
		PageUtils pageUtils = new PageUtils(projectFlowList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sale:projectFlow:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.CUSTOMER_NO_002.getCode());
		model.addAttribute("projectCode", nextId);
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("projectManager", projectManager);
	    return "sale/projectFlow/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sale:projectFlow:edit")
	String edit(@PathVariable("id") String id,Model model){
		ProjectFlowDO projectFlow = projectFlowService.get(id);
		model.addAttribute("projectFlow", projectFlow);
	    return "sale/projectFlow/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sale:projectFlow:add")
	public ResultObject save( ProjectFlowDO projectFlow){
		if(projectFlowService.save(projectFlow)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sale:projectFlow:edit")
	public ResultObject update( ProjectFlowDO projectFlow){
		projectFlowService.update(projectFlow);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sale:projectFlow:remove")
	public ResultObject remove( String id){
		if(projectFlowService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sale:projectFlow:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		projectFlowService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	/**
	 * 跟单
	 */
	@GetMapping( "/resetPwd")
	@RequiresPermissions("sale:projectFlow:resetPwd")
	public String  resetPwd( String id,Model model){
		List<ProjectFlowDO> list = projectFlowService.flowlist(id);
		for (ProjectFlowDO projectFlowDO : list) {
			projectFlowDO.setSaleType(dictService.findNameByValueAndType(projectFlowDO.getSaleType(), "sale_type"));
		}
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("projectManager", projectManager);
		model.addAttribute("list", list);
		model.addAttribute("id", id);
		return "sale/projectFlow/flowListAdd";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/flowSave")
	public ResultObject flowSave( ProjectFlowDO projectFlow){
		if(projectFlowService.flowSave(projectFlow)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
}
