package com.t.zero.res.c.manager.bu.vo.response;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTagDef;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author davinzhang
 * @date 2022/02/09
 * @desc TODO
 */

@EqualsAndHashCode(callSuper=false)
@Data
public class ResInfoDefWithTag extends ResInfoDef {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<ResTagDef> tags;
    
    public static ResInfoDefWithTag init(ResInfoDef resInfo, List<ResTagDef> resTags) {
        var result = new ResInfoDefWithTag();
        BeanUtils.copyProperties(resInfo, result);
        result.setTags(resTags);
        return result;
        
    }
}
