package cn.wewintech.common.utils;

/**
 * 常量定义
 * 
 * @author Administrator
 *
 */
public class Constant {

	/** 草稿箱 */
	public static final String MAIL_STATUS_DRAFT = "0";
	/** 发件箱 */
	public static final String MAIL_STATUS_SEND = "1";
	/** 收件箱 */
	public static final String MAIL_STATUS_RECV = "2";

	// ----------------------------业务类型编码----------------------------------------
	public static final String BUSINESS_TYPE = "business_type";// 编码转换成名称的时候使用
	/** 融资租赁 */
	public static final String BUSINESS_TYPE_FINANCELEASE = "financeLease";
	/** 小额贷款 */
	public static final String BUSINESS_TYPE_PETTYLOAN = "pettyLoan";
	/** 典当业务 */
	public static final String BUSINESS_TYPE_PAWN = "pawn";
	/** 委贷业务 */
	public static final String BUSINESS_TYPE_LOAN = "loan";
	/** 担保业务 */
	public static final String BUSINESS_TYPE_GUARANTEE = "guarantee";
	/** 投资业务 */
	public static final String BUSINESS_TYPE_INVEST = "invest";
	/** 不添加合同 */
    public static final String SIGN_CONTRACT_NO="2";
	// -----------------------------产品类型
	// start-------------------------------------
	public static final String PROJECT_TYPE = "project_type";// 编码转换成名称的时候使用

	public static final String PRODUCT_TYPE_WDSXXM = "wdsxxm"; // 微贷授信项目
	public static final String PRODUCT_TYPE_XDSXXM = "xdsxxm"; // 信贷授信项目
	public static final String PRODUCT_TYPE_SXXM = "sxxm"; // 授信项目
	// -----------------------------产品类型
	// end-------------------------------------

	// ---------------------------- 编号参数---------------------------------------
	/** 年 */
	public static final String PARAM_YEAR = "$year";
	/** 月 */
	public static final String PARAM_MONTH = "$month";
	/** 日 */
	public static final String PARAM_DAY = "$day";
	/** 时 */
	public static final String PARAM_HOUR = "$hour";
	/** 分 */
	public static final String PARAM_MINUTE = "$minute";
	/** 秒 */
	public static final String PARAM_SECONDS = "$seconds";
	/** 记数 */
	public static final String PARAM_COUNT = "$serialNo";

	// --------------------------系统参数管理-------------------------------------------
	// 文件打印格式
	/** word格式 */
	public static final String FILE_TYPE_WORD = "word";
	/** pdf格式 */
	public static final String FILE_TYPE_PDF = "pdf";

	// 审批处理人显示方式
	/** 显示姓名 */
	public static final String SHOW_NAME = "name";
	/** 显示工号 */
	public static final String SHOW_NUMBER = "number";

	// -------------------------------项目终止-----------------------------------
	public static final String BIZ_PROJECT_END_TYPE = "project_end_type";// 项目终止类型，客户放弃、重大问题、其他
	public static final String BIZ_PROJECT_END_TERMINATION_STATE = "pe_termination_state";// 项目终止状态
	public static final String BIZ_PROJECT_END_TABLE = "biz_project_end_record";
	// ----------------------------任务状态----------------------------------------------
	public static final String ACT_TASK_STATUS_AUDIT = "audit";
	public static final String ACT_TASK_STATUS_FINISH = "finish";
	public static final String ACT_TASK_STATUS_VIEW = "view";

	// -----------------------------审核操作------------------------------------------------
	public static final String ACT_AUDIT_OPERATE_TYPE = "audit_operate_type";
	public static final String ACT_AUDIT_OPERATE_TYPE_AGREE = "agree";// 同意
	public static final String ACT_AUDIT_OPERATE_TYPE_CONDITIONAGREE = "conditionAgree";// 有条件同意
	public static final String ACT_AUDIT_OPERATE_TYPE_DISAGREE = "disagree";// 不同意
	public static final String ACT_AUDIT_OPERATE_TYPE_CANCEL = "cancel";// 撤回/撤销
	public static final String ACT_AUDIT_OPERATE_TYPE_RETURN = "return";// 退回
	public static final String ACT_AUDIT_OPERATE_TYPE_REBACKADDITIONAL = "rebackAdditional";// 退回补充
	public static final String ACT_AUDIT_OPERATE_TYPE_VETO = "veto";// 否决
	public static final String ACT_AUDIT_OPERATE_TYPE_AGAIN = "again";// 复议

	public static final String ACT_AUDIT_FXFP_MSG = "已分配";
	public static final String ACT_AUDIT_FXDC_MSG = "已调查";
	public static final String ACT_AUDIT_BCZL_MSG = "已补充资料";
	public static final String ACT_AUDIT_JZDC_MSG = "已调查";
	public static final String ACT_AUDIT_DSHFP_MSG = "已分配";
	public static final String ACT_AUDIT_TJLS_MSG = "已落实";

	// -------------------状态参数管理----------------------------------------------------
	/** 是/否 所有的地方都通用 */
	public static final String STATUS_YES = "1";

	public static final String STATUS_NO = "0";

	public static final String YES_NO = "yes_no";

	public static final String STATUS_TWO = "2";

	public static final String STATUS_THREE = "3";

	public static final String STATUS_FOUR = "4";
	// --------------------------影像资料类型所属模块-----------------------------------------
	/** 评审报告 **/
	public static final String MODULE_REVIEW ="review_info";
	/**	项目审核影像资料 **/
	public static final String MODULE_PROJECT_AUDIT="project_audit_info";
	/**	分保合同影像资料 **/
	public static final String MODULE_REINSURANCE_CONTRACT="reinsurance_contract_info";
	/**	用信申请资料 **/
	public static final String MODULE_USE_CREDIT_INFO="use_credit_info";
	/** 个人信息 */
	public static final String MODULE_NATURAL_PERSON_INFO = "natural_person_info";
	/** 法人信息 */
	public static final String MODULE_LEGAL_PERSON_INFO = "legal_person_info";
	/** 项目信息 */
	public static final String MODULE_PROJECT_INFO = "project_info";
	/** 合同信息 */
	public static final String MODULE_CONTRACT_INFO = "contract_info";
	/** 其他 */
	public static final String MODULE_OTHER_INFO = "other_info";
	/** 押品出入库影像资料 */
	public static final String MODULE_PLEDGE_OUT_INFO = "pledge_info";
	/** 押品登记影像资料 */
	public static final String MODULE_PLEDEG_REGIST = "pledeg_regist";
	/** 押品注销影像资料 */
	public static final String MODULE_PLEDGE_RELIEVE = "pledge_relieve";
	/** 待签合同 */
	public static final String MODULE_SIGN_CONTRACT_INFO = "sign_contract_info";
	/** 已签合同 */
	public static final String MODULE_SIGNED_CONTRACT_INFO = "signed_contract_info";
	/** 待签合同 */
	public static final String MODULE_SIGN_CONTRACT_INFO_XD = "sign_xd_contract_info";
	/** 已签合同 */
	public static final String MODULE_SIGNED_CONTRACT_INFO_XD = "signed_xd_contract_info";
	/** 待签合同 */
	public static final String MODULE_SIGN_CONTRACT_INFO_DD = "sign_dd_contract_info";
	/** 已签合同 */
	public static final String MODULE_SIGNED_CONTRACT_INFO_DD = "signed_dd_contract_info";
	/** 待签合同 */
	public static final String MODULE_SIGN_CONTRACT_INFO_DB = "sign_db_contract_info";
	/** 已签合同 */
	public static final String MODULE_SIGNED_CONTRACT_INFO_DB = "signed_db_contract_info";
	/** 理赔资料信息 */
	public static final String CONTRACT_PAYMENT_INFO = "contract_payment_info";
	/** 资料移交信息 */
	public static final String CONTRACT_HANDOVER_INFO = "handoverRecord_info";
	/** 归档资料信息 */
	public static final String CONTRACT_ARCHIVE_INFO = "archive_info";
	/** 租赁物处理资料信息 */
	public static final String RENTAL_DEAL_INFO = "rentalDeal_info";
	/** 当物处理影像资料 */
	public static final String PAWN_GOODS_REGIST_INFO = "pawnGoodsRegist_info";
	/** 背景影像资料 */
	public static final String SYSTEM_BACK_IMAGE_INFO = "back_image_info";
	/** 其他费用附件 */
	public static final String OTHER_FEE_INFO = "other_fee_info";
	/** 银行存款附件 */
	public static final String BANK_DEPOSIT_INFO = "bank_deposit_info";
	/** 签报附件 */
	public static final String SIGN_INFO = "sign_info";
	/** 诉讼附件 */
	public static final String SUIT_INFO = "suit_info";
	/** LOGO影像资料 */
	public static final String SYSTEM_LOGO_INFO = "system_logo_info";
	/** 保险资料信息 */
	public static final String CONTRACT_INSURANCE_INFO = "contract_insurance_info";
	/** 担保项目预警影像资料 */
	public static final String GUARANTEE_PROJECT_WARN_INFO = "guaranteeProjectWarn_info";
	/** 担保放款通知单确认影像资料 */
	public static final String GUARANTEE_LEND_CONFIRM_INFO = "guaranteeLendConfirm_info";
	/** 存出保证金影像资料*/
	public static final String PROCDEF_DEPOSIT_OUT_INFO ="procdefDepositOut_info";
	/** 回访信息 */
	public static final String CONTRACT_REVIEW_INFO = "review_info";
	/** 担保基本信息影像资料 */
	public static final String GUARANTEE_INFO = "guarantee_info";
	/** 电话录音 */
	// public static final String BIZ_COLLECTION_RECORD="biz_collection_record";
	/** 催收函件 */
	// public static final String
	// LETTER_COLLECTION_RECORD="letter_collection_record";
	/** 法务催收附件 */
	// public static final String
	// JUSTICE_COLLECTION_RECORD="justice_collection_record";
	/** 法务催收附件 */
	// public static final String
	// HOME_COLLECTION_RECORD="home_collection_record";
	/** 电话录音 */
	public static final String COLLECTION_TEL_INFO = "collection_tel_info";
	/** 催收函件 */
	public static final String COLLECTION_LETTER_INFO = "collection_letter_info";
	/** 上门催收附件 */
	public static final String COLLECTION_HOME_INFO = "collection_home_info";
	/** 法务催收附件 */
	public static final String COLLECTION_JUS_INFO = "collection_jus_info";
	/** 解保申请影像资料 */
	public static final String RELIEVE_GUARANTEE_FILE_INFO = "rlv_guarantee_file_info";
	/** 追偿申请影像资料 */
	public static final String REACH_RECOVERY_FILE_INFO = "reach_recovery_file_info";
	/** 客户还款登记影像资料 */
	public static final String REPAY_REGISTER_FILE_INFO = "repay_register_file_info";
	/** 批复函 */
	public static final String REPLY_FILE_INFO = "reply_info";
	public static final String IMY_TYPE_WD_PAY_APPLY="wd_pay_apply";
	
	
	/**
	 * @Fields REACH_INFO : 担保代偿申请影像资料
	 */
	public static final String REACH_INFO = "reach_info";
	/**
	 * 担保付款
	 */
	public static final String PAY_INFO = "pay_info";
	/**
	 * @Fields REACH_SURE_INFO : 担保代偿确认影像资料
	 */
	public static final String REACH_SURE_INFO = "reach_sure_info";
	/**
	 * @Fields REACH_INFO : 担保追偿费用申请影像资料
	 */
	public static final String RECOVERY_FEE_INFO = "recovery_fee_info";
	/**
	 * @Fields REACH_SURE_INFO : 担保追偿费用确认影像资料
	 */
	public static final String RECOVERY_FEE_SURE_INFO = "recovery_fee_sure_info";
	/**
	 * @Fields CONTRACT_CHANGE_INFO : 租赁合同变更影像资料
	 */
	public static final String CONTRACT_CHANGE_INFO = "contract_change_info";
	/**
	 * @Fields PRE_PAYMENT_INFO : 租赁提前还款影像资料
	 */
	public static final String PRE_PAYMENT_INFO = "pre_payment_info";
	/**
	 * 解除保障影像资料
	 */
	public static final String RELIEVING_SECURITY = "relieving_security";

	/**
	 * 币种类型
	 */
	public static final String CURRENCY_TYPE = "currency_type";

	/**
	 * 税种
	 */
	public static final String TAX_CATEGORY = "tax_category";
	/**
	 * 客户类型：个人客户，企业客户
	 */
	public static final String CUSTOMER_TYPE = "cust_type";

	/**
	 * 客户关联关系：
	 */
	public static final String CUSTOMER_RELATION_TY = "customer_relation_ty";

	/**
	 * 联系人优先级：1、第一联系人，2、第二联系人，3、第三联系人
	 */
	public static final String PRIORITY_LEVEL = "priority_level";

	/**
	 * 股票上市地
	 */
	public static final String LISTED_ADDRESS = "listed_address";

	/**
	 * 性别 1：男，2：女
	 */
	public static final String SEX = "sex";

	/**
	 * 婚姻状况
	 */
	public static final String MARITAL_STATUS = "marital_status";

	/**
	 * 与客户关系(RELATION_SHIP前期数据字典定义类型)
	 */
	public static final String RELATION_TYPE = "RELATION_SHIP";

	/**
	 * 变更流程状态：0-未提交，1-提交未审核，2-审核不通过，3-审核通过
	 */
	public static final String FLOW_CHANGE_STATA = "flow_change_stata";
	/** 展期信息 */
	public static final String CONTRACT_EXTENSION_INFO = "extension_info";
	/** 续当信息 */
	public static final String CONTRACT_IMPAWNAPPLY_INFO = "impawnApply_info";
	/** 展期收费信息 */
	public static final String CONTRACT_EXTENSION_FEE_INFO = "extension_fee_info";
	// --------------------------承租人类型-----------------------------------------
	/** 主承租人 */
	public static final String MAIN_LESSE_USER = "0";

	/** 共同承租人 */
	public static final String COMM_LESSE_USER = "1";

	// -----------------------------合同编号类型-------------------------------------
	/**
	 * 租赁合同
	 */
	public static final String CONTRACT_LEASE = "1";
	/**
	 * 回购合同
	 */
	public static final String CONTRACT_REPURCHASE = "2";
	/**
	 * 保证合同
	 */
	public static final String CONTRACT_GUARANTEE = "3";
	/**
	 * 咨询顾问合同
	 */
	public static final String CONTRACT_CONSULTING = "4";
	/**
	 * 抵押合同
	 */
	public static final String CONTRACT_MORTGAGE = "5";
	/**
	 * 质押合同
	 */
	public static final String CONTRACT_PLEDGE = "6";
	/**
	 * 担保-借款合同
	 */
	public static final String CONTRACT_LOAN_DB = "11";
	/**
	 * 担保-保证合同
	 */
	public static final String CONTRACT_PLEDGE_DB = "12";
	/**
	 * 担保-委保合同
	 */
	public static final String CONTRACT_TRUST_DB = "13";
	/**
	 * 担保-动产质押反担保合同
	 */
	public static final String CONTRACT_COUNTER_MOVABLE_PLEDGE_DB = "14";
	/**
	 * 担保-抵押反担保合同
	 */
	public static final String CONTRACT_COUNTER_MORTGAGE_DB = "15";
	/**
	 * 担保-权利质押反担保合同
	 */
	public static final String CONTRACT_COUNTER_RIGHT_PLEDGE_DB = "16";
	/**
	 * 担保-最高额抵押反担保合同
	 */
	public static final String CONTRACT_COUNTER_MAX_DB = "17";
	/**
	 * 担保-最高额权利质押反担保合同
	 */
	public static final String CONTRACT_COUNTER_MAX_RIGHT_DB = "18";
	/**
	 * 担保-信用反担保合同
	 */
	public static final String CONTRACT_COUNTER_CREDIT_DB = "19";
	/**
	 * 担保-不可撤销个人连带责任信用反担保合同
	 */
	public static final String CONTRACT_COUNTER_NO_CANCLE_CREDIT_DB = "20";

	// -----------------------------发送状态-------------------------------------
	/**
	 * 已发送
	 */
	public static final String SEND_STATUS_YES = "1";

	/**
	 * 未发送
	 */
	public static final String SEND_STATUS_NO = "0";

	// -----------------------------草稿状态-------------------------------------
	/**
	 * 是草稿
	 */
	public static final String DRAFT_STATUS_YES = "0";

	/**
	 * 不是草稿
	 */
	public static final String DRAFT_STATUS_NO = "1";

	// ====================流程定义 start==============================
	// 主业务流程
	/**
	 * 用信申请审核流程标志
	 */
	public static final String PROJECT_USE_CREDIT_AUDIT = "use_credit_audit_flow";
	/**
	 * 项目终结审核流程标志
	 */
	public static final String PROJECT_END_AUDIT = "proj_end_audit_flow";
	/**
	 * 分保申请流程标识
	 */
	public static final String PROJECT_REINSURANCE ="reinsurance_apply";
	/**
	 * 分保合同申请流程标识
	 */
	public static final String PROJECT_REINSURANCE_CONTRACT ="reinsurance_contract_audit";
	/**
	 * 分成申请流程标识
	 */
	public static final String PROJECT_DIVIDE ="divide_apply";
	/**
	 * 租金利率变更
	 */
	public static final String PROCDEF_RENTRATECHANGE = "rent_rate_change";

	/**
	 * 还款计划变更
	 */
	public static final String PROCDEF_REPAYPLANCHANGE = "repay_plan_change";

	/**
	 * 合同变更
	 */
	public static final String PROCDEF_CONTRACTCHANGE = "contract_change";
	/**
	 * 贷后合同变更
	 */
	public static final String PROCDEF_LOAN_CONTRACTCHANGE = "loan_contract_xd_change";
	/**
	 * 贷后利率变更
	 */
	public static final String PROCDEF_LOAN_RATECHANGE = "loan_rate_xd_change";
	/**
	 * 贷后还款计划变更
	 */
	public static final String PROCDEF_LOAN_REPAYPLANCHANGE = "loan_repay_xd_plan_change";
	/**
	 * 当后合同变更
	 */
	public static final String PROCDEF_DD_CONTRACTCHANGE = "pawn_contract_dd_change";
	/**
	 * 当后费率变更
	 */
	public static final String PROCDEF_DD_RATECHANGE = "pawn_rate_dd_change";
	/**
	 * 当后还款计划变更（项目变更/展期）
	 */
	public static final String PROCDEF_DD_REPAYPLANCHANGE = "pawn_repay_plan_dd_change";
	
	/**
	 * 当后还款计划变更（息费减免）
	 */
	public static final String PROCDEF_DD_REPAYPLANCHANGE_INTEREST_REDUCTION = "pawn_repay_plan_dd_change_interest_reduction";
	
	/**
	 * 保证资料信息变更流程标识
	 */
	public static final String PROCDEF_ASSURE_CHANGE_FLOW = "assure_change";
	/**
	 * 抵押资料信息变更流程标识
	 */
	public static final String PROCDEF_MORTGAGE_CHANGE_FLOW = "mortgage_change";
	/**
	 * 质押资料信息变更流程标识
	 */
	public static final String PROCDEF_PLEDGE_CHANGE_FLOW = "pledge_change";
	/**
	 * 小贷保证资料信息变更流程标识
	 */
	public static final String PROCDEF_XD_ASSURE_CHANGE_FLOW = "loan_assure_xd_change";
	// vars.put("assureChangeAuditLeaderXd", auditUserLoginName);//上级领导
	/**
	 * 小贷抵押资料信息变更流程标识
	 */
	public static final String PROCDEF_XD_MORTGAGE_CHANGE_FLOW = "loan_mortgage_xd_change";
	// vars.put("mortgageChangeAuditLeaderXd", auditUserLoginName);//上级领导
	/**
	 * 小贷质押资料信息变更流程标识
	 */
	public static final String PROCDEF_XD_PLEDGE_CHANGE_FLOW = "loan_pledge_xd_change";
	// vars.put("pledgeChangeAuditLeaderXd", auditUserLoginName);//上级领导

	/**
	 * 典当保证资料信息变更流程标识
	 */
	public static final String PROCDEF_DD_ASSURE_CHANGE_FLOW = "pawn_assure_dd_change";
	// vars.put("assureChangeAuditLeaderDd", auditUserLoginName);//上级领导
	/**
	 * 典当抵押资料信息变更流程标识
	 */
	public static final String PROCDEF_DD_MORTGAGE_CHANGE_FLOW = "pawn_mortgage_dd_change";
	// vars.put("mortgageChangeAuditLeaderDd", auditUserLoginName);//上级领导
	/**
	 * 典当质押资料信息变更流程标识
	 */
	public static final String PROCDEF_DD_PLEDGE_CHANGE_FLOW = "pawn_pledge_dd_change";
	// vars.put("pledgeChangeAuditLeaderDd", auditUserLoginName);//上级领导

	/**
	 * 担保保证资料信息变更流程标识
	 */
	public static final String PROCDEF_DB_ASSURE_CHANGE_FLOW = "guarantee_assure_db_change";
	// vars.put("assureChangeAuditLeaderDb", auditUserLoginName);//上级领导
	/**
	 * 担保抵押资料信息变更流程标识
	 */
	public static final String PROCDEF_DB_MORTGAGE_CHANGE_FLOW = "guarantee_mortgage_db_change";
	// vars.put("mortgageChangeAuditLeaderDb", auditUserLoginName);//上级领导
	/**
	 * 担保质押资料信息变更流程标识
	 */
	public static final String PROCDEF_DB_PLEDGE_CHANGE_FLOW = "guarantee_pledge_db_change";
	// vars.put("pledgeChangeAuditLeaderDb", auditUserLoginName);//上级领导
	/**
	 * 当物信息变更流程标识
	 */
	public static final String PROCDEF_GOODS_DD_CHANGE_FLOW = "pawn_goods_dd_change";
	/**
	 * 合同审批流程标识
	 */
	public static final String PROCDEF_CONTRACT_ADD_FLOW = "contract_approval";
	/**
	 * 合同审批流程标识
	 */
	public static final String PROCDEF_CONTRACT_ADD_FLOW_DD = "pawn_contract_dd_approval";
	/**
	 * 合同审批流程标识
	 */
	public static final String PROCDEF_CONTRACT_ADD_FLOW_DB = "contract_db_approval";

	/**
	 * 项目解保申请审核流程标标识
	 */
	public static final String PROCDEF_DB_RELIEVE_GUARANTEE = "db_relieve_guarantee";

	/**
	 * 项目解保申请审核上级领导
	 */
	public static final String RELIEVE_GUARANTEE_AUDIT_LEADER_DD = "relieveGuaranteeAuditLeaderDb";
	/**
	 * 担保追偿申请审核流程标标识
	 */
	public static final String PROCDEF_REACH_DB_RECOVERY = "reach_db_recovery";

	/**
	 * 担保追偿申请审核上级领导
	 */
	public static final String REACH_RECOVERY_AUDIT_LEADER_DB = "reachRecoveryAuditLeaderDb";
	/**
	 * 担保代偿审核
	 */
	public static final String PROCDEF_REACH = "reach_db_approval";
	/**
	 * 担保追偿费用审核
	 */
	public static final String PROCDEF_RECOVERYFEE = "reach_db_recoveryfee";

	// -----------------------客户管理模块常量块（开始）董环-------------------------------------------------------
	/** 自然人客户 */
	public static final String CUSTOMER_NATURE = "1";
	/** 企业客户 */
	public static final String CUSTOMER_LEGAL = "2";

	// 客户授信方式
	/** 分业务（租赁，小贷，担保，典当）系统，单个授信 */
	public static final String SINGLE_AUTHORITY = "0";
	/** 不分业务（租赁，小贷，担保，典当）系统，综合授信 */
	public static final String COMPREHENSIVE_AUTHORITY = "1";
	/** 集团客户授信方式 */
	public static final String UnifiedCredit = "集团授信";
	/** 集团客户授信方式 */
	public static final String UnifiedCreditAlone = "单独授信";
	/** 客户授信额度时效性 */
	public static final String temporary = "临时额度";
	/** 客户授信额度时效性 */
	public static final String permanent = "固定额度";

	// 客户管理流程相关
	/** 客户管理模块流程状态(数据字典类型):0(未发送)，1(未审核)，2(审核不通过)，3(审核通过),4(审核中) */
	public static final String CUSTOMER_FLOW_STATE = "customer_flow_state";

	// 客户授信流程
	/** 客户授信流程标识 */
	public static final String PROCDEF_CUSTOMER_CREDIT_FLOW = "customer_credit_flow";
	/** 客户授信表 */
	public static final String PROCDEF_CUSTOMER_CREDIT_TABLE = "biz_customer_credit";

	// 客户信息变更流程
	/** 客户信息变更流程标识 */
	public static final String PROCDEF_CUSTOMER_CHANGE_FLOW = "customer_change";
	/** 客户信息变更流程表 */
	public static final String PROCDEF_CUSTOMER_CHANGE_TABLE = "biz_info_change_record";
	
	// 客户出入库流程
	/** 客户信息出入库流程标识 */
	public static final String PROCDEF_WAREHOUSE_FLOW = "in_out_pool";
	//public static final String PROCDEF_WAREHOUSE_FLOW = "parallelallow";
	/** 客户出入库流程表 */
	public static final String PROCDEF_WAREHOUSE_TABLE = "biz_cust_warehouse_record";

	// 客户共享流程
	/** 客户共享流程标识 */
	public static final String PROCDEF_CUSTOMER_SHARE_FLOW = "customer_share_flow";
	/** 客户共享表 */
	public static final String PROCDEF_CUSTOMER_SHARE_TABLE = "biz_customer_shared";
	/** 申请人发起共享申请请求，需要申请人领导审核 */
	public static final String CUST_SHARE_NEED_SEND_USER_LEADER_AUDIT = "needSendUserLeaderAudit";
	/** 客户经理审核共享申请，同意后，需要上级领导审核 */
	public static final String CUST_SHARE_NEED_RECIEVE_USER_LEADER_AUDIT = "needRecieveUserLeaderAudit";

	// 客户移交流程
	/** 客户移交流程标识 */
	public static final String PROCDEF_CUSTOMER_MOVE_FLOW = "customer_move_flow";
	/** 客户移交表 */
	public static final String PROCDEF_CUSTOMER_MOVE_TABLE = "biz_customer_transfer";
	/**意向函申请*/
	public static final String PROJECT_INTENT_FLOW ="intent_lettle_apply";
	/**意向函申请表 */
	public static final String PROJECT_INTENT_LETTLE_TABLE="biz_letter_of_intent";
	/** 承诺函申请流程 */
	public static final String PROJECT_COMMITMENT_FLOW = "commitment_audit";
	/** 承诺函申请表 */
	public static final String PROJECT_COMMITMENT_TABLE = "biz_guarantee_commitment";
	/** 担保函申请流程 */
	public static final String PROJECT_GUARANTEE_FLOW = "guarantee_flow";
	/** 担保函申请表 */
	public static final String PROJECT_GUARANTEE_TABLE = "biz_guarantee_letter";
	// 计划表合并,取消流程
	/** 计划表合并流程标识 */
	public static final String PROCDEF_PAY_PLANE_MERGE_CANCEL_FLOW = "cancel_plan_merge_flow";
	/** 计划表合并流程标识 */
	public static final String PROCDEF_PAY_PLANE_MERGE_FLOW = "PayPlaneMergeFlow";
	/** 取消计划表合并流程表 */
	public static final String PROCDEF_PAY_PLANE_MERGE_CANCEL_TABLE = "biz_payment_plan_merge_cancel_flow";
	/** 计划表合并流程表 */
	public static final String PROCDEF_PAY_PLANE_MERGE_TABLE = "biz_payment_plan_merge_flow";
	// -----------------------客户管理模块常量块（结束）董环-------------------------------------------------------

	/** 项目解保申请记录 */
	public static final String PROCDEF_GUARANTEE_RELIEVE_APPLY_RECORD_TABLE = "biz_guarantee_relieve_apply_record";
	/** 追偿申请记录 */
	public static final String PROCDEF_GUARANTEE_REACH_RECOVERY_TABLE = "biz_guarantee_reach_recovery";
	
	/**
	 * 机构选聘表
	 */
	public static final String PROJECT_HIRE_TABLE = "biz_agency_hire";
	/**
	 * 机构选聘流程
	 */
	public static final String PROJECT_HIRE_FLOW = "bank_hire_flow";
	/**
	 * 黑名单表
	 */
	public static final String PROCDEF_CUSTOMER_BLACK_TABLE = "biz_customer_black";
	/**
	 * 加入黑名单流程标识
	 */
	public static final String PROCDEF_CUSTOMER_BLACK_ADD_FLOW = "customer_black_add_flow";
	/**
	 * 解除黑名单流程标识
	 */
	public static final String PROCDEF_CUSTOMER_BLACK_REMOVE_FLOW = "customer_black_remove_flow";

	public static final String PROCDEF_PROJECT_WORK_FLOW_TABLE = "biz_project";
	//分保申请
	public static final String REINSURANCE_WORK_FLOW_TABLE = "biz_project_reinsurance";
	
	//用信申请
	public static final String USE_CREDIT_WORK_FLOW_TABLE = "biz_credit_record";
	
	//项目终结
	public static final String PROJECT_END_WORK_FLOW_TABLE = "biz_guarantee_project_end";
	// 项目经理移交流程
	/** 移交表 */
	public static final String BIZ_PROJECT_TRANSFER = "biz_project_transfer";
	/** 租赁项目经理移交流程标识 */
	public static final String PROJECT_TRANSFER = "project_transfer";
	public static final String TASK_PROJECT_TRANSFER_ZL = "transfer";

	/** 小贷项目经理移交流程标识 */
	public static final String PROJECT_TRANSFER_XD = "project_transfer_xd";
	public static final String TASK_PROJECT_TRANSFER_XD = "transfer_xd";

	/** 典当项目经理移交流程标识 */
	public static final String PROJECT_TRANSFER_DD = "project_transfer_dd";
	public static final String TASK_PROJECT_TRANSFER_DD = "transfer_dd";

	/** 担保项目经理移交流程标识 */
	public static final String PROJECT_TRANSFER_DB = "project_transfer_db";
	public static final String TASK_PROJECT_TRANSFER_DB = "transfer_db";

	/**
	 * 付款管理标识
	 */
	public static final String PROCDEF_PAY_MANGEMENT_FLOW = "pay_mangement";

	/**
	 * 付款管理标识
	 */
	public static final String PROCDEF_PAY_MANGEMENT_CREDIT_FLOW = "pay_mangement_credit";

	/**
	 * 滁州德善授信付款
	 */
	public static final String PROCDEF_PAY_MANGEMENT_CREDIT_CZDS_FLOW = "pay_mangement_credit_czds";

	/**
	 * 马鞍山德善授信付款
	 */
	public static final String PROCDEF_PAY_MANGEMENT_CREDIT_MASDS_FLOW = "pay_mangement_credit_masds";

	/**
	 * 广德德善授信付款
	 */
	public static final String PROCDEF_PAY_MANGEMENT_CREDIT_GDDS_FLOW = "pay_mangement_credit_gdds";

	/**
	 * 批存标识
	 */
	public static final String PROCDEF_BATCH_DEPOSIT_FLOW = "guarantee_db_batch_deposit";

	/**
	 * 保证金追加
	 */
	public static final String PROCDEF_DEPOSIT_ADDED_FLOW = "db_deposit_db_added";

	/**
	 * 保证金存入
	 */
	public static final String PROCDEF_DEPOSIT_IN_FLOW = "guarantee_db_deposit_in";

	/**
	 * 保证金费用退还
	 */
	public static final String PROCDEF_DEPOSIT_CUSTOMER_FLOW = "guarantee_deposit_back";
	/**
	 * 付款管理标识-小贷
	 */
	public static final String PROCDEF_PAY_MANGEMENT_FLOW_WD = "wd_pay_mangement_apply";
	/**
	 * 付款管理标识-小贷 滁州
	 */
	public static final String PROCDEF_PAY_LOAN_PAY_XD_CZ = "loan_pay_xd_cz";
	/**
	 * 付款管理标识-小贷 马鞍山
	 */
	public static final String PROCDEF_PAY_LOAN_PAY_XD_MAS = "loan_pay_xd_mas";
	/**
	 * 付款管理标识-小贷 广德
	 */
	public static final String PROCDEF_PAY_LOAN_PAY_XD_GD = "loan_pay_xd_gd";

	/**
	 * 付款管理标识-典当
	 */
	public static final String PROCDEF_PAY_MANGEMENT_FLOW_DD = "pawn_pay_dd_mangement";
	public static final String PROCDEF_PAY_MANGEMENT_FLOW_MPDD = "pawn_pay_mpdd_mangement";
	/**
	 * 放款管理
	 */
	public static final String PROCDEF_PAY_MANGEMENT_FLOW_NEW = "pay_mangement_apply";
	/**
	 * 出函申请
	 */
	public static final String PROCDEF_PAY_LETTER_FLOW_NEW = "pay_mangement_letter";
	/**
	 * 直融放款申请
	 */
	public static final String PROCDEF_PAY_DIRECT_FLOW_NEW = "pay_mangement_direct";
	/**
	 * 投资申请
	 */
	public static final String PROCDEF_PAY_MANGEMENT_FLOW_INVEST = "invest_pay_mangement_apply";
	/**
	 * 投资收回审核标识
	 */
	public static final String INVEST_RECEIVABLE_FLOW = "invest_receivable_apply";
	/**
	 * 项目变更审核标识
	 */
	public static final String PROCDEF_PROJECT_CHANGE_FLOW_DD = "pawn_project_change_dd";
	public static final String PROCDEF_PROJECT_CHANGE_FLOW_DB = "guarantee_project_change_db";

	/**
	 * 费用退回 - 典当
	 */
	public static final String PROCDEF_REFUND_FLOW_DD = "pawn_refund_audit_dd";

	/**
	 * 费用退回 - 担保
	 */
	public static final String PROCDEF_GUARANTEE_FEE_REFUND_FLOW = "guarantee_fee_refund";

	/**
	 * 付款管理表
	 */
	public static final String PROCDEF_PAY_MANGEMENT_TABLE = "biz_pay_mangement";
	
	/**
	 * 投资收回记录表
	 */
	public static final String INVEST_WITHDRAW_PLAN_RECORD_TABLE = "biz_invest_withdraw_plan_record";

	/**
	 * 项目变更表
	 */
	public static final String PROCDEF_PROJECT_CHANGE_TABLE = "biz_project_change";

	/**
	 * 保证金批存表
	 */
	public static final String PROCDEF_BATCH_DEPOSIT_TABLE = "biz_batch_deposit";

	/**
	 * 保证金追加
	 */
	public static final String PROCDEF_DEPOSIT_ADDED_TABLE = "biz_deposit_added";

	/**
	 * 保证金费用退还
	 */
	public static final String PROCDEF_DEPOSIT_CUSTOMER_TABLE = "biz_deposit_customer";
	/**
	 * 减免标识
	 */
	public static final String PROCDEF_REDUCE_FLOW = "reduce_audit";
	/**
	 * 减免管理表
	 */
	public static final String PROCDEF_REDUCE_TABLE = "biz_receivables_apply";

	/**
	 * 提前还款
	 */
	public static final String PROCDEF_PRE_FLOW = "prepayment_audit";
	/**
	 * 提前还款
	 */
	public static final String PROCDEF_PRE_TABLE = "biz_receivables_apply";
	/**
	 * 租后回访表
	 */
	// 回访审核
	public static final String PROCDEF_AFTER_AUDIT_REVIEW_FLOW = "audit_review";

	public static final String PROCDEF_AFTER_RENT_REVIEW_FLOW_TABLE = "biz_review_mgr";

	public static final String TASK_PROJECT_WORK_FLOW_SEND = "send";// 发送

	public static final String PROCDEF_DB_AFTER_AUDIT_REVIEW_FLOW = "audit_db_review";
	/**
	 * 展期申请
	 */
	public static final String PROCDEF_AUDIT_EXTENSION_FLOW = "loan_audit_xd_extension";

	public static final String PROCDEF_LOAN_EXTENSION_FLOW_TABLE = "biz_loan_extension";
	/**
	 * 展期申请
	 */
	public static final String PROCDEF_AUDIT_DELAY_APPLY_FLOW = "dbxk_guarantee_projectAudit_db";

	public static final String PROCDEF_GUARANTEE_DELAYAPPLY_FLOW_TABLE = "biz_guarantee_delay_apply";

	/**
	 * 续当申请
	 */
	public static final String PROCDEF_AUDIT_BZ_IMPAWNAPPLY_FLOW = "bz_pawn_projectAudit_dd_zq_Process";
	
	public static final String PROCDEF_AUDIT_FB_IMPAWNAPPLY_FLOW = "fb_pawn_projectAudit_dd_xb_Process";

	public static final String PROCDEF_PAWN_IMPAWNAPPLY_FLOW_TABLE = "biz_pawn_ImpawnApply";

	/**
	 * 诉讼申请
	 */
	public static final String PROCDEF_AUDIT_SUIT_FLOW = "pawn_collection_dd_suit";

	public static final String PROCDEF_PAWN_SUIT_FLOW_TABLE = "biz_suit_apply";

	/**
	 * 押品出库
	 */
	public static final String PROCDEF_COLLATERAL_OUT_FLOW = "zl_collateral_out";

	public static final String PROCDEF_COLLATERAL_OUT_FLOW_TABLE = "biz_collateral_repertory_info";

	/**
	 * 担保意向函打印流程
	 */
	public static final String PROCDEF_INTENT_PRINT_FLOW = "db_intent_print_audit";

	public static final String PROCDEF_INTENT_PRINT_FLOW_TABLE = "biz_guarantee_intent";

	/**
	 * 担保项目预警
	 */
	public static final String PROCDEF_GUARANTEE_PROJECT_WARN_FLOW_TABLE = "biz_project_warn_guarantee";

	public static final String PROCDEF_DB_PROJECT_WARN_WORK_FLOW = "guarantee_project_db_warn";
	// vars.put("projectWarnAuditLeader", auditUserLoginName);

	/**
	 * 当物赎回审核
	 */
	public static final String PROCDEF_PAWN_PAWNGOODS_REDEEM_FLOW_TABLE = "biz_pawn_goods_regist";

	public static final String PROCDEF_DD_PAWNGOODS_REDEEM_WORK_FLOW = "pawn_pawnGoods_dd_redeem";

	/**
	 * 当物入库
	 */
	public static final String PROCDEF_PAWN_PAWNGOODS_RUKU_FLOW_TABLE = "biz_pawn_goods_ruku";

	public static final String PROCDEF_PAWN_PAWNGOODS_RUKU_WORK_FLOW = "pawn_goods_ruku";

	public static final String PROCDEF_PAWN_FEE_WORK_FLOW = "pawn_fee_flow";
	/**
	 * 担保项目终结审核
	 */
	public static final String PROCDEF_GUARANTEE_PROJECT_END_FLOW_TABLE = "biz_guarantee_project_end";

	public static final String PROCDEF_DB_PROJECT_END_WORK_FLOW = "guarantee_project_db_end";
	// vars.put("projectEndAuditLeader", auditUserLoginName);
	
	//担保代偿审核
	public static final String PROCDEF_GUARANTEE_REACH_TABLE = "biz_guarantee_reach";

	/********************** 五级分类 *******************************/
	public static final String PROCDEF_AUDIT_REVIEW_FLOW = "class_audit_flow";

	public static final String PROCDEF_AUDIT_REVIEW_FLOW_TABLE = "biz_file_level_category";
	/* 典当三级分类 */
	public static final String PROCDEF_THREE_CLASS_REVIEW_FLOW = "class_three_dd";
	//五级分类
	public static final String PROCDEF_FIVE_CLASS_REVIEW_FLOW = "class_fiveLevle_dd";
	/********************** 借出申请审核（周祖君） *******************************/
	public static final String TASK_BORROW_APPLY = "borrowStart"; // 申请
	public static final String TASK_BORROW_AUDIT = "borrowAudit"; // 审核
	public static final String PROCDEF_BORROW_WORK_FLOW = "borrow_manage";
	/**
	 * 小贷资料借出流程标识
	 */
	public static final String PROCDEF_XD_BORROW_WORK_FLOW = "loan_borrow_xd_manage";
	// vars.put("borrowAuditLeaderXd", auditUserLoginName);

	/**
	 * 典当资料借出流程标识
	 */
	public static final String PROCDEF_DD_BORROW_WORK_FLOW = "pawn_borrow_dd_manage";
	// vars.put("borrowAuditLeaderDd", auditUserLoginName);
	/**
	 * 融资担保资料借出流程标识
	 */
	public static final String PROCDEF_DB_BORROW_WORK_FLOW = "guarantee_borrow_db_manage";
	// vars.put("borrowAuditLeaderDb", auditUserLoginName);

	public static final String PROCDEF_BORROW_MANAGE_WORK_FLOW_TABLE = "biz_borrow_managment"; // 借出管理表

	/********************* 审核主流程 **********************************************************/

	public static final String PROCDEF_PROJECT_WORK_FLOW = "project_work_flow";
	public static final String PROCDEF_PROJECT_WORK_FLOW_SZ = "project_work_flow_sz";// 深圳德润项目审核流程
	public static final String PROC_PATH_INFO = "procPathInfo";// 任务节点来源，存放在流程变量中，退回的时候能用到
	public static final String TASK_PROJECT_WORK_FLOW_APPLY = "apply";// 申请--这个参数已无用

	public static final String TASK_PROJECT_WORK_FLOW_START = "start";// 启动流程,在流转路径中使用

	public static final String TASK_PROJECT_WORK_FLOW_QCYWFH = "qcywfh";// 汽车业务审核
	public static final String TASK_PROJECT_WORK_FLOW_QCYWBSH = "qcywbsh";// 汽车业务部审核
	public static final String TASK_PROJECT_WORK_FLOW_ZHBMJLSH = "zhbmjlsh";// 综合业务部门经理审核
	public static final String TASK_PROJECT_WORK_FLOW_QCFXSH = "qcfxsh";// 汽车风险审核--目前这个节点不使用

	public static final String TASK_PROJECT_WORK_FLOW_RISKINVESTEALLOCATE = "riskInvesteAllocate";// 风险调查分配
	public static final String TASK_PROJECT_WORK_FLOW_JTRISKINVESTEALLOCATE = "jtRiskInvesteAllocate";// 集团风险调查分配

	public static final String TASK_PROJECT_WORK_FLOW_DUTYSURVER = "dutySurvey";// 尽职调查
	public static final String TASK_PROJECT_WORK_FLOW_DUTYSURVERAUDIT = "dutySurverAudit";// 尽职调查审核

	public static final String TASK_PROJECT_WORK_FLOW_ZHYWBSH = "zhywbsh";// 综合业务业务部审核
	public static final String TASK_PROJECT_WORK_FLOW_FGFZZH1SH = "fgfzzh1sh";// 综合分管副总审核
	public static final String TASK_PROJECT_WORK_FLOW_FGFZZHSH = "fgfzzhsh";// 综合分管副总审核

	public static final String TASK_PROJECT_WORK_FLOW_RISKINVESTE = "riskInvestion";// 风险调查
	public static final String TASK_PROJECT_WORK_FLOW_RISKINVESTEAUDIT = "riskInvesteAudit";// 风险调查审核

	public static final String TASK_PROJECT_WORK_FLOW_JTRISKINVESTE = "jtRiskInvestion";// 集团风险调查
	public static final String TASK_PROJECT_WORK_FLOW_JTRISKINVESTEAUDIT = "jtRiskInvesteAudit";// 集团风险调查审核

	public static final String TASK_PROJECT_WORK_FLOW_PENDINGWILLALLOCATE = "pendingWillAllocate";// 贷审会分配
	public static final String TASK_PROJECT_WORK_FLOW_PENDINGWILLAUDIT = "pendingWillAudit";// 贷审会审核

	public static final String TASK_PROJECT_WORK_FLOW_FURTHERINFORMATION = "furtherInformation";// 补充资料
	public static final String TASK_PROJECT_WORK_FLOW_CONDITIONIMPLEMENT = "conditionImplement";// 条件落实
	public static final String TASK_PROJECT_WORK_FLOW_CONDITIONIMPLAUDIT = "conditionImplAudit";// 条件落实审核
	public static final String TASK_PROJECT_WORK_FLOW_CHANGE = "bgfxbsh";// 项目变更
	public static final String TASK_PROJECT_WORK_FLOW_AOTOMOBILE_FINANCE = "insurance_aotomobile_finance_audit";// 汽车金融部审核
	public static final String TASK_PROJECT_WORK_FLOW_INSURANCE_FINANCIAL = "insurance_financial_audit";// 保险项目财务复核

	public static final String TASK_PROJECT_WORK_FLOW_FXBSH = "fxbsh";// 风险部审核
	public static final String TASK_PROJECT_WORK_FLOW_FXBSH1 = "fxbsh1";
	public static final String TASK_PROJECT_WORK_FLOW_FGFZZH2SH = "fgfzzh2sh";// 综合分管副总审核
	public static final String TASK_PROJECT_WORK_FLOW_FGFZQCSH = "fgfzqcsh";// 汽车分管副总审核
	public static final String TASK_PROJECT_WORK_FLOW_ZJLSH = "zjlsh";// 总经理审核
	public static final String TASK_PROJECT_WORK_FLOW_DSZSH = "dszsh";// 董事长审核
	public static final String TASK_PROJECT_WORK_FLOW_ZLFXZY = "zlfxzy";

	// 任务退回节点
	public static final String TASK_RETURN_TYPE_TASK = "task";
	public static final String TASK_RETURN_TYPE_PROCESS = "process";

	// 查看详情页来源
	public static final String TASK_VIEW_FROM_PENDINGAUDIT = "pendingAudit";
	public static final String TASK_VIEW_FROM_AUDITED = "audited";
	// -------------------------项目终止审核工作流---------------------------
	public static final String PROCDEF_PROJECT_STOP_WORK_FLOW = "project_stop_act"; // 项目终止工作流

	// --------------------主流程业务变量---基于角色分配办理人查看代办理任务时使用------------------
	public static final String PROJECT_WORK_FLOW_BUSI_VARS_AREA = "loginUser_area";
	public static final String PROJECT_WORK_FLOW_BUSI_VARS_COMPANY = "loginUser_company";
	public static final String PROJECT_WORK_FLOW_BUSI_VARS_FIRST_DEPARTMENT = "loginUser_first_department";
	public static final String PROJECT_WORK_FLOW_BUSI_VARS_SECOND_DEPARTMENT = "loginUser_second_department";
	public static final String PROJECT_WORK_FLOW_BUSI_VARS_THREE_DEPARTMENT = "loginUser_three_department";

	// ---------------------------------------主流程图使用变量-----------------------------
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_PROJECTTYP = "projectType";// 产品类型
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_PROJECTTYP_ZHZL = "zhzl";// 综合租赁
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_PROJECTTYP_QCZL = "qczl";// 汽车租赁

	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_PROJECTAMOUNT = "projectAmount";// 项目金额
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_PROJECTLIMIT = "projectLimit";// 项目周期

	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPL = "needConditionImpl";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPL_TRUE = "true";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPL_FALSE = "false";

	// 是否需要尽调审核
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDDUTYSURVERAUDIT = "needDutySurverAudit";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDDUTYSURVERAUDIT_TRUE = "true";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDDUTYSURVERAUDIT_FALSE = "false";

	// 是否需要风险审核
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDRISKINVESTEAUDIT = "needRiskInvesteAudit";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDRISKINVESTEAUDIT_TRUE = "true";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDRISKINVESTEAUDIT_FALSE = "false";
	// 是否需要条件落实审核
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPLAUDIT = "needConditionImplAudit";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPLAUDIT_TRUE = "true";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_NEEDCONDITIONIMPLAUDIT_FALSE = "false";

	public static final String TASK_PROJECT_WORK_FLOW_DUTYSURVEY_ASSIGNEE = "projectManagera";// 尽调办理人员
	public static final String TASK_PROJECT_WORK_FLOW_PROJECTMANAGERB = "projectManagerb";// 项目b角色

	// 是否需要集团风险审核
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_JTNEEDRISKINVESTEAUDIT = "jtNeedRiskInvesteAudit";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_JTNEEDRISKINVESTEAUDIT_TRUE = "true";
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_JTNEEDRISKINVESTEAUDIT_FALSE = "false";

	// 上级领导审核变量
	public static final String PROJECT_WORK_FLOW_FLOWSHEET_VARS_SUPERLEADERAUDIT = "superLeaderAudit";

	// 担保项目变更审核
	public static final String PROCDEF_GUARANTEE_PROJECT_UPDATE_FLOW = "audit_db_project_modify";

	public static final String PROCDEF_GUARANTEE_PROJECT_UPDATE_TABLE = "biz_project";
	// ====================流程定义 end==============================

	// -----------------------------担保方式------------------
	public static final String ASSUREMEAN_TYPE = "assure_type";// 担保方式类型
	public static final String ASSUREMEAN_CREDIT = "0";// 信用
	public static final String ASSUREMEAN_GUARANTEE = "1";// 担保
	public static final String ASSUREMEAN_MORTGAGE = "2";// 抵押
	public static final String ASSUREMEAN_PLEDGE = "3";// 质押

	// ----------------------还款方式类型
	public static final String HKFS = "HKFS";
	public static final String HKFS_LOAN_REPAY_METHOD = "loan_repay_method";
	public static final String PAWN_REPAY_METHOD = "pawn_repay_method";
	public static final String PAWN_RES_REPAY_METHOD = "pawn_res_repay_method";

	// ----------------------项目尽职调查报告文件路径
	public static final String DUE_FILE_PATH = "due_file";

	// ---------------------- 抵质物类型
	/**
	 * 抵押物
	 */
	public static final String GUARANTEE_PLEDGE = "1";

	/**
	 * 质押物
	 */
	public static final String GUARANTEE_MORTGAGE = "2";
	/**
	 * 租赁物类型
	 */
	public static final String HOME_MORTGAGE = "1";

	public static final String EATH_MORTGAGE = "2";

	public static final String CAR_MORTGAGE = "3";

	public static final String EQUITY_PLEDGE = "4";

	public static final String OTHER_PLEDGE = "5";

	// ------------------------撤销类型----------------
	public static final String CANCELTYPE_TASK = "task";
	public static final String CANCELTYPE_PROCESS = "process";

	// ----------------------退回类型------------------
	public static final String RETURNTYPE_TASK = "task";
	public static final String RETURNTYPE_PROCESS = "process";
	/**
	 * 流程中撤回结果：撤回成功
	 */
	public static final String Flow_Cancel_result = "OK";

	// ------------------------发送撤回动作状态----------------
	public static final String FLOW_SEND_STATUS = "1"; // 发送
	public static final String FLOW_BACK_STATUS = "0"; // 撤回

	// ------------------------违约金/罚息收取方式----------------
	/** 当期收取 */
	public static final String COLLECTION_METHOD_CURRENT_STAGE = "1";
	/** 最后一期收取 */
	public static final String COLLECTION_METHOD_FINAL_STAGE = "2";

	// ------------------------违约金/罚息计算方式----------------
	/** 合同金额计算 */
	public static final String CALCULATE_METHOD_CONTRACT_VALUE = "1";
	/** 当期应还总额计算 */
	public static final String CALCULATE_METHOD_CURRENT_TOTAL_PERIOD = "2";
	/** 剩余本金计算 */
	public static final String CALCULATE_METHOD_REMAINING_PRINCIPA = "3";
	/** 当期逾期本金计算 */
	public static final String CALCULATE_METHOD_CURRENT_OVERDUE_PRINCIPAL = "4";

	// ------------------------保证金收取方式----------------
	/** 按合同比例收取 */
	public static final String COLLECTION_METHOD_CONTRACT_PROPORTION = "1";
	/** 按合同期数比例收取 */
	public static final String COLLECTION_METHOD_CONTRACT_PERIOD_NUMBER_RATIO = "2";
	/** 按合同期限比例收取 */
	public static final String COLLECTION_METHOD_CONTRACT_PERIOD_RATIO = "3";

	// ------------------------黑名单封锁期限(时间单位)----------------
	/** 永久 */
	public static final String BLOCKADE_PERIOD_UNIT_FOREVER = "forever";
	/** 日 */
	public static final String BLOCKADE_PERIOD_UNIT_DAY = "1";
	/** 月 */
	public static final String BLOCKADE_PERIOD_UNIT_MONTH = "2";
	/** 年 */
	public static final String BLOCKADE_PERIOD_UNIT_YEAR = "3";
	/** 永久 */
	public static final String BLOCKADE_PERIOD_FOREVER = "永久";
	/** 日（单位） */
	public static final String BLOCKADE_PERIOD_DAY = "日";
	/** 月（单位） */
	public static final String BLOCKADE_PERIOD_MONTH = "月";
	/** 年（单位） */
	public static final String BLOCKADE_PERIOD_YEAR = "年";

	// -------------------------五级分类人工评定----------------

	public static final String AUDITSTATEONE = "1";
	/**
	 * 发送待审核
	 */
	public static final String FIVELEVELCATEGORYONE = "1";
	/**
	 * 审核通过
	 */
	public static final String FIVELEVELCATEGORYTWO = "2";
	/**
	 * 审核不通过
	 */
	public static final String FIVELEVELCATEGORYTHREE = "3";
	/**
	 * 未发送
	 */
	public static final String FIVELEVELCATEGORYZERO = "0";

	// -------------------租赁物类型--------------------\
	public static final String LEASE_TYPE_CAR = "0"; // 汽车
	public static final String LEASE_TYPE_PRODUCT = "1"; // 生产
	public static final String LEASE_TYPE_COMM = "2"; // 通用
	public static final String LEASE_TYPE_ROAD = "3"; // 道路

	// --------------项目状态-----------------------
	public static final String PROJECT_SEND_STATUS_WFS = "0";// 未发送
	public static final String PROJECT_SEND_STATUS_YFS = "1";// 已发送
	public static final String PROJECT_SEND_STATUS_TH = "2";// 退回
	public static final String PROJECT_SEND_STATUS_FJ = "3";// 否决
	public static final String PROJECT_SEND_STATUS_TG = "4";// 审核通过
	public static final String PROJECT_SEND_STATUS_STOP_DSH = "5";// 终止待审核
	public static final String PROJECT_SEND_STATUS_STOP_FJ = "6";// 终止审核否决
	public static final String PROJECT_SEND_STATUS_STOPED = "7";// 已终止
	public static final String PROJECT_SEND_STATUS_SX_STOPED = "8";// 授信停止
	public static final String PROJECT_SEND_STATUS_BG = "9";// 项目变更
	public static final String PROJECT_SEND_STATUS_BG_FJ = "10";// 项目变更否决
	public static final String PROJECT_SEND_STATUS_SHZ = "11";// 项目审核中

	// ------------------合同影像资料签订
	public static final String MEDIA_INFO_SIGN = "sign";// 待签
	public static final String MEDIA_INFO_SIGNED = "signed";// 已签

	// ------------------合同签报资料
	public static final String QB_MEDIA_INFO_SIGN = "qb_media";//

	// --------------黑名单操作提示类型-----------------------
	public static final String BLACK_LIST_PARAM_TIP = "1";// 给予提示
	public static final String BLACK_LIST_PARAM_REFUSE = "2"; // 强制不予申请

	// --------------授信额度操作提示类型-----------------------
	public static final String CREDIT_LIMIT_PARAM_OK = "0"; // 无影响
	public static final String CREDIT_LIMIT_PARAM_TIP = "1";// 给予提示
	public static final String CREDIT_LIMIT_PARAM_REFUSE = "2";// 强制不予申请

	// --------------贷后管理-----------------------
	/**
	 * 审核状态
	 */
	public static final String AUDIT_STATUS = "audit_status";
	/**
	 * 业务状态
	 */
	public static final String BIZ_TYPE = "biz_type";
	/**
	 * 结算方式
	 */
	public static final String SETTLE_METHOD = "settle_method";
	/**
	 * 还款日类型
	 */
	public static final String REPAYMENT_DATE_TYPE = "repayment_date_type";

	// =========================消息参数类型========================
	public static final String MESSAGE_PARAMTYPE_BUSI = "busi";
	public static final String MESSAGE_PARAMTYPE_TASK = "task";
	// --------------凭证管理 发送状态-----------------------
	/** 未发送 */
	public static final String VOUCHER_STATUS_UNSEND = "0";
	/** 发送中 */
	public static final String VOUCHER_STATUS_SENDING = "1";
	/** 发送成功 */
	public static final String VOUCHER_STATUS_SEND_SUCCESS = "2";
	/** 发送失败 */
	public static final String VOUCHER_STATUS_SEND_FAIL = "3";

	// --------------凭证管理 费用类型（字典定义）-----------------------
	/** 本金 */
	public static final String CHARGE_TYPE_PRINCIPAL = "1";
	/** 利息 */
	public static final String CHARGE_TYPE_INTEREST = "2";
	/** 违约金 */
	public static final String CHARGE_TYPE_PENALTY = "3";
	/** 罚息 */
	public static final String CHARGE_TYPE_PENALTY_INTEREST = "4";
	/** 费用 */
	public static final String CHARGE_TYPE_COST = "5";
	/** 增值税 */
	public static final String CHARGE_TYPE_VAT = "6";

	/** 保证金 */
	public static final String CHARGE_TYPE_BOND = "7";

	/** 本金+利息 */
	public static final String CHARGE_TYPE_PRINCIPAL_INTEREST = "8";

	/** 违约金 + 罚息 */
	public static final String CHARGE_TYPE_PENALTY_INTEREST_2 = "9";

	/** 损失本金 */
	public static final String LOSS_PRINCIPAL = "10";

	/** 转让本金 */
	public static final String TRANS_PRINCIPAL = "12";

	/** 转让本金 */
	public static final String MORE_INTEREST = "11";

	/** 利息收入 */
	public static final String INTEREST_INCOME = "13";
	
	/** 追偿金额 */
	public static final String RECOURSE_AMOUNT = "14";

	// --------------凭证管理 凭证模块（字典定义）-----------------------
	/** 财务付款 */
	public static final String VOUCHER_MODULE_FINANCIAL_PAYMENT = "1";
	/** 财务收款 */
	public static final String VOUCHER_MODULE_FINANCIAL_COLLECTION = "2";
	/** 提前还款 */
	public static final String VOUCHER_MODULE_FINANCIAL_COLLECTION_ADVANCE = "21";
	/** 保证金收取 */
	public static final String VOUCHER_MODULE_DEPOSIT_COLLECTION = "3";
	/** 保证金退还 */
	public static final String VOUCHER_MODULE_DEPOSIT_REFUND = "4";
	/** 保证金支付 */
	public static final String VOUCHER_MODULE_DEPOSIT_PAY = "15";
	/** 费用收取 */
	public static final String VOUCHER_MODULE_CHARGE_COLLECTION = "5";
	/** 费用退回 */
	public static final String VOUCHER_MODULE_COST_RETURN = "6";
	/** 收益结转（利息计提） */
	public static final String VOUCHER_MODULE_INTEREST_ACCRUAL = "7";
	/** 计提损失 */
	public static final String VOUCHER_MODULE_PROVISION_LOSS = "8";
	/** 核销 */
	public static final String VOUCHER_MODULE_VERIFICATION_CANCEL = "9";
	/** 资产转让 */
	public static final String VOUCHER_MODULE_ASSET_TRANSFER = "10";
	/** 资产证券化 */
	public static final String VOUCHER_MODULE_ASSET_SECURITIZATION = "11";
	/** 利息反冲 */
	public static final String VOUCHER_MODULE_INTEREST_RETURN = "12";

	/** 财务收款,利息多收 */
	public static final String VOUCHER_MODULE_MORE_INTEREST = "13";
	
	/** 代偿 */
	public static final String VOUCHER_MODULE_COMPENSATORY = "16";
	
	/** 追偿 */
	public static final String VOUCHER_MODULE_RECOURSE = "17";
	
	/** 追偿费用 */
	public static final String VOUCHER_MODULE_RECOURSE_FEE = "18";
	
	//代偿还款
	public static final String VOUCHER_MODULE_COMPENSATORY_REPAYMENT = "19";
	
	//展期费用
	public static final String VOUCHER_MODULE_EXTEND_FEE = "20";
	
	/**
	 * 客户类型： 保证合同， 抵押合同， 贷款合同， 最高额授信借款合同， 最高额保证合同， 最高额抵押合同
	 */
	public static final String CONTRACT_TYPE = "contract_type";
	/**
	 * 担保方式： 担保， 质押， 信用， 抵押
	 */
	public static final String ASSURE_TYPE = "assure_type";

	/**
	 * 基准利率类型:日、月、年
	 */
	public static final String LOAN_RATE_CYCLE = "loan_rate_cycle";

	/**
	 * 贷款用途
	 */
	public static final String LOAN_APPLICATION = "loan_application";
	/**
	 * 证件类型数据字典key
	 */
	public static final String CERTIFICATES_TYPE = "certificates_type";

	/**
	 * 租赁类型 --回租
	 */
	public static final String RENT_TYPE_0 = "0";

	/**
	 * 租赁类型 --直租
	 */
	public static final String RENT_TYPE_1 = "1";

	/**
	 * 租赁类型 --共同租赁
	 */
	public static final String RENT_TYPE_2 = "2";

	/**
	 * 租赁类型 --厂商租赁
	 */
	public static final String RENT_TYPE_3 = "3";
	/**
	 * 动产
	 */
	public static final String RENTAL_ITEM_0 = "0";

	/**
	 * 不动产
	 */
	public static final String RENTAL_ITEM_1 = "1";

	/**
	 * 动产+不动产
	 */
	public static final String RENTAL_ITEM_2 = "2";

	/**
	 * 医疗
	 */
	public static final String HXYL_YL = "HYLX_82";

	// ================我的任务流程变量 start=============
	public static final String BUSI_PROCVARS_CUSTOMERID = "busi_procVars_customerId";// 客户id
	public static final String BUSI_PROCVARS_CUSTOMERNAME = "busi_procVars_customerName";// 客户名称
	public static final String BUSI_PROCVARS_PROJECTID = "busi_procVars_projectId";// 项目Id
	public static final String BUSI_PROCVARS_BUSISTARTTIME = "busi_procVars_busiStartTime";// 业务开始时间
	public static final String BUSI_PROCVARS_PROCESSSENDTIME = "busi_procVars_processSendTime";// 流程发送时间

	public static final String BUSI_PROCVARS_BUSINESSID = "busi_procVars_businessId";// 业务Id

	public static final String BUSI_PROCVARS_SENDUSERCOMPANYID = "busi_procVars_sendUserCompanyId";// 发起人所在机构Id
	public static final String BUSI_PROCVARS_SENDUSEROFFICEID = "busi_procVars_sendUserOfficeId";// 发起人所在部门id
	public static final String BUSI_PROCVARS_SENDUSEAREA = "busi_procVars_sendUserArea";// 发起人所在区域
	public static final String BUSI_PROCVARS_JTCOMPANYID = "670869647114347";
	
	public static final String BUSI_PROCVARS_SENDPROJECTCOMPANY = "busi_procvars_sendprojectcompany";// 发起项目的操作公司
	// ================我的任务流程变量 end=============

	/**
	 * 冲销本金
	 */
	public static final String MAGIN_APPROACH_0 = "0";

	/**
	 * 冲销本息
	 */
	public static final String MAGIN_APPROACH_1 = "1";

	/**
	 * 到期
	 */
	public static final String MAGIN_APPROACH_2 = "2";

	// ================当物信息类型================//
	public static final String PAWN_GOODS_FDCDY = "fdcdy";
	public static final String PAWN_GOODS_FCBZDD = "fcbzdd"; //房产标准典当
	public static final String PAWN_GOODS_FCFBDD = "fcfbdd"; //房产非标典当
	public static final String PAWN_GOODS_TDDY = "tddy"; //土地信息
	public static final String PAWN_GOODS_QCDY = "qcdy"; //汽车抵押
	public static final String PAWN_GOODS_MPDD = "mpdd"; //民品典当
	public static final String PAWN_GOODS_CCDY = "ccdy"; //财产抵押
	public static final String PAWN_GOODS_QTDW = "qtdw"; //其他典当

	/**
	 * 审核状态
	 */
	public static final String AUDIT_TYPE_1 = "1";
	public static final String AUDIT_TYPE_2 = "2";
	public static final String AUDIT_TYPE_3 = "3";
	public static final String AUDIT_TYPE_4 = "4";

	/**
	 * 存入/取出
	 */
	public static final String COLLECTION_RELEASE_0 = "0";// 批存
	public static final String COLLECTION_RELEASE_1 = "1";// 取出
	public static final String COLLECTION_RELEASE_2 = "2";// 存入
	public static final String COLLECTION_RELEASE_3 = "3";// 释放
	// ================回访风险审核人ID================//
	public static final String REVIEW_AUDIT_LOGIN_NAMES = "review_audit_login_names";

	/**
	 * 五级分类分类状态字典key
	 */
	public static final String CLASS_STATE = "class_state";
	/**
	 * 五级分类类别字典key
	 */
	public static final String FIVE_CATEGORIES = "five_categories";

	/**
	 * 五级分类类别枚举
	 */
	public enum FiveLevelLabel {
		正常类, 关注类, 次级类, 可疑类, 损失类;
	}

	/**
	 * 担保抵质押类型
	 */
	public static final String GUARANTEE_TYPE = "guarantee_type";

	public static final String DB_DEPOSIT_RISKADD = "riskAdd";// 担保保证金追加使用

	/************ 报表参数 ****/
	public static final String BUSI_TYPE = "businessType";
	public static final String DATE = "date";

	// 更新业务记录审核状态
	public static final String BUSINESS_TABLE = "business_table";
	public static final String BUSINESS_TABLE_RECORDID = "business_table_recordId";
	public static final String BUSINESS_TABLE_FIELD = "business_table_field";
	public static final String BUSINESS_TABLE_FIELD_VALUE = "business_table_field_value";

	// 租赁变更审核流程标识
	public static final String GUARANTEE_CHANGE_PROJECTAUDIT_ZL_PROCESS = "audit_zl_project_change";

	/**
	 * 理赔审核流程标识
	 */
	public static final String PAY_INSURANCE_AUDIT = "pay_insurance_audit";

	public static final String PROJECT_INSURANCE_TABLE = "biz_project_insurance_record";

	// 典当结项流程
	public static final String PAWN_PROJECT_CLOSED = "pawn_project_closed";// 典当项目结项
	
	// 担保结项流程
	public static final String PROJECT_CLOSED = "project_closed";// 典当项目结项

	// 项目结项表典当 
	public static final String PROCDEF_PAYMENT_PLAN_CONFIG_TABLE = "biz_payment_plan_config";
	
	// 项目结项表担保
	public static final String PROCDEF_UNDERWRITE_MANGEMENT = "biz_underwrite_mangement";
	
	// 项目结项表 
	public static final String PROCDEF_CLOSED = "biz_closed";
	
	// 项目结项表 
	public static final String BIZ_CONTRACT_TABLE = "biz_contract";
	
	//是否本公司审核
	public static final String IS_PRESENT_COMPANY = "is_present_company";
	
	//打印合同-印刷合同
	public static final String IS_FLOW_TYPE = "flowType";
	
	//打印合同-印刷合同
	public static final String IS_CONTRACT_TYPE = "contract_type";
	
	/**
	 * 核保管理表
	 */
	public static final String UNDERWRITE_MANGEMENT_TABLE = "biz_underwrite_mangement";
	
	/**
	 * 核保管理标识-典当
	 */
	public static final String PROCDEF_UNDERWRITE_MANGEMENT_FLOW_DD = "pawn_underwrite_mangement";
	
	/**
	 * 核保管理标识-标准典当
	 */
	public static final String PROCDEF_UNDERWRITE_MANGEMENT_FLOW_BZDD = "bz_pawn_underwrite_mangement";
	
	/**
	 * 核保管理标识-融资担保
	 */
	public static final String PROCDEF_UNDERWRITE_MANGEMENT_FLOW_RZDB = "financing_guarantee_underwrite_mangement";

	/**
	 * 核保管理标识-工程保函
	 */
	public static final String PROCDEF_UNDERWRITE_MANGEMENT_FLOW_GCBH = "project_guarantee_underwrite_mangement";


	/** 核保合同影像资料 */
	public static final String MODULE_UNDERWRITE_CONTRACT_INFO = "underwrite_contract_info";
	/** 核保其他影像资料 */
	public static final String MODULE_UNDERWRITE_OTHER_INFO = "underwrite_other_info";
	/** 核保申请特批资料 */
	public static final String MODULE_UNDERWRITE_SPECIAL_INFO = "underwrite_special_info";
	/** 付款申请影像资料 */
	public static final String MODULE_PAY_APPLY_INFO = "pay_apply_info";
	
	/** 典当风险处置 */
	public static final String PROCDEF__COLLATERAL_DEAL = "biz_collateral_deal_audit";
	
	/** 典当风险处置流程 */
	public static final String FXZCCZ_PAWN_PROJECTAUDIT_DD_PROCESS = "fxzccz_pawn_projectAudit_dd_Process";

	/** 担保项目变更 */
	public static final String GUARANTEE_PROJECT_CHANGE_PROCESS = "guarantee_project_change_process";
	/** 典当项目变更 */
	public static final String PAWN_PROJECT_CHANGE_PROCESS = "pawn_project_change_process";

	public static final String PRJ_CHANGE_STATUS_WFS = "0";// 未发送
	public static final String PRJ_CHANGE_STATUS_YFS = "1";// 已发送
	public static final String PRJ_CHANGE_STATUS_SHTG = "2";// 审核通过
	public static final String PRJ_CHANGE_STATUS_SHBTG = "3";// 审核不通过
	public static final String PRJ_CHANGE_STATUS_YCH = "4";// 撤回
	public static final String PRJ_CHANGE_STATUS_TH = "5";// 退回
	public static final String PRJ_CHANGE_STATUS_SHZ = "6";// 审核中

	public static final String PAWN_CHANGE_PRODUCT_TYPE_CODE = "pawnxmbgcp"; // 典当项目变更产品简称
	public static final String GUARANTEE_CHANGE_PRODUCT_TYPE_CODE = "guaranteexmbgcp"; // 担保项目变更产品简称

	public static final String PAWN_APPEAL_PRODUCT_TYPE_CODE = "pawnsscp"; // 典当项目申诉产品简称
	public static final String GUARANTEE_APPEAL_PRODUCT_TYPE_CODE = "guaranteesscp"; // 担保项目申诉产品简称
	
	public static final String CHANGE_FLAG_NO = "1";
	public static final String CHANGE_FLAG_YES = "0";
	
	
	public static final String BIZ_FFIVE_CATEGORY = "fivecategory";
	
	/**
	 * 还款计划表变更影像资料
	 */
	public static final String PLAN_CHANGE_INFO = "plan_change_info";
	
	
	public static final String REVIEW_MGR_1 = "1"; //五级分类--正常业务
	public static final String REVIEW_MGR_2 = "2"; //五级分类--风险资产
	
	
	/** 质押物处置影像资料 */
	public static final String MODULE_LEASE_OVERDUE_INFO = "lease_overdue_info";
	
	
	/**流程是否签收标识    key未签收   lock已签收*/
	public static final String PROCDEF_FLOW_LOCK_OR_KEY = "procdef_flow_lock_or_key";
	
	/**流程签收时间*/
	public static final String PROCDEF_FLOW_LOCK_TIME = "procdef_flow_lock_time";
	
	/**上传图片  轮播图*/
	public static final String CAROUSE_IMAGE = "carousel/image";
	/**上传图片  微信产品*/
	public static final String PRODUCT_IMAGE = "product/image";
	/**上传合同  */
	public static final String CONTRACT_TEMPLATE_DOC = "contractTemplate/doc";
	public static final String CONTRACT_DOCX_PATH = "contract/docx";


	/** 项目业务节点字典*****************/
	/** 项目立项*/
	 public static final String NODE_CODE_XMLX = "10";
	/** 意向函添加*/
	 public static final String NODE_CODE_YXHTJ = "20";
	 /** 项目变更*/
	 public static final String NODE_CODE_XMBG = "30";
	 /** 合同添加*/
	 public static final String NODE_CODE_HTTJ = "40";
	 /** 综合用信*/
	 public static final String NODE_CODE_ZHYX = "45";
	 /** 押品入库*/
	 public static final String NODE_CODE_YPRK = "50";
	 /**承诺函添加*/
	 public static final String NODE_CODE_CNHTJ = "60";
	 /**直融出函*/
	 public static final String NODE_CODE_ZRCH = "70";
	 /**直融批复登记*/
	 public static final String NODE_CODE_ZRPFDJ = "80";
	 /**间融放款*/
	 public static final String NODE_CODE_JRFK = "90";
	 /**直融放款*/
	 public static final String NODE_CODE_ZRFK = "100";
	 /**非融出函*/
	 public static final String NODE_CODE_FRCH = "110";
	 /**保后检查*/
	 public static final String NODE_CODE_BHJC = "120";
	 /**五级分类*/
	 public static final String NODE_CODE_WJFL = "130";
	 /**项目风险*/
	 public static final String NODE_CODE_XMFX = "140";
	 /**项目代偿*/
	 public static final String NODE_CODE_XMDC = "150";
	 /**不良追偿*/
	 public static final String NODE_CODE_BLZC = "160";
	 /**不良项目回收*/
	 public static final String NODE_CODE_BLXMHS = "170";
	 /**收取保费*/
	 public static final String NODE_CODE_SQBF = "180";
	 /**追加保证金*/
	 public static final String NODE_CODE_ZJBZJ = "190";
	 /**还款登记*/
	 public static final String NODE_CODE_HKDJ = "200";
	 /**退还保证金*/
	 public static final String NODE_CODE_THBZJ = "210";
	 /**退还保费*/
	 public static final String NODE_CODE_THBF = "220";
	 /**退还存出保证金*/
	 public static final String NODE_CODE_THCCBZJ = "230";
	 /**项目终结*/
	 public static final String NODE_CODE_XMZJ = "240";
}
