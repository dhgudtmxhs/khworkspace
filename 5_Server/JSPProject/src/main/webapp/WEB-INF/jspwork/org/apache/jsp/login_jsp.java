/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-06 07:58:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>login</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/login.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <main>\r\n");
      out.write("\r\n");
      out.write("        <header >\r\n");
      out.write("            <selection>\r\n");
      out.write("                <img src=\"resources/images/humanmadelogo.svg\" style=\"width:150px;\">\r\n");
      out.write("                \r\n");
      out.write("            </selection>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <div style=\"height:50px;\"></div>\r\n");
      out.write("    <selection class=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <selectionmargin></selectionmargin>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\">\r\n");
      out.write("             \r\n");
      out.write("            <img src=\"resources/images/id.png\" style=\"width:50px; height:45px;\">\r\n");
      out.write("             <input type=\"text\" size =\"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"아이디\" id=\"idInput\">\r\n");
      out.write("        \r\n");
      out.write("        </selection>\r\n");
      out.write("        <span id=\"spsp\"></span>\r\n");
      out.write("        <selection class=\"content1\">\r\n");
      out.write("            <img src=\"resources/images/password.jpg\" style=\"width:50px;\">\r\n");
      out.write("            <input type=\"password\" size = \"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"비밀번호\">\r\n");
      out.write("        </selection>\r\n");
      out.write("        \r\n");
      out.write("        <selection class=\"content1\" style=\"border:0; margin-right:3px;\">\r\n");
      out.write("           \r\n");
      out.write("            <div style=\"width:30px;\">\r\n");
      out.write("           <input type=\"radio\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <input type = \"email\" size = \"50\" \r\n");
      out.write("            placeholder=\"로그인 상태 유지\"> \r\n");
      out.write("       \r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <selection class=\"content1\">\r\n");
      out.write("            <button id=\"btn1\">\r\n");
      out.write("                <a href=\"#\"\r\n");
      out.write("                style=\"font-family: 'Hi Melody', cursive;\">\r\n");
      out.write("                로그인</a>\r\n");
      out.write("            </button>    \r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\"  style=\"border:0;\">\r\n");
      out.write("            <div class=\"find\"><a href=\"#\">아이디 찾기</a></div>\r\n");
      out.write("            <span>|</span>\r\n");
      out.write("            <div class=\"find\"><a href=\"#\">비밀번호 찾기</a></div>\r\n");
      out.write("            <span>|</span>\r\n");
      out.write("            <div class=\"find\">\r\n");
      out.write("                <a href=\"join.jsp\">\r\n");
      out.write("                    회원가입\r\n");
      out.write("                </a></div>\r\n");
      out.write("\r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </selection>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div style=\"height:50px;\"></div>\r\n");
      out.write("\r\n");
      out.write("    <footer>\r\n");
      out.write("        <selection class=\"find1\">\r\n");
      out.write("            \r\n");
      out.write("            <a >\r\n");
      out.write("            이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 \r\n");
      out.write("            </a>\r\n");
      out.write("            \r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"find1\">\r\n");
      out.write("            <selection ><a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>\r\n");
      out.write("            </selection>\r\n");
      out.write("         \r\n");
      out.write("        </selection>\r\n");
      out.write("    </footer>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            document.getElementById(\"btn1\").addEventListener(\"click\", function(){\r\n");
      out.write("                alert(\"로그인 완료\");\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}