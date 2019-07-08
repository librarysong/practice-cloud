package cn.swf.practice.practicemaster.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 宋维飞
 * 2019/7/1 15:06
 */
@Order(1)
@WebFilter
@Component
@Slf4j
public class MdcFilter implements Filter {
    private static final String REQUEST_KEY = "request";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        insertIntoMDC(request);
        try {
            chain.doFilter(request, response);
        } finally {
            clearMDC();
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private void clearMDC() {
        MDC.remove(REQUEST_KEY);
    }

    private void insertIntoMDC(ServletRequest request) {
        MDC.put(REQUEST_KEY, UUID.randomUUID().toString().replace("-", "").toLowerCase());
    }

}
