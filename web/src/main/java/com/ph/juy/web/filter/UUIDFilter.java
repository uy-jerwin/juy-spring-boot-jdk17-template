package com.ph.juy.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "com.ph.juy.web.filter.UUIDFilter", urlPatterns = "/*")
public class UUIDFilter extends OncePerRequestFilter {

    public static final String ID = "X-REQUEST-ID";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestId = request.getHeader(ID);
        response.setHeader(ID, StringUtils.isNotBlank(requestId) ? requestId : UUID.randomUUID().toString());
        filterChain.doFilter(request, response);
    }

}
