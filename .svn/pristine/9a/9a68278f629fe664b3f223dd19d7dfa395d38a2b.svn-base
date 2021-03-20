package cn.wewintech.project.project.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
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

import cn.wewintech.project.project.domain.ProjectDO;
import cn.wewintech.project.project.domain.ProjectManageDO;
import cn.wewintech.project.project.service.ProjectManageService;
import cn.wewintech.project.project.service.ProjectService;
import cn.wewintech.activiti.domain.AuditInfoRO;
import cn.wewintech.activiti.service.ActTaskService;
import cn.wewintech.activiti.service.BusiAuditService;
import cn.wewintech.common.domain.SeqNoName;
import cn.wewintech.common.service.DictService;
import cn.wewintech.common.service.SeqnoService;
import cn.wewintech.common.utils.IdUtils;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.Query;
import cn.wewintech.common.utils.ResultObject;
import cn.wewintech.common.utils.ShiroUtils;

/**
 * 项目申请
 * 
 * @author 
 * @email 
 * @date 2020-05-25 09:00:27
 */
 
@Controller
@RequestMapping("/project/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private DictService dictService;
	@Autowired
	private SeqnoService seqNoService;
	@Autowired
	private ActTaskService actTaskService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private BusiAuditService busiAuditService;
	@Autowired
	private ProjectManageService projectManageService;
	
	
	@GetMapping()
	@RequiresPermissions("project:project:project")
	String Project(){
	    return "project/project/project";
	}
	@GetMapping("/projectplan")
	@RequiresPermissions("project:project:projectplan")
	String ProjectPlan(){
	    return "project/project/projectPlan";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("project:project:project")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProjectDO> projectList = projectService.list(query);
		for (ProjectDO projectDO : projectList) {
			projectDO.setProjectResource(dictService.findNameByValueAndType(projectDO.getProjectResource(), "project_resource"));
			projectDO.setProjectType(dictService.findNameByValueAndType(projectDO.getProjectType(), "project_type"));
			projectDO.setAuditState(dictService.findNameByValueAndType(projectDO.getAuditState(), "audit_state"));
		}
		int total = projectService.count(query);
		PageUtils pageUtils = new PageUtils(projectList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listplan")
	
	public PageUtils listPlan(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProjectDO> projectList = projectService.list(query);
		for (ProjectDO projectDO : projectList) {
			projectDO.setProjectResource(dictService.findNameByValueAndType(projectDO.getProjectResource(), "project_resource"));
			projectDO.setProjectType(dictService.findNameByValueAndType(projectDO.getProjectType(), "project_type"));
			projectDO.setAuditState(dictService.findNameByValueAndType(projectDO.getAuditState(), "audit_state"));
			projectDO.setProjectPlanState(dictService.findNameByValueAndType(projectDO.getProjectPlanState(), "project_plan_state"));
		}
		int total = projectService.count(query);
		PageUtils pageUtils = new PageUtils(projectList, total);
		return pageUtils;
	}
	


	
	@GetMapping("/add")
	@RequiresPermissions("project:project:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.CONFERENCE_NO_001.getCode());
		model.addAttribute("projectCode", nextId);
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("projectManager", projectManager);
	    return "project/project/add";
	}
	
	@GetMapping("/addPlan/{id}")
	@RequiresPermissions("project:project:addplan")
	String addPlan(Model model,@PathVariable("id") String id){
		ProjectDO project = projectService.get(id);
		model.addAttribute("project", project);
	    return "project/project/addPlan";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("project:project:edit")
	String edit(@PathVariable("id") String id,Model model){
		ProjectDO project = projectService.get(id);
		
		model.addAttribute("project", project);
	    return "project/project/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("project:project:add")
	public ResultObject save( ProjectDO project){
		project.setAuditState("0");
		if(projectService.save(project)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	
	/**
	 * 项目计划保存
	 */
	@ResponseBody
	@PostMapping("/savePlan")
	public ResultObject savePlan(@RequestBody ProjectDO projectDO){
		String[] arr1 = projectDO.getLineMes().split(";");
		String uuid = IdUtils.getUuid();
		
		for (int i = 0; i < arr1.length; i++) {
			String[] arr2 = arr1[i].split(",");
			
			for (int j = 0; j < arr2.length-7; j++) {
				ProjectManageDO projectManageDO = new ProjectManageDO();
				projectManageDO.addData();
				projectManageDO.setProjectPlanId(uuid);
				projectManageDO.setProjectId(projectDO.getId());
				projectDO.setProjectPlanId(uuid);
				projectDO.setProjectPlanState("0");
				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setProcess(arr2[j]);
				}
				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setUserId(arr2[j+1]);
				}

				if (!StringUtils.isEmpty(arr2[j])) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date parse;
					try {
						parse = simpleDateFormat.parse(arr2[j+2]);
						projectManageDO.setStartDate(parse);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				if (!StringUtils.isEmpty(arr2[j])) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date parse;
					try {
						parse = simpleDateFormat.parse(arr2[j+3]);
						projectManageDO.setEndDate(parse);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setRate(new BigDecimal(arr2[j+4]));
				}

				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setStage(arr2[j+5]);
				}

				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setProfessional(arr2[j+6]);
				}

				if (!StringUtils.isEmpty(arr2[j])) {
					projectManageDO.setDesign(arr2[j+7]);
				}
				projectManageDO.setAuditState("0");
				projectManageService.save(projectManageDO);
				projectService.update(projectDO);
			}
			
			
		}
		return ResultObject.ok();
	}
	
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("project:project:edit")
	public ResultObject update( ProjectDO project){
		projectService.update(project);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	//@RequiresPermissions("project:project:remove")
	public ResultObject remove( String id){
		if(projectService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("project:project:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		projectService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	/**
	 * 发送项目
	 */
	@PostMapping( "/send")
	@ResponseBody
	public ResultObject send( String id,String projectName){
		Map<String, Object> vars = new HashMap();
		String startProcess = actTaskService.startProcess("test_ac_01", "biz_project", id,projectName, vars);

		ProjectDO projectDO = new ProjectDO();
		
		projectDO.setId(id);
		projectDO.setAuditState("1");
		projectService.update(projectDO);
		
		if(startProcess==null){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 发送计划列表项目
	 */
	@PostMapping( "/sendPlanList")
	@ResponseBody
	public ResultObject sendPlanList( String id,String projectName,String projectPlanId){
		Map<String, Object> vars = new HashMap();
		String startProcess = actTaskService.startProcess("biz_project_manager", "biz_project_manager", projectPlanId,projectName+"-计划表", vars);

		ProjectDO projectDO = new ProjectDO();
		
		projectDO.setId(id);
		projectDO.setProjectPlanState("1");
		projectService.update(projectDO);
		
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
		ProjectDO project = projectService.get(id);
		project.setProjectResource(dictService.findNameByValueAndType(project.getProjectResource(), "project_resource"));
		project.setProjectType(dictService.findNameByValueAndType(project.getProjectType(), "project_type"));

		model.addAttribute("project", project);
		

		//查询审核人及审核意见
		List<AuditInfoRO> findAuditInfoList = busiAuditService.findAuditInfoList(id);
		
		model.addAttribute("findAuditInfoList", findAuditInfoList);
		model.addAttribute("taskId", taskId);
		model.addAttribute("processInstanceId", processInstanceId);
		model.addAttribute("id", id);
		
		
		
		return "project/project/editAudit";
	}
	
	
	/**
	 * 项目计划表进入跳转
	 */
	@GetMapping("/projectPlanList/{taskId}/{processInstanceId}/{id}")
	public String intoProjectPlanListPage(@PathVariable("taskId") String taskId,
			@PathVariable("processInstanceId") String processInstanceId,
			@PathVariable("id") String id,
			Model model,ProjectDO projectDO) {

		ProjectDO project = projectService.getByProjectPlanId(id);
		project.setProjectResource(dictService.findNameByValueAndType(project.getProjectResource(), "project_resource"));
		project.setProjectType(dictService.findNameByValueAndType(project.getProjectType(), "project_type"));

		model.addAttribute("project", project);
		
		Map<String, Object> vars = new HashMap();
		vars.put("projectPlanId", id);
		List<ProjectManageDO> projectPlanlist = projectManageService.list(vars);

		//查询审核人及审核意见
		List<AuditInfoRO> findAuditInfoList = busiAuditService.findAuditInfoList(id);
		
		model.addAttribute("projectPlanlist", projectPlanlist);
		model.addAttribute("findAuditInfoList", findAuditInfoList);
		model.addAttribute("taskId", taskId);
		model.addAttribute("processInstanceId", processInstanceId);
		model.addAttribute("id", id);
		
		
		
		return "project/project/projectPlanListAudit";
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
		
		
		ProjectDO projectDO = new ProjectDO();
		projectDO.setId(project.getId());
	
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("auditMsg", ShiroUtils.getUser().getName()+":  "+project.getTaskComment());
		taskService.complete(project.getTaskId(), variables, true);
		
		if ("1".equals(project.getAuditMsg())) {
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null==singleResult) {
				projectDO.setAuditState("4");
				
				projectService.update(projectDO);
			}else {
				projectDO.setAuditState("2");
				projectService.update(projectDO);
			}
		}else {
			//不通过删除
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null!=singleResult) {
				runtimeService.deleteProcessInstance(project.getProcessInstanceId(), "disagree");
			}
			projectDO.setAuditState("3");
			projectService.update(projectDO);
		}
		
		
		return ResultObject.ok();
	}
	
	
	/**
	 * 项目列表审核保存
	 */
	@ResponseBody
	@RequestMapping("/updateProjectPlanListAudit")
	public ResultObject updateProjectPlanListAudit( ProjectDO project){
		
		
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
		
		ProjectDO projectplan = projectService.getByProjectPlanId(project.getId());
		ProjectDO projectDO = new ProjectDO();
		projectDO.setId(projectplan.getId());
	
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("auditMsg", ShiroUtils.getUser().getName()+":  "+project.getTaskComment());
		
		
		taskService.complete(project.getTaskId(), variables, true);
		
		if ("1".equals(project.getAuditMsg())) {
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null==singleResult) {
				projectDO.setProjectPlanState("4");
				
				projectService.update(projectDO);
			}else {
				projectDO.setProjectPlanState("2");
				projectService.update(projectDO);
			}
		}else {
			//不通过删除
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null!=singleResult) {
				runtimeService.deleteProcessInstance(project.getProcessInstanceId(), "disagree");
			}
			projectDO.setProjectPlanState("3");
			projectService.update(projectDO);
		}
		
		
		return ResultObject.ok();
	}
	
	
	
}
