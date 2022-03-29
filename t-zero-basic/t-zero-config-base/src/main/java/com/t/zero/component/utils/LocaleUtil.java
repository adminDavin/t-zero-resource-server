package com.t.zero.component.utils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

@Component
public class LocaleUtil {

    private static final String I18N_LANG_PARAM = "lang";
    private static final String PATH_PARAMETER_SPLIT = "_";

    private final HttpServletRequest request;

    public LocaleUtil(HttpServletRequest request) {
        this.request = request;
    }

    public Locale getLocale() {
        String lang = request.getParameter(I18N_LANG_PARAM);
        if (StringUtils.isNotBlank(lang) && lang.contains(PATH_PARAMETER_SPLIT)) {
            String[] split = lang.split(PATH_PARAMETER_SPLIT);
            return split != null && split.length > 1 ? new Locale(split[0], split[1]) : RequestContextUtils.getLocale(request);
        } else {
            return RequestContextUtils.getLocale(request);
        }
    }

}
