package cn.wewintech.activiti.controller;

import cn.wewintech.activiti.service.ActTaskService;
import cn.wewintech.activiti.vo.ProcessVO;
import cn.wewintech.activiti.vo.TaskVO;
import cn.wewintech.common.aspect.LogAspect;
import cn.wewintech.common.service.LogService;
import cn.wewintech.common.utils.PageUtils;
import cn.wewintech.common.utils.ShiroUtils;
import cn.wewintech.system.domain.UserDO;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.history.HistoricVariableInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.ibatis.javassist.expr.NewArray;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.slf4j.LoggerFactory;

/**

 */
@RequestMapping("activiti/task")
@RestController
public class TaskController {
	
    @Autowired
    RepositoryService repositoryService;
    @Autowired
    FormService formService;
    @Autowired
    TaskService taskService;
    @Autowired
    ActTaskService actTaskService;
    @Autowired
    RuntimeService RuntimeService;
    @Autowired
    HistoryService historyService;
        
    
    @GetMapping("goto")
    public ModelAndView gotoTask(){
        return new ModelAndView("act/task/gotoTask");
    }

    @GetMapping("/gotoList")
    PageUtils list(int offset, int limit) {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery()
                .listPage(offset, limit);
        int count = (int) repositoryService.createProcessDefinitionQuery().count();
        List<Object> list = new ArrayList<>();
        for(ProcessDefinition processDefinition: processDefinitions){
            list.add(new ProcessVO(processDefinition));
        }

        PageUtils pageUtils = new PageUtils(list, count);
        return pageUtils;
    }

    @GetMapping("/form/{procDefId}")
    public void startForm(@PathVariable("procDefId") String procDefId  ,HttpServletResponse response) throws IOException {
        String formKey = actTaskService.getFormKey(procDefId, null);
        response.sendRedirect(formKey);
    }

    @GetMapping("/form/{procDefId}/{taskId}/{executionId}")
    public void form(@PathVariable("procDefId") String procDefId,@PathVariable("taskId") String taskId ,
    		@PathVariable("executionId") String executionId,HttpServletResponse response) throws IOException {
        // ????????????XML????????????KEY

        String formKey = actTaskService.getFormKey(procDefId, taskId);
      String processInstanceId = RuntimeService.createExecutionQuery().executionId(executionId).singleResult().getProcessInstanceId();
      String id = RuntimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getBusinessKey();

        response.sendRedirect(formKey+"/"+taskId+"/"+processInstanceId+"/"+id);
    }
    
    @GetMapping("/pointSelect/{procDefId}/{businessId}/{executionId}")
    public ModelAndView pointSelect(@PathVariable("procDefId") String procDefId,@PathVariable("businessId") String businessId ,
    		@PathVariable("executionId") String executionId,HttpServletResponse response,ModelAndView model) {
        // ????????????XML????????????KEY
    	 List<ProcessVO> list = new ArrayList<>();
    	List<HistoricVariableInstance> listHis = historyService.createHistoricVariableInstanceQuery().executionId(executionId).variableName("auditMsg").list();
    	for (HistoricVariableInstance historicVariableInstance : listHis) {
			list.add(new ProcessVO(historicVariableInstance));
		}
    	List<Task> list2 = taskService.createTaskQuery().executionId(executionId).list();
    	String assignName="";
    	for (Task task : list2) {
			String assignee = task.getAssignee();
			assignName+="  "+assignee;
		}
    	ProcessInstance singleResult = RuntimeService.createProcessInstanceQuery().processInstanceBusinessKey(businessId).singleResult();
       if (null==singleResult) {
		assignName="??????????????????!";
	}
     
       model.addObject("list", list);
       model.addObject("assignName", assignName);
       model.setViewName("act/task/pointSelect");
       return model;
    }

    @GetMapping("/todo")
    ModelAndView todo(){
        return new ModelAndView("act/task/todoTask");
    }

    @GetMapping("/todoList")
    List<TaskVO> todoList(){
    	String username = ShiroUtils.getUser().getUsername();
    	
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(username).list();
        List<TaskVO> taskVOS =  new ArrayList<>();
        for(Task task : tasks){
            TaskVO taskVO = new TaskVO(task);
            taskVOS.add(taskVO);
        }
        return taskVOS;
    }


    /**
     * ????????????????????????
     */
    @RequestMapping(value = "/trace/photo/{procDefId}/{execId}")
    public void tracePhoto(@PathVariable("procDefId") String procDefId, @PathVariable("execId") String execId, HttpServletResponse response) throws Exception {
        InputStream imageStream = actTaskService.tracePhoto(procDefId, execId);

        // ?????????????????????????????????
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }


    
    @GetMapping("/historyTask")
    PageUtils historyTask(int offset, int limit) {
        List<ProcessVO> list = new ArrayList<>();
        String username = ShiroUtils.getUser().getUsername();
		
        StringBuffer stringBuffer = new StringBuffer("");
        HashSet<String> hashSet = new HashSet<String>();
		  List<HistoricTaskInstance> listPage2 =
		  historyService.createHistoricTaskInstanceQuery().taskAssigneeLike(username).
		  orderByTaskCreateTime().desc().list(); 
		  for(HistoricTaskInstance historicTaskInstance : listPage2) {
			  String processInstanceId = historicTaskInstance.getProcessInstanceId();
			  stringBuffer.append("'").append(processInstanceId).append("',");
			  if (!hashSet.contains(processInstanceId)) {
				  hashSet.add(processInstanceId);
			}
		  }
		  List<HistoricProcessInstance> listPage =null;
        try {
			
		
         listPage = historyService.createHistoricProcessInstanceQuery().processInstanceIds(hashSet)
        		.orderByProcessInstanceStartTime().desc().listPage(offset, limit);
        } catch (Exception e) {
			// TODO: handle exception
        	System.out.println(e.getMessage());
		}
        int count = (int)historyService.createHistoricVariableInstanceQuery().count();
        if (listPage!=null) {
        	
            for (HistoricProcessInstance his : listPage) {
            	  HistoricVariableInstance singleResult = historyService.createHistoricVariableInstanceQuery().executionId(his.getId()).variableName("title").singleResult();
            	list.add(new ProcessVO(his,singleResult.getValue().toString()));
    		}
          
		}
        
        
        PageUtils pageUtils = new PageUtils(list, count);
        
        return pageUtils;
    }
}
