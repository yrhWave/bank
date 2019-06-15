package com.yrh.bank.filter;

import javax.servlet.*;
import java.io.IOException;


public class EncodingFilter implements Filter {

    private String charSet;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.charSet = config.getInitParameter("charset");
        System.out.println("编码过滤器初始化成功！");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

/*        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;*/
        request.setCharacterEncoding(this.charSet);

        chain.doFilter(request, response);
    }


    @Override
    public void destroy() {
        System.out.println("编码过滤器已销毁！");
    }
}

