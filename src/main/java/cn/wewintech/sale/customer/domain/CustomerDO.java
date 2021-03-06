package cn.wewintech.sale.customer.domain;

import java.io.Serializable;
import java.util.Date;
import cn.wewintech.common.core.DataModel;


/**
 * 客户表
 * 
 * @author 
 * @email 
 * @date 2020-05-11 16:54:44
 */
public class CustomerDO extends DataModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//客户编号
	private String customerNo;
	//客户名称
	private String customerName;
	//客户类型(1.安装公司2.设计院3.三产公司)
	private String customerType;
	//客户经理
	private String userId;
	//所属机构
	private String deptId;
	//状态（1.未成交2.已成交）
	private String type;
	//客户来源(1.领导推荐2.陌生拜访3.客户推荐)
	private String customerResource;
	//详细地址
	private String detailAddress;
	private String suName;
	private String sdName;
	
	
	   //回访日期
		private Date backDate;
		//受访人
		private String backName;
		//受访人职务
		private String backPosition;
		//下次回访日期
		private Date nextBackDate;
		
		

	public String getSuName() {
		return suName;
	}
	public void setSuName(String suName) {
		this.suName = suName;
	}
	public String getSdName() {
		return sdName;
	}
	public void setSdName(String sdName) {
		this.sdName = sdName;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * 设置：客户名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：客户类型(1.安装公司2.设计院3.三产公司)
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	/**
	 * 获取：客户类型(1.安装公司2.设计院3.三产公司)
	 */
	public String getCustomerType() {
		return customerType;
	}
	/**
	 * 设置：客户经理
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：客户经理
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：所属机构
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：所属机构
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：状态（1.未成交2.已成交）
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：状态（1.未成交2.已成交）
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：客户来源(1.领导推荐2.陌生拜访3.客户推荐)
	 */
	public void setCustomerResource(String customerResource) {
		this.customerResource = customerResource;
	}
	/**
	 * 获取：客户来源(1.领导推荐2.陌生拜访3.客户推荐)
	 */
	public String getCustomerResource() {
		return customerResource;
	}
	/**
	 * 设置：详细地址
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	/**
	 * 获取：详细地址
	 */
	public String getDetailAddress() {
		return detailAddress;
	}
}
