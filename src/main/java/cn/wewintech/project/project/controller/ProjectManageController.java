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
import cn.wewintech.project.project.domain.ProjectManageDO;
import cn.wewintech.project.project.service.ProjectManageService;
import cn.wewintech.project.project.service.ProjectService;
import cn.wewintech.activiti.domain.AuditInfoRO;
import cn.wewintech.activiti.service.ActTaskService;
import cn.wewintech.activiti.service.BusiAuditService;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 任务计划管理
 * 
 * @author 
 * @email 
 * @date 2020-05-28 09:05:26
 */
 
@Controller
@RequestMapping("/project/projectManage")
public class ProjectManageController {
	@Autowired
	private ProjectManageService projectManageService;
	@Autowired
	private DictService dictService;
	@Autowired
	private ActTaskService actTaskService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private BusiAuditService busiAuditService;
	@Autowired
	private ProjectService projectService;
	
	@GetMapping()
	//@RequiresPermissions("project:projectManage:projectManage")
	String ProjectManage(){
	    return "project/projectManage/projectManage";
	}
	
	@GetMapping("/projectplanPro")
	String ProjectplanPro(){
	    return "project/projectManage/projectplanPro";
	}
	
	@ResponseBody
	@GetMapping("/list")
	//@RequiresPermissions("project:projectManage:projectManage")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProjectManageDO> projectManageList = projectManageService.listManager(query);
		for (ProjectManageDO projectManageDO : projectManageList) {
			projectManageDO.setProjectPlanState(dictService.findNameByValueAndType(projectManageDO.getProjectPlanState(), "project_plan_state"));
			projectManageDO.setAuditState(dictService.findNameByValueAndType(projectManageDO.getAuditState(), "audit_state"));
		}
		int total = projectManageService.count(query);
		PageUtils pageUtils = new PageUtils(projectManageList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("project:projectManage:add")
	String add(){
	    return "project/projectManage/add";
	}

	@GetMapping("/edit/{id}")
	//@RequiresPermissions("project:projectManage:edit")
	String edit(@PathVariable("id") String id,Model model){
		ProjectManageDO projectManage = projectManageService.get(id);
		model.addAttribute("projectManage", projectManage);
	    return "project/projectManage/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("project:projectManage:add")
	public ResultObject save( ProjectManageDO projectManage){
		if(projectManageService.save(projectManage)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	//@RequiresPermissions("project:projectManage:edit")
	public ResultObject update( ProjectManageDO projectManage){
		projectManageService.update(projectManage);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	//@RequiresPermissions("project:projectManage:remove")
	public ResultObject remove( String id){
		if(projectManageService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:projectManage:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		projectManageService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	
	/**
	 * 发送项目
	 */
	@PostMapping( "/send")
	@ResponseBody
	public ResultObject send( String id,String projectName){
		Map<String, Object> vars = new HashMap();
		String startProcess = actTaskService.startProcess("project_plan_audit", "biz_project_manage", id,projectName+"-计划完成审核", vars);

		ProjectManageDO projectManageDO = new ProjectManageDO();
		projectManageDO.setId(id);
		projectManageDO.setAuditState("1");
		projectManageDO.editData();
		projectManageService.update(projectManageDO);
		
		if(startProcess==null){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 项目计划表进入跳转
	 */
	@GetMapping("/auditForm/{taskId}/{processInstanceId}/{id}")
	public String intoProjectPlanListPage(@PathVariable("taskId") String taskId,
			@PathVariable("processInstanceId") String processInstanceId,
			@PathVariable("id") String id,
			Model model) {
		
		ProjectManageDO projectManageDO = projectManageService.get(id);

		Map<String, Object> vars = new HashMap();
		vars.put("projectPlanId", projectManageDO.getProjectPlanId());
		List<ProjectManageDO> projectPlanlist = projectManageService.list(vars);

		//查询审核人及审核意见
		List<AuditInfoRO> findAuditInfoList = busiAuditService.findAuditInfoList(id);
		
		ProjectDO byProjectPlanId = projectService.getByProjectPlanId(projectManageDO.getProjectPlanId());
		
		model.addAttribute("project", byProjectPlanId);
		model.addAttribute("projectManage", projectManageDO);
		model.addAttribute("projectPlanlist", projectPlanlist);
		model.addAttribute("findAuditInfoList", findAuditInfoList);
		model.addAttribute("taskId", taskId);
		model.addAttribute("processInstanceId", processInstanceId);
		model.addAttribute("id", id);

		return "project/projectManage/projectPlanAudit";
	}
	
	
	
	
	/**
	 * 审核保存
	 */
	@ResponseBody
	@RequestMapping("/updateProjectPlanAudit")
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
		
		
		ProjectManageDO projectManageDO = new ProjectManageDO();
		projectManageDO.setId(project.getId());
	
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("auditMsg", ShiroUtils.getUser().getName()+":  "+project.getTaskComment());
		taskService.complete(project.getTaskId(), variables, true);
		
		if ("1".equals(project.getAuditMsg())) {
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null==singleResult) {
				projectManageDO.setAuditState("4");
				
				projectManageService.update(projectManageDO);
			}else {
				projectManageDO.setAuditState("2");
				projectManageService.update(projectManageDO);
			}
		}else {
			//不通过删除
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null!=singleResult) {
				runtimeService.deleteProcessInstance(project.getProcessInstanceId(), "disagree");
			}
			projectManageDO.setAuditState("3");
			projectManageService.update(projectManageDO);
		}
		
		
		return ResultObject.ok();
	}
	
}
