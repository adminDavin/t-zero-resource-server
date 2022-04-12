package com.t.zero.cust.app.bu.vo.filters;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

/**
 * @author davinzhang
 * 
 * @date 2022/02/05
 * 
 * @desc TODO
 */

@Data
public class ResInfoDefFilters {

    private String resInfoName;

    private String resInfoType;

    private List<String> resContentTypes;

    private List<String> resTagCodes;

    private LocalDateTime[] updatedTimes;
    
    private Integer ownerId;

    private boolean notInResContentType;
}
