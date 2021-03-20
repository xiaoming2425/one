package cn.wewintech.activiti.vo;

import java.util.Date;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class ProcessVO {
    private String id;
    private String name;
    private String deploymentId;
    
    private String proInsId;
    private String projectName;
    private Date startDate;
    private Date endDate;
    private String proDefId;
    private String businessId;
    private Date createTime;
    private String value;
    
    
    
    
    public String getProDefId() {
		return proDefId;
	}

	public void setProDefId(String proDefId) {
		this.proDefId = proDefId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ProcessVO(HistoricProcessInstance his,String projectName) {
    	this.id=his.getId();
    	this.projectName=projectName;
    	this.startDate=his.getStartTime();
    	this.endDate=his.getEndTime();
    	this.proDefId=his.getProcessDefinitionId();
    	this.businessId=his.getBusinessKey();
    }
    
    public ProcessVO(HistoricVariableInstance his) {
    	this.id=his.getId();
    	this.createTime=his.getCreateTime();
    	this.value=(String)his.getValue();
    	
    }
    

    public ProcessVO(Deployment processDefinition) {
        this.setId(processDefinition.getId());
        this.name = processDefinition.getName();
    }

    public ProcessVO(ProcessDefinition processDefinition) {
        this.setId(processDefinition.getId());
        this.name = processDefinition.getName();
        this.deploymentId = processDefinition.getDeploymentId();
    }
    

    public String getProInsId() {
		return proInsId;
	}

	public void setProInsId(String proInsId) {
		this.proInsId = proInsId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }
}
