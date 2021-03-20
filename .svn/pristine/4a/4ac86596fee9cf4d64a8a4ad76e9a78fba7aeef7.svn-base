package cn.wewintech.project.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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

import cn.wewintech.project.project.domain.ProjectDO;
import cn.wewintech.project.project.domain.TechnicalEconomyDO;
import cn.wewintech.project.project.service.ProjectService;
import cn.wewintech.project.project.service.TechnicalEconomyService;
import cn.wewintech.activiti.domain.AuditInfoRO;
import cn.wewintech.activiti.service.ActTaskService;
import cn.wewintech.activiti.service.BusiAuditService;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 技经确认
 * 
 * @author 
 * @email 
 * @date 2020-05-29 17:03:47
 */
 
@Controller
@RequestMapping("/project/technicalEconomy")
public class TechnicalEconomyController {
	@Autowired
	private TechnicalEconomyService technicalEconomyService;
	@Autowired
	private DictService dictService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ActTaskService actTaskService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private BusiAuditService busiAuditService;
	@Autowired
	private RuntimeService runtimeService;
	@GetMapping()
	@RequiresPermissions("project:technicalEconomy:technicalEconomy")
	String TechnicalEconomy(){
	    return "project/technicalEconomy/technicalEconomy";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:technicalEconomy:technicalEconomy")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<TechnicalEconomyDO> technicalEconomyList = technicalEconomyService.list(query);
		for (TechnicalEconomyDO technicalEconomyDO : technicalEconomyList) {
			technicalEconomyDO.setAuditState(dictService.findNameByValueAndType(technicalEconomyDO.getAuditState(),"audit_state"));
		}
		int total = technicalEconomyService.count(query);
		PageUtils pageUtils = new PageUtils(technicalEconomyList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("project:technicalEconomy:add")
	String add(){
	    return "project/technicalEconomy/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:technicalEconomy:edit")
	String edit(@PathVariable("id") String id,Model model){
		TechnicalEconomyDO technicalEconomy = technicalEconomyService.get(id);
		model.addAttribute("technicalEconomy", technicalEconomy);
	    return "project/technicalEconomy/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:technicalEconomy:add")
	public ResultObject save( TechnicalEconomyDO technicalEconomy){
		if(technicalEconomyService.save(technicalEconomy)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:technicalEconomy:edit")
	public ResultObject update( TechnicalEconomyDO technicalEconomy){
		technicalEconomyService.update(technicalEconomy);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("project:technicalEconomy:remove")
	public ResultObject remove( String id){
		if(technicalEconomyService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:technicalEconomy:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		technicalEconomyService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	/**
	 * 发送项目
	 */
	@PostMapping( "/send")
	@ResponseBody
	@RequiresPermissions("project:technicalEconomy:send")
	public ResultObject send( String id,String projectName,String stage){
		Map<String, Object> vars = new HashMap();
		String startProcess = actTaskService.startProcess("biz_technical_economy", "biz_technical_economy", id,projectName+"--"+stage+"技经项目", vars);

		TechnicalEconomyDO technicalEconomyDO = new TechnicalEconomyDO();
		technicalEconomyDO.setAuditState("1");
		technicalEconomyDO.setId(id);
		
		technicalEconomyDO.editData();
		technicalEconomyService.update(technicalEconomyDO);
		
		if(startProcess==null){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	
	/**
	 * 项目进入跳转
	 */
	@GetMapping("/auditForm/{taskId}/{processInstanceId}/{id}")
	public String intoProjectAuditPage(@PathVariable("taskId") String taskId,
			@PathVariable("processInstanceId") String processInstanceId,
			@PathVariable("id") String id,
			Model model,ProjectDO projectDO) {
		TechnicalEconomyDO technicalEconomy = technicalEconomyService.get(id);
		ProjectDO project = projectService.get(technicalEconomy.getProjectId());
		project.setProjectResource(dictService.findNameByValueAndType(project.getProjectResource(), "project_resource"));
		project.setProjectType(dictService.findNameByValueAndType(project.getProjectType(), "project_type"));

		model.addAttribute("project", project);
		
		
		model.addAttribute("technicalEconomy", technicalEconomy);

		//查询审核人及审核意见
		List<AuditInfoRO> findAuditInfoList = busiAuditService.findAuditInfoList(id);
		
		model.addAttribute("findAuditInfoList", findAuditInfoList);
		model.addAttribute("taskId", taskId);
		model.addAttribute("processInstanceId", processInstanceId);
		model.addAttribute("id", id);
		
		
		
		return "project/technicalEconomy/editAudit";
	}
	
	
	/**
	 * 审核保存
	 */
	@ResponseBody
	@RequestMapping("/updateAudit")
	public ResultObject updateAudit( ProjectDO project){
		
		
		//添加审核记录
		AuditInfoRO auditInfoRO = new AuditInfoRO();
		auditInfoRO.addData();
		auditInfoRO.setBusiRecordId(project.getId());
		auditInfoRO.setProcInsId(project.getProcessInstanceId());
		if ("1".equals(project.getAuditMsg())) {
			auditInfoRO.setAuditOperateType("同意");
		}else {
			auditInfoRO.setAuditOperateType("退回");
		}
		auditInfoRO.setAuditOpinion(project.getTaskComment());
		auditInfoRO.setAuditUserId(ShiroUtils.getUserId().toString());
		Task singleResult2 = taskService.createTaskQuery().taskId(project.getTaskId()).singleResult();
		auditInfoRO.setTaskName(singleResult2.getName());
		auditInfoRO.setTaskDefKey(singleResult2.getTaskDefinitionKey());
		busiAuditService.insertAuditRecord(auditInfoRO);
		
		
		TechnicalEconomyDO technicalEconomyDO = new TechnicalEconomyDO();
		technicalEconomyDO.setId(project.getId());
	
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("auditMsg", ShiroUtils.getUser().getName()+":  "+project.getTaskComment());
		taskService.complete(project.getTaskId(), variables, true);
		
		if ("1".equals(project.getAuditMsg())) {
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null==singleResult) {
				technicalEconomyDO.setAuditState("4");
				
				technicalEconomyService.update(technicalEconomyDO);
			}else {
				technicalEconomyDO.setAuditState("2");
				technicalEconomyService.update(technicalEconomyDO);
			}
		}else {
			//不通过删除
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null!=singleResult) {
				runtimeService.deleteProcessInstance(project.getProcessInstanceId(), "disagree");
			}
			technicalEconomyDO.setAuditState("3");
			technicalEconomyService.update(technicalEconomyDO);
		}
		
		
		return ResultObject.ok();
	}
	
	
}
