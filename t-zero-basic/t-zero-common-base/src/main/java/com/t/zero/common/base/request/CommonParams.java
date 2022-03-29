package com.t.zero.common.base.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

@SuperBuilder
@Data
public class CommonParams implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7437153835789116776L;
    String userId;
    Integer userIdInt;
    Integer tenantId;
    String businessType;

    public static CommonParams build(Integer tenantId, Integer userId) {
        var params = CommonParams.builder().userIdInt(userId).tenantId(tenantId).build();
        params.setUserId(String.valueOf(userId));
        return params;
    }

    public static CommonParams build(Integer tenantId, String userId) {
        var params = CommonParams.builder().userId(userId).tenantId(tenantId).build();
        if (StringUtils.isNumeric(userId)) {
            params.setUserIdInt(Integer.valueOf(userId));
        } else {
            params.setUserIdInt(0);
        }
        return params;
    }
}
