package cn.wewintech.activiti.utils;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**

 */
@Component
public class ActivitiUtils {
	private static ThreadLocal<String> startProcOfBusinessIdThreadLocal = new ThreadLocal();
    /**
     * 根据taskId查找businessKey
     */
    @Autowired
    TaskService taskService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    HistoryService historyService;
    @Autowired
    IdentityService identityService;
    
    
	
	  public String startProcess() {
		  Map<String, Object> vars = new HashMap<String, Object>();
	  ProcessInstance startProcessInstanceById = runtimeService.startProcessInstanceById("test_ac_01", "biz_project",
			  vars);
	  return startProcessInstanceById.getProcessInstanceId();
	  
	  }
	 
    
    public String getBusinessKeyByTaskId(String taskId){
        Task task = taskService
                .createTaskQuery()
                .taskId(taskId)
                .singleResult();
        ProcessInstance pi = runtimeService
                .createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();
        return pi.getBusinessKey();
    }

    public Task getTaskByTaskId(String taskId){
        Task task = taskService
                .createTaskQuery()
                .taskId(taskId)
                .singleResult();
        return task;
    }
}
