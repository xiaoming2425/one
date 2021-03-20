package cn.wewintech.project.project.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.wewintech.common.core.DataModel;


/**
 * 项目申请
 * 
 * @author 
 * @email 
 * @date 2020-05-25 09:00:27
 */
public class ProjectDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//项目编号
	private String projectNo;
	//项目来源(1.社会客户出资工程2供电公司出资直报3.个电力设计院分包4.供电公司三产电力)
	private String projectResource;
	//项目类型(1.线路2.网改3.变电4.配电)
	private String projectType;
	//项目名称
	private String projectName;
	//委托单位
	private String customerId;
	//业主单位
	private String ownersUnit;
	//项目经理
	private String projectManager;
	//销售经理
	private String saleManager;
	//开始日期
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date startDate;
	//预计完成日期
	private String endDate;
	//审核状态(0.未发送1.已发送2.审核中3.退回4.审核通过.5不同意)
	private String auditState;
	private String taskPass;
	private String auditMsg;
	private String taskComment;
	private String lineMes;
	private String projectPlanId;
	private String projectPlanState;
	

	public String getProjectPlanState() {
		return projectPlanState;
	}
	public void setProjectPlanState(String projectPlanState) {
		this.projectPlanState = projectPlanState;
	}
	public String getProjectPlanId() {
		return projectPlanId;
	}
	public void setProjectPlanId(String projectPlanId) {
		this.projectPlanId = projectPlanId;
	}
	public String getLineMes() {
		return lineMes;
	}
	public void setLineMes(String lineMes) {
		this.lineMes = lineMes;
	}
	public String getTaskComment() {
		return taskComment;
	}
	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}
	public String getAuditMsg() {
		return auditMsg;
	}
	public void setAuditMsg(String auditMsg) {
		this.auditMsg = auditMsg;
	}
	public String getTaskPass() {
		return taskPass;
	}
	public void setTaskPass(String taskPass) {
		this.taskPass = taskPass;
	}
	/**
	 * 设置：项目编号
	 */
	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}
	/**
	 * 获取：项目编号
	 */
	public String getProjectNo() {
		return projectNo;
	}
	/**
	 * 设置：项目来源(1.社会客户出资工程2供电公司出资直报3.个电力设计院分包4.供电公司三产电力)
	 */
	public void setProjectResource(String projectResource) {
		this.projectResource = projectResource;
	}
	/**
	 * 获取：项目来源(1.社会客户出资工程2供电公司出资直报3.个电力设计院分包4.供电公司三产电力)
	 */
	public String getProjectResource() {
		return projectResource;
	}
	/**
	 * 设置：项目类型(1.线路2.网改3.变电4.配电)
	 */
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	/**
	 * 获取：项目类型(1.线路2.网改3.变电4.配电)
	 */
	public String getProjectType() {
		return projectType;
	}
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * 设置：委托单位
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：委托单位
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * 设置：业主单位
	 */
	public void setOwnersUnit(String ownersUnit) {
		this.ownersUnit = ownersUnit;
	}
	/**
	 * 获取：业主单位
	 */
	public String getOwnersUnit() {
		return ownersUnit;
	}
	/**
	 * 设置：项目经理
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	/**
	 * 获取：项目经理
	 */
	public String getProjectManager() {
		return projectManager;
	}
	/**
	 * 设置：销售经理
	 */
	public void setSaleManager(String saleManager) {
		this.saleManager = saleManager;
	}
	/**
	 * 获取：销售经理
	 */
	public String getSaleManager() {
		return saleManager;
	}
	/**
	 * 设置：开始日期
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始日期
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：预计完成日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：预计完成日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：审核状态(0.未发送1.已发送2.审核中3.退回4.审核通过.5不同意)
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	/**
	 * 获取：审核状态(0.未发送1.已发送2.审核中3.退回4.审核通过.5不同意)
	 */
	public String getAuditState() {
		return auditState;
	}
}
