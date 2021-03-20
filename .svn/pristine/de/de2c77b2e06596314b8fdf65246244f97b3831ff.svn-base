package cn.wewintech.work.print.controller;

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

import cn.wewintech.work.print.domain.PrintPaperDO;
import cn.wewintech.work.print.service.PrintPaperService;
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
import cn.wewintech.project.project.domain.ProjectDO;
import cn.wewintech.project.project.service.ProjectService;

/**
 * 打图申请
 * 
 * @author 
 * @email 
 * @date 2020-06-04 09:57:59
 */
 
@Controller
@RequestMapping("/work/printPaper")
public class PrintPaperController {
	@Autowired
	private PrintPaperService printPaperService;
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
	
	@GetMapping()
	@RequiresPermissions("work:printPaper:printPaper")
	String PrintPaper(){
	    return "work/printPaper/printPaper";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("work:printPaper:printPaper")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PrintPaperDO> printPaperList = printPaperService.list(query);
		for (PrintPaperDO printPaperDO : printPaperList) {
			printPaperDO.setAuditState(dictService.findNameByValueAndType(printPaperDO.getAuditState(), "audit_state"));
		}
		int total = printPaperService.count(query);
		PageUtils pageUtils = new PageUtils(printPaperList, total);
		return pageUtils;
	}
	
	@GetMapping("/openProject")
	@RequiresPermissions("work:printPaper:printPaper")
	public String openProject(Model model) {
		return "work/printPaper/openProject";
	}
	
	
	
	@ResponseBody
	@GetMapping("/openProjectList")
	@RequiresPermissions("work:printPaper:printPaper")
	public PageUtils openProjectList(@RequestParam Map<String, Object> params){
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
	
	@GetMapping("/add")
	@RequiresPermissions("work:printPaper:add")
	String add(Model model){
		String nextId = this.seqNoService.nextId(SeqNoName.REINSURANCE_NO_001.getCode());
		model.addAttribute("workCode", nextId);	
		String projectManager = ShiroUtils.getUser().getName();
		model.addAttribute("applyUser", projectManager);
	    return "work/printPaper/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("work:printPaper:edit")
	String edit(@PathVariable("id") String id,Model model){
		PrintPaperDO printPaper = printPaperService.get(id);

		
		model.addAttribute("printPaper", printPaper);
	    return "work/printPaper/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("work:printPaper:add")
	public ResultObject save( PrintPaperDO printPaper){
		if(printPaperService.save(printPaper)>0){
			return ResultObject.ok();
		}
		return ResultObject.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("work:printPaper:edit")
	public ResultObject update( PrintPaperDO printPaper){
		printPaperService.update(printPaper);
		return ResultObject.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("work:printPaper:remove")
	public ResultObject remove( String id){
		if(printPaperService.remove(id)>0){
		return ResultObject.ok();
		}
		return ResultObject.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("work:printPaper:batchRemove")
	public ResultObject remove(@RequestParam("ids[]") String[] ids){
		printPaperService.batchRemove(ids);
		return ResultObject.ok();
	}
	
	@ResponseBody
	@PostMapping("/findPrintTimes")
	public int  findPrintTimes(String id,Map<String, Object> map) {
		String userId = ShiroUtils.getUser().getUserId().toString();
		map.put("projectId", id);
		map.put("userId", userId);
		List<PrintPaperDO> findPrintTimes = printPaperService.findPrintTimes(map);
		if (findPrintTimes.size()>0) {
			int times = findPrintTimes.get(0).getTimes();
			/*PrintPaperDO printPaper = new PrintPaperDO();
			*
			 * printPaper.setId(findPrintTimes.get(0).getId());
			 * printPaper.setTimes(times+1); printPaperService.update(printPaper);
			 */
			return times+1;
		}else {
			/*
			 * PrintPaperDO printPaper = new PrintPaperDO();
			 * printPaper.setId(IdUtils.getUuid()); printPaper.setProjectId(id);
			 * printPaper.setUserId(userId); printPaper.setTimes(1);
			 * printPaperService.insertPrintTimes(printPaper);
			 */
			return 1;
		}
		
	}
	



	/**
	 * 发送项目
	 */
	@PostMapping( "/send")
	@ResponseBody
	public ResultObject send( String id,String projectName){
		Map<String, Object> vars = new HashMap();
		String startProcess = actTaskService.startProcess("biz_print_paper", "biz_print_paper", id,projectName+"--打图审核", vars);
	
		PrintPaperDO printPaperDO = new PrintPaperDO();
		
		printPaperDO.setId(id);
		printPaperDO.setAuditState("1");
		printPaperService.update(printPaperDO);
		
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
			Model model) {
//		ProjectDO project = projectService.get(id);
//		project.setProjectResource(dictService.findNameByValueAndType(project.getProjectResource(), "project_resource"));
//		project.setProjectType(dictService.findNameByValueAndType(project.getProjectType(), "project_type"));
//
//		model.addAttribute("project", project);
		
		PrintPaperDO printPaper = printPaperService.get(id);
		
		  Map<String, Object> map = new HashMap<String, Object>();
			String userId = ShiroUtils.getUser().getUserId().toString();
			map.put("projectId", printPaper.getProjectId());
			map.put("userId", userId);
			List<PrintPaperDO> findPrintTimes = printPaperService.findPrintTimes(map);
			if (findPrintTimes.size()>0) {
				int times = findPrintTimes.get(0).getTimes();
				/*PrintPaperDO printPaper = new PrintPaperDO();
				*
				 * printPaper.setId(findPrintTimes.get(0).getId());
				 * printPaper.setTimes(times+1); printPaperService.update(printPaper);
				 */
				printPaper.setPrintTimes(times+1);
			}else {
				/*
				 * PrintPaperDO printPaper = new PrintPaperDO();
				 * printPaper.setId(IdUtils.getUuid()); printPaper.setProjectId(id);
				 * printPaper.setUserId(userId); printPaper.setTimes(1);
				 * printPaperService.insertPrintTimes(printPaper);
				 */
				printPaper.setPrintTimes(1);
			}
			
		//查询审核人及审核意见
		List<AuditInfoRO> findAuditInfoList = busiAuditService.findAuditInfoList(id);
		
		model.addAttribute("findAuditInfoList", findAuditInfoList);
		model.addAttribute("taskId", taskId);
		model.addAttribute("processInstanceId", processInstanceId);
		model.addAttribute("id", id);
		model.addAttribute("printPaper", printPaper);
		
		
		return "/work/printPaper/editAudit";
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
		
		
		PrintPaperDO printPaperDO = new PrintPaperDO();
		printPaperDO.setId(project.getId());
	
		Map<String, Object> variables=new HashMap<String, Object>();
		variables.put("auditMsg", ShiroUtils.getUser().getName()+":  "+project.getTaskComment());
		taskService.complete(project.getTaskId(), variables, true);
		
		if ("1".equals(project.getAuditMsg())) {
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null==singleResult) {
				printPaperDO.setAuditState("4");
				
				printPaperService.update(printPaperDO);
				
				
				PrintPaperDO printPaperDO2 = printPaperService.get(project.getId());
				//审核通过更新打图次数
			   Map<String, Object> map = new HashMap<String, Object>();
				String userId = ShiroUtils.getUser().getUserId().toString();
				map.put("projectId", printPaperDO2.getProjectId());
				map.put("userId", userId);
				List<PrintPaperDO> findPrintTimes = printPaperService.findPrintTimes(map);
				if (findPrintTimes.size()>0) {
					int times = findPrintTimes.get(0).getTimes();
					 PrintPaperDO printPaper = new PrintPaperDO();
					
					  printPaper.setId(findPrintTimes.get(0).getId());
					  printPaper.setTimes(times+1); 
					  printPaperService.updatePrintTimes(printPaper);
					
				}else {
					
					  PrintPaperDO printPaper = new PrintPaperDO();
					  printPaper.setId(IdUtils.getUuid()); 
					  printPaper.setProjectId(printPaperDO2.getProjectId());
					  printPaper.setUserId(userId);
					  printPaper.setTimes(1);
					  printPaperService.insertPrintTimes(printPaper);

				}
	
				
			}else {
				printPaperDO.setAuditState("2");
				printPaperService.update(printPaperDO);
			}
		}else {
			//不通过删除
			ProcessInstance singleResult = runtimeService.createProcessInstanceQuery().processInstanceId(project.getProcessInstanceId())
					.singleResult();
			if (null!=singleResult) {
				runtimeService.deleteProcessInstance(project.getProcessInstanceId(), "disagree");
			}
			printPaperDO.setAuditState("3");
			printPaperService.update(printPaperDO);
		}
		
		
		return ResultObject.ok();
	}
	
	
}