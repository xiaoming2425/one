package cn.wewintech.sale.projectFlow.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 
 * 
 * @author 
 * @email 
 * @date 2020-06-01 11:52:24
 */
public class ProjectFlowDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//项目编号
	private String projectNo;
	//项目名称
	private String projectName;
	//委托单位
	private String customerId;
	//项目经理
	private String projectManager;
	//预计金额
	private BigDecimal forecastAmount;
	//联系人
	private String linkman;
	//联系电话
	private String phone;
	
	private String saleType;
	
	private String userId;
	
	private Date date;
	
	

	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	 * 设置：预计金额
	 */
	public void setForecastAmount(BigDecimal forecastAmount) {
		this.forecastAmount = forecastAmount;
	}
	/**
	 * 获取：预计金额
	 */
	public BigDecimal getForecastAmount() {
		return forecastAmount;
	}
	/**
	 * 设置：联系人
	 */
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	/**
	 * 获取：联系人
	 */
	public String getLinkman() {
		return linkman;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
}
