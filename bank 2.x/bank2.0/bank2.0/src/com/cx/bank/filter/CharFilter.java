package com.cx.bank.filter;

import javax.servlet.*;
import java.io.IOException;


public class CharFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("非法字符拦截器已销毁！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        String content = request.getParameter("content");

        // 如果indexOf返回-1则表示没有查到所要的内容

        if (content != null) {
            if (content.indexOf("AAA") == -1) {
                chain.doFilter(request, response);
            } else {
                System.out.println("有非法文字");
                // 如果需要的话，此处依然可以使用RequestDispatcher进行跳转
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

        System.out.println("非法字符拦截器初始化成功！");
    }

}
