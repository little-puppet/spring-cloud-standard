package com.standard.common.component;

import com.alibaba.fastjson.JSON;
import com.standard.common.util.CustomException;
import com.standard.common.util.StringUtil;
import com.standard.common.util.XmlMapUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;

/**
 * @author: zhangH
 * @date: 2019/10/4 00:17
 * @description:
 */
@ControllerAdvice
public class ErrorHandle {

    private final Logger logger = LoggerFactory.getLogger(ErrorHandle.class);

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     * @throws UnsupportedEncodingException
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void errorHandler(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception ex) throws UnsupportedEncodingException {
        /*  使用response返回    */
        httpServletResponse.setStatus(HttpStatus.OK.value()); //设置状态码
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");

        // httpServletRequest.setCharacterEncoding("UTF-8"); //避免乱码

        String result = null;
        HashMap<String, Object> resultMap = new HashMap<>();
        if (ex instanceof CustomException) {
            resultMap.put("code", ((CustomException) ex).getCode() + "");
            resultMap.put("message", ex.getMessage());
        } else if (ex instanceof NoHandlerFoundException) {
            resultMap.put("code", CustomException.PathError);
            resultMap.put("message", new CustomException(CustomException.PathError, "404").getMessage());
            ex.printStackTrace();
        } else {
            resultMap.put("code", 10000);
            resultMap.put("message", "系统异常," + ex.getMessage());
            ex.printStackTrace();
        }
        logger.error(ex.getMessage(), ex);
        try {
            String s = new String(IOUtils.toByteArray(httpServletRequest.getInputStream()), Charset.defaultCharset());
            if (StringUtil.isXml(s)) {
                httpServletResponse.setContentType(MediaType.TEXT_XML_VALUE); //设置ContentType
                httpServletResponse.getWriter().write(XmlMapUtil.mapToXml(resultMap, "response"));
            } else if (StringUtil.isJson(s)) {
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
                httpServletResponse.getWriter().write(JSON.toJSONString(resultMap));
            } else {
                httpServletResponse.getWriter().write(ex.getMessage());
            }
            httpServletResponse.getWriter().flush();
        } catch (IOException exe) {
            exe.printStackTrace();
        }
    }
}
