package com.witx.entity;

import java.io.Serializable;

import com.witx.core.annotation.Column;
import com.witx.core.annotation.Table;

/**
 * @author Minepop
 * entity的类，字段都需要使用引用对象
 */

@Table("T_Sys_Log")
public class TSysLog extends EntityBase implements Serializable {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @author Minepop
	 * 表字段信息
	 */
	public static class Columns{	
		public static final String id = "ID";
		public static final String userId = "USER_ID";
		public static final String userName = "USER_NAME";
		public static final String className = "CLASS_NAME";
		public static final String methodName = "METHOD_NAME";
		public static final String sessionId = "SESSION_ID";
		public static final String createTime = "CREATE_TIME";
		public static final String logLevel = "LOG_LEVEL";
		public static final String logMessage = "LOG_MESSAGE";
	}
	
	/**
	 * 类属性信息
	 */
	@Column("ID")
	public String id;
	
	@Column("USER_ID")
	public String userId;
	
	@Column("USER_NAME")
	public String userName;
	
	@Column("CLASS_NAME")
	public String className;
	
	@Column("METHOD_NAME")
	public String methodName;
	
	@Column("SESSION_ID")
	public String sessionId;
	
	@Column("CREATE_TIME")
	public String createTime;
	
	@Column("LOG_LEVEL")
	public String logLevel;
	
	@Column("LOG_MESSAGE")
	public String logMessage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	@Override
	public String toString() {
		return "TSysLogBase [id=" + id + ", userId=" + userId + ", userName=" + userName + ", className=" + className
				+ ", methodName=" + methodName + ", sessionId=" + sessionId + ", createTime=" + createTime
				+ ", logLevel=" + logLevel + ", logMessage=" + logMessage + "]";
	}
	
	
	
}
