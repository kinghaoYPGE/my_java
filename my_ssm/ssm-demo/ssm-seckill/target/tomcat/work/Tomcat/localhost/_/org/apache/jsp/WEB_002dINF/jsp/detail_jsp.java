/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-02 15:46:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/jsp/common/footer.jsp", Long.valueOf(1557670073987L));
    _jspx_dependants.put("/WEB-INF/jsp/common/header.jsp", Long.valueOf(1557670069554L));
    _jspx_dependants.put("/WEB-INF/jsp/common/tag.jsp", Long.valueOf(1557670064512L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<!--移动设备优先-->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<!--切换为bootstrap3，bootstrap4不提供默认图标了-->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/twitter-bootstrap/3.1.0/css/bootstrap.min.css\">");
      out.write("\r\n");
      out.write("    <title>秒杀详情页</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"\"container>\r\n");
      out.write("    <div class=\"panel panel-default\">\r\n");
      out.write("        <div class=\"panel-heading text-center\">\r\n");
      out.write("            <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h1>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"panel-body text-center\">\r\n");
      out.write("            <h2 class=\"text-danger\">\r\n");
      out.write("                <span class=\"glyphicon glyphicon-time\"></span>\r\n");
      out.write("                <!--倒计时-->\r\n");
      out.write("                <span class=\"glyphicon\" id=\"seckill-box\"></span>\r\n");
      out.write("            </h2>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--手机注册-->\r\n");
      out.write("<div id=\"killPhoneModal\" class=\"modal fade\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h3 class=\"modal-title text-center\">\r\n");
      out.write("                    <span class=\"glyphicon glyphicon-phone\">秒杀电话</span>\r\n");
      out.write("                </h3>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-xs-8 col-xs-offset-2\">\r\n");
      out.write("                        <input type=\"text\" name=\"killPhone\" id=\"killPhoneKey\"\r\n");
      out.write("                               placeholder=\"请填写手机号码\" class=\"form-control\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer\">\r\n");
      out.write("                <span id=\"killPhoneMessage\" class=\"glyphicon\"></span>\r\n");
      out.write("                <button type=\"button\" id=\"killPhoneBtn\" class=\"btn btn-success btn-sm\">\r\n");
      out.write("                    <span class=\"glyphicon glyphicon-phone\">提交</span>\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap3 核心 JavaScript 文件 -->\r\n");
      out.write("<script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.1.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!--bootstrap CDN cookie插件-->\r\n");
      out.write("<script src=\"https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js\"></script>\r\n");
      out.write("<!--bootstrap CDN countdown插件-->\r\n");
      out.write("<script src=\"https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js\"></script>\r\n");
      out.write("<script src=\"/resources/script/seckill.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(function () {\r\n");
      out.write("        seckill.detail.init({\r\n");
      out.write("            seckillId : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.seckillId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("            startTime: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.startTime.time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("            endTime: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.endTime.time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",\r\n");
      out.write("            number : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${seckill.number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
