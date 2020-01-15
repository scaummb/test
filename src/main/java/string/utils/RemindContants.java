package string.utils;

import java.time.format.DateTimeFormatter;

public class RemindContants {
	public static final String LOCALE = "zh_CN";
	public static final String MSG_SCOPE = "remind.msg";
	public static final int MSG_STATUS_DONE = 1;
	public static final int MSG_STATUS_UNDO = 2;
	public static final int MSG_SETTING_UPDATE = 3;
	public static final int MSG_DELETE = 4;
	public static final int MSG_UN_SUBSCRIBE = 5;
	public static final int MSG_CREATE_SUBSCRIBE = 6;
	public static final int MSG_CREATE_OR_UPDATE_WEIXIN_MESSAGE = 7;

	public static final String MSG_SUBJECT = "1";

	public static final String NEED_SEND_WEI_XIN_MESSAGE_ORGANIZATION = MSG_SCOPE + ".needSendWeiXin";

	public static final Long DEFAULT_PLAN_END_TIME_AFTER_PLAN_DATE = 30 * 60 * 1000L;//默认结束时间是开始时间半小时后

	/** LOCAL_DATE_TIME日期格式化 **/
	public final static DateTimeFormatter DEFAULT_LOCAL_DATE_TIME_FORMATTER =  DateTimeFormatter.ISO_DATE;
	/** DATE日期格式化 **/
	public final static String SIMPLE_DATE_FORMATTER = "yyyy-MM-dd";
	/** 一天毫秒数值 **/
	public final static Long ONE_DAY_MILLIS_TIME_COUNT = 86400000L;
	/** 地址哈希字符串count **/
	public final static Integer GEO_CHAR_COUNT = 6;
	/** 日程分类标签数量=1 **/
	public final static Long REMIND_TAG_COUNT_IS_ONE = 1L;
	/** 日程分类标签数量=0 **/
	public final static Long REMIND_TAG_COUNT_IS_ZERO = 0L;
	/** 日程标签默认名称 **/
	public final static String REMIND_TAG_DEFAULT_NAME = "无";
	/** 日程标签默认颜色 **/
	public final static String REMIND_TAG_DEFAULT_COLOR = "#FF6E6E74";
	/** 日程配置项之同事日程历史查看记录数量 **/
	public final static String REMIND_BROWSING_LOGS_SHOW_COUNT = "remind.browsing.logs.show.count";
	/** 日程配置项之同事日程历史查看记录数量数值 **/
	public final static Integer REMIND_BROWSING_LOGS_SHOW_COUNT_DEFAULT_VALUE = 5;
	/** DATE日期格式化0时0分0秒后缀 **/
	public final static String FORMAT_DATE_STRING_SUFFIX = " 00:00:00";
}

