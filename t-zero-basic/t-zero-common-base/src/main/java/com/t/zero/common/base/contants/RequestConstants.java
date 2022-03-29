package com.t.zero.common.base.contants;

import java.io.Serializable;

public class RequestConstants implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String CONTENT_TYPE_JSON = "application/json";
	
	public static final String CURRENT_PAGE = "currentPage";
	
	public static final String PAGE_SIZE = "pageSize";
	
	public static final String REQUEST_ID = "requestId";
	
	public static class Header {
        public static final String TENANT_ID = "tenantId";
        
        public static final String USER_ID = "userId";
        
        public static final String IDENTIFY_ID = "identifyId";
        
        public static final String REQUEST_ID = "requestId";
        
        public static final String DEFAULT_TENANT_ID = "1000";
        
        public static final String DEFAULT_USER_ID = "0";
        
        public static final String START_TIME_KEY = "startTimeKey";
	}
}
