package com.cx.bank.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         System.out.println("请求验证过滤器初始化成功！") ;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Session属于HTTP范畴，所以ServletRequest对象需要先转换成HttpServletRequest对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession();
        String uname = (String)session.getAttribute("userName");
        // 如果session不为空，则可以浏览其他页面
        String currentURL=req.getRequestURI();
        System.out.println(currentURL);
       /*if (!("/servlet".equals(currentURL)|"/login.jsp".equals(currentURL))) */
        if (!("login".equals(currentURL)|"/login.jsp".equals(currentURL))){
            if (uname==null || session.getAttribute("userName")==null ) {
                resp.sendRedirect("login.jsp");
                System.out.println("你没有登录！");
                return;
            }
        }
        chain.doFilter(request,response);

    }
    @Override
    public void destroy() {
        System.out.println("请求验证过滤器已销毁！");
    }
}
