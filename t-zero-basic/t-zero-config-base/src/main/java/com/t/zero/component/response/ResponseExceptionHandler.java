package com.t.zero.component.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.t.zero.common.base.response.ResponseResult;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.component.utils.LocaleUtil;
import com.t.zero.constants.i18n.I18nMessages;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ResponseExceptionHandler {

    private final LocaleUtil localeUtil;
    private final MessageSource messageSource;
    public static final String CONTENT_TYPE_JSON = "application/json";

    public ResponseExceptionHandler(LocaleUtil localeUtil, MessageSource messageSource) {
        this.localeUtil = localeUtil;
        this.messageSource = messageSource;
    }

    public ResponseResult<Object> handle(String action, Exception e) {
        log.error(action, e);
        if (e instanceof NullPointerException) {
            return ResponseResult.failed(messageSource.getMessage(I18nMessages.NULL_POINTER_EXCEPTION, null, localeUtil.getLocale()));
        }
        if (e instanceof TZeroException) {
            return ResponseResult.failed(getTZeroExceptionMessage((TZeroException)e));
        }
        return ResponseResult.failed(e.getMessage());

    }

    public void handle(HttpServletResponse response, String action, Exception e) {
        log.error(action, e);
        response.setStatus(500);
        response.setContentType(CONTENT_TYPE_JSON);
        if (e instanceof NullPointerException) {
            String message = messageSource.getMessage(I18nMessages.NULL_POINTER_EXCEPTION, null, localeUtil.getLocale());
            handleResponse(response, ResponseResult.failed(message).toString());
        } else if (e instanceof TZeroException) {
            handleResponse(response, ResponseResult.failed(getTZeroExceptionMessage((TZeroException)e)).toString());
        } else {
            handleResponse(response, e.getMessage());
        }

    }

    private String getTZeroExceptionMessage(TZeroException te) {
        if (ObjectUtils.isEmpty(te.getArgs())) {
            return messageSource.getMessage(te.getMessage(), null, localeUtil.getLocale());
        } else {
            var args = te.getArgs().stream().map(i -> messageSource.getMessage(i, null, i, localeUtil.getLocale())).toArray(String[]::new);
            return messageSource.getMessage(te.getMessage(), args, te.getMessage(), localeUtil.getLocale());
        }
    }

    public void handleResponse(HttpServletResponse response, String content) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(content);
        } catch (IOException e1) {
            log.error("exportDevelopCost failed", e1);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
