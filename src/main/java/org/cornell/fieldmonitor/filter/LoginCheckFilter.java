package org.cornell.fieldmonitor.filter;


import com.alibaba.fastjson.JSON;
import org.cornell.fieldmonitor.common.BaseContext;
import org.cornell.fieldmonitor.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    是否完成登录
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //path matcher
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.get request URI
        String requestURI = request.getRequestURI();
        //2.define non-intercept path
        String[] urls = new String[]{
                "/demo1/**",
                "/common/**",
                "/user/login"
        };
        boolean flag = check(urls,requestURI);

        //2.1 if had login, then pass
        if(flag){
            filterChain.doFilter(request,response);
            return ;
        }

        if(request.getSession().getAttribute("user") != null){

            //get user id through thread
            Long empId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return ;
        }

//        if(request.getSession().getAttribute("user") != null){
//            log.info("id：{}",request.getSession().getAttribute("user"));
//
//            Long userId = (Long) request.getSession().getAttribute("user");
//            BaseContext.setCurrentId(userId);
//
//            filterChain.doFilter(request,response);
//            return;
//        }

        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;

    }

    public boolean check(String[] nonCheck,String requestURI){
        if(nonCheck == null){
            return true;
        }
        if(requestURI == null){
            return false;
        }

        for(String i : nonCheck){
            boolean match = PATH_MATCHER.match(i,requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
