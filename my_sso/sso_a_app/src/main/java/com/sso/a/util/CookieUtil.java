package com.sso.a.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置cookie
 */
public class CookieUtil {
    /**
     * 获取cookie
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie :
                    cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 设置cookie
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param maxAge:cookie存活时间
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setDomain("test.com");
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
}
