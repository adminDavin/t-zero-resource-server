package com.t.zero.common.base.contants;

public interface TZeroConstants {
    String NORMAL = "0";
    String ABNORMAL = "1";
    String CLOSE = "11";

    Byte STATUS_NORMAL = Byte.valueOf(NORMAL);
    Byte STATUS_ABNORMAL = Byte.valueOf(ABNORMAL);
    Byte STATUS_CLOSE = Byte.valueOf(CLOSE);

    Integer ZERO = 0;
    Integer ONE = 1;
    Integer TWO = 2;
    String ROOT = "root";
    
    

    String TENANT_ID = "tenantId";
    String USER_ID = "userId";
    String GROUP_ID = "groupId";

    String ORGNAZATION_MANAGER = "organizationManager";
    String GROUP_MANGER = "groupManager";

    Integer ININT_TENANT = 3;

    String CONSUMING_SECRET_MANAGER = "MANAGER";
    String CONSUMING_SECRET_SYSTEM = "SYSTEM";

    String PERCENTAGE = "%";
    String ID = "id";
}
