package regex.replace;

/**
 * @author moubin.mo
 * @date: 2020/7/4 12:46
 */

public class TextContents {
	public static String TEXT_1 = "帮助中心book\n" +
			"![](/uploads/202006/attach_161acf25ee0cfd3c.png)\n" +
			"![](/uploads/202006/attach_161acebdd9e82efc.png)";

	public final static String TEXT_2 = "# 产品功能 #67492：餐卡充值\n" +
			"评审人员:  \n" +
			"开发人员: 吴寒\n" +
			"评审日期:  \n" +
			"#####评审意见：\n" +
			"\n" +
			"#####评审讨论：\n" +
			"#####评审结果：\n" +
			"\n" +
			"# 1.产品需求描述\n" +
			"\n" +
			"## 1.1 简要描述\n" +
			"\n" +
			"http://devops.zuolin.com/issues/67492\n" +
			"\n" +
			"## 1.2 详细产品功能信息请访问\n" +
			"\n" +
			"http://pd.zuolin.com/hosting/data/Group/public/home/product/1-designDoc/5-%E7%94%B5%E5%95%86/%E8%88%AA%E5%A4%A9%E4%BA%8C%E9%99%A2%E9%A4%90%E5%8D%A1V1.2/#g=1&p=%E5%85%85%E5%80%BC\n" +
			"\n" +
			"# 1. 功能详情\n" +
			"\n" +
			"## 功能流程:\n" +
			"1. 餐卡没有收款充值的能力,需要使用别的支付渠道的交易能力把钱给一个指定收款账户,\n" +
			"1. 付款直接接支付\n" +
			"1. 收款账户交易成功回调成功后,再去异步处理支付进行餐卡充值.\n" +
			"1. 支付餐卡充值成功就结束,不成功返回给营销再发起退款订单退款\n" +
			"\n" +
			"# 4.数据对象设计\t\n" +
			"## 4.1 数据结构设计\n" +
			"\n" +
			"```\n" +
			"营销:\n" +
			"CREATE TABLE `prmt_pay_vendor_merchants` (\n" +
			"  `id` BIGINT NOT NULL COMMENT '业务关系表ID，主键',\n" +
			"  `namespace_id`INTEGER NOT NULL COMMENT '业务命名空间',\n" +
			"  `vendor_code` TINYINT  COMMENT '支付渠道:餐卡渠道',\n" +
			"  `merchant_id` BIGINT  COMMENT '所属商户ID',\n" +
			"  `service_hotline` VARCHAR(64) comment '客服电话',\n" +
			"  `creator_uid` BIGINT COMMENT '创建人ID',\n" +
			"  `create_time` DATETIME  COMMENT '创建时间',\n" +
			"  `operator_uid` BIGINT ,\n" +
			"  `update_time` DATETIME  COMMENT '更新时间',\n" +
			"  PRIMARY KEY (`id`)\n" +
			") ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT '餐卡渠道和收款商户关联表';\n" +
			"\n" +
			"CREATE TABLE `prmt_pay_vendor_recharge_orders` (\n" +
			"  `id` BIGINT NOT NULL COMMENT '业务关系表ID，主键',\n" +
			"  `system_id` BIGINT NOT NULL COMMENT 'system id',\n" +
			"  `namespace_id` INTEGER NOT NULL COMMENT '业务命名空间',\n" +
			"  `vendor_code` TINYINT  COMMENT '支付渠道:餐卡渠道',\n" +
			"  `biz_order_num` VARCHAR(64)  COMMENT '订单流水号',\n" +
			"  `pay_order_id` BIGINT  COMMENT '支付订单ID',\n" +
			"  `merchant_id` BIGINT  COMMENT '收款商户ID',\n" +
			"  `pay_payee_user_id` BIGINT  COMMENT '收款账户id',\n" +
			"  `pay_user_id` BIGINT  COMMENT '付款用户id',\n" +
			"  `pay_payer_user_id` BIGINT  COMMENT '付款账户id',\n" +
			"  `payment_type` INT COMMENT '支付方式',\n" +
			"  `amount` BIGINT DEFAULT '0' COMMENT '充值总金额',\n" +
			"  `pay_amount` BIGINT DEFAULT '0' COMMENT '实付总金额',\n" +
			"  `status` TINYINT DEFAULT '0' COMMENT '状态 0:无效失败 1:待支付 2:成功 ',\n" +
			"  `pay_finish_time` DATETIME DEFAULT NULL COMMENT '支付完成的时间',\n" +
			"  `recharge_order_id` BIGINT  COMMENT '充值订单ID',\n" +
			"  `call_back_time` DATETIME DEFAULT NULL COMMENT '回调的时间',\n" +
			"  `recharge_status` TINYINT DEFAULT '0' COMMENT '状态 0:无效失败 1:待充值 2:成功 ',\n" +
			"  `pay_refund_order_id` BIGINT  COMMENT '支付退款订单ID 当充值失败时才会产生',\n" +
			"  `refund_finish_time` DATETIME DEFAULT NULL COMMENT '退款完成的时间',\n" +
			"  `refund_status` TINYINT DEFAULT '0' COMMENT '状态 0:失败  2:成功 ',\n" +
			"  `creator_uid` BIGINT COMMENT '创建人ID',\n" +
			"  `create_time` DATETIME  COMMENT '创建时间',\n" +
			"  `operator_uid` BIGINT ,\n" +
			"  `update_time` DATETIME  COMMENT '更新时间',\n" +
			"  PRIMARY KEY (`id`)\n" +
			") ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT '餐卡充值订单';\n" +
			"\n" +
			"```\n" +
			"\n" +
			"# 2.功能点(接口定义)\n" +
			"## 2.1接口\n" +
			"### 营销提供接口:\n" +
			"1. 后台:  域空间下某类餐卡 绑定充值收款商户\n" +
			"1. 后台前端: 查询域空间下某类餐卡是否绑定收款商户(有绑定就显示充值按钮可以充值)如果有,返回payeeUserId,backUrl\n" +
			"1. 充值下单----保存记录,状态置为付款中,调支付createOrder订单,返回支付方式\n" +
			"1. 确认支付方式---- 调支付payOrder,返回支付信息\n" +
			"1. 接受上一步支付结果回调,成功的话状态置为已完成就异步处理餐卡充值,充值失败(小概率)走退款流程,然后状态置为已退款\n" +
			"\n" +
			"### 支付提供接口:\n" +
			"1. 给域空间下某类餐卡绑定收款账户\n" +
			"1. 实现对接黑豆云充值接口, pay_order表增加充值记录\n" +
			"\n" +
			"## 2.2接口详细内容 \n" +
			"\n" +
			"提供给前端交互的接口如下:\n" +
			"\n" +
			"###  获取域空间下支付卡绑定充值收款商户信息 /prmt/paymentcard/getPaymentCardMerchant\n" +
			"\t- 参数\n" +
			"\t\t- namespaceId:域空间id\n" +
			"\t\t- vendorCode:支付渠道\n" +
			"\t- 返回值\n" +
			"\t\t- namespaceId:域空间id\n" +
			"\t\t- vendorCode:支付渠道\n" +
			"\t\t- merchantId:商户id\n" +
			"\t\t- serviceHotline: 热线电话\n" +
			"\n" +
			"### 保存域空间下支付卡绑定充值收款商户信息 /prmt/paymentcard/updatePaymentCardMerchant\n" +
			"\n" +
			"\t- 参数\n" +
			"\t\t- namespaceId:域空间id\n" +
			"\t\t- vendorCode:支付渠道\n" +
			"\t\t- merchantId:商户id\n" +
			"\t\t- serviceHotline: 热线电话\n" +
			"\t- 返回值\n" +
			"\t\t\n" +
			"\n" +
			"### 创建充值订单返回支付方式 /prmt/paymentcard/createRechargeOrder\n" +
			"\n" +
			"\t- 参数\n" +
			"\t\t- namespaceId:域空间id\n" +
			"\t\t- vendorCode:支付渠道\n" +
			"\t\t- merchantId:商户id\n" +
			"\t\t- businessSystemId: systemId\n" +
			"\t\t- amount: 充值金额\n" +
			"\t\t- clientAppName: clientAppName有就填写\n" +
			"\t\t- paymentParams: 有就填写\n" +
			"\t- 返回值(和统一订单payNormalOrder一样)\n" +
			"\t\t- orderId: 业务订单ID\n" +
			"\t\t- expiredIntervalTime: 订单失效间隔时间，单位为秒\n" +
			"\t\t- amount: 支付金额，以分为单位\n" +
			"\t\t- payServerUri: 支付服务器地址\n" +
			"\t\t- orderCommitUrl: 付系统createOrder返回参数\n" +
			"\t\t- orderCommitToken: 支付系统createOrder返回参数\n" +
			"\t\t- orderCommitNonce: 支付系统createOrder返回参数\n" +
			"\t\t- orderCommitTimestamp: 支付系统createOrder返回参数\n" +
			"\t\t- userCommitToken: 支付系统createOrder返回参数\n" +
			"\t\t- payInfo: 支付信息\n" +
			"\t\t- extendInfo: 扩展信息\n" +
			"\t\t- payMethod: 支付方式 \n" +
			"  \n" +
			"### 将来实现接口: 查看充值记录(黑豆云充值失败会没有记录,找不到用户的付款记录)\n" +
			"\n" +
			"# 3.依赖描述\n" +
			" 无\n" +
			"# 4.数据对象设计\n" +
			"## 4.1. 存储介质选型依据\n" +
			"## 4.2. 数据结构设计\n" +
			"## 4.3.数据库表结构设计\n" +
			" \n" +
			"### 4.3.1 ER源文件\n" +
			"### 4.3.2 ER图\n" +
			"略\n" +
			"### 4.3.3 数据库详细设计";

}
