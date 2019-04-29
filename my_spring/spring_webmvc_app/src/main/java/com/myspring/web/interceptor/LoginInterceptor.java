package com.myspring.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {
  private static final String[] IGNORE_URI = {"/login"};

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("This is afterCompletion!");
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("This is postHandle!");
  }

  @Override
  // 拦截请求用户是否登陆
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("This is preHandle!");
        // flag 表示是否登录
        boolean flag = false;
        // 获取请求的 URL
        String url = request.getServletPath();
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            // 获取 Session 并判断是否登录 
            String username = (String) request.getSession().getAttribute(
                    "username");
            if (username == null) {
                request.setAttribute("message", "Please log in first!");
                // 如果未登录，进行拦截，跳转到登录界面
                request.getRequestDispatcher("/WEB-INF/views/loginform.jsp")
                        .forward(request, response);
            } else {
                flag = true;
            }
        }
        return flag;
  }
}