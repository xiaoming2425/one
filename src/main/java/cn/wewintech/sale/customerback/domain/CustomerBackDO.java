package cn.wewintech.sale.customerback.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.wewintech.common.core.DataModel;


/**
 * 客户回访
 * 
 * @author 
 * @email 
 * @date 2020-05-12 09:19:30
 */
public class CustomerBackDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//回访日期
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date backDate;
	//回访人
	private String userId;
	//受访人
	private String backName;
	//受访人职务
	private String backPosition;
	//下次回访日期
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date nextBackDate;
	//customer_id
	private String customerId;
	private String name;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 设置：回访日期
	 */
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}
	/**
	 * 获取：回访日期
	 */
	public Date getBackDate() {
		return backDate;
	}
	/**
	 * 设置：回访人
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：回访人
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：受访人
	 */
	public void setBackName(String backName) {
		this.backName = backName;
	}
	/**
	 * 获取：受访人
	 */
	public String getBackName() {
		return backName;
	}
	/**
	 * 设置：受访人职务
	 */
	public void setBackPosition(String backPosition) {
		this.backPosition = backPosition;
	}
	/**
	 * 获取：受访人职务
	 */
	public String getBackPosition() {
		return backPosition;
	}
	/**
	 * 设置：下次回访日期
	 */
	public void setNextBackDate(Date nextBackDate) {
		this.nextBackDate = nextBackDate;
	}
	/**
	 * 获取：下次回访日期
	 */
	public Date getNextBackDate() {
		return nextBackDate;
	}
	/**
	 * 设置：customer_id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * 获取：customer_id
	 */
	public String getCustomerId() {
		return customerId;
	}
}
