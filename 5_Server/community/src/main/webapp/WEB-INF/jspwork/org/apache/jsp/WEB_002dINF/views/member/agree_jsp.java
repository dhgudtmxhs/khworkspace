/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-20 09:05:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class agree_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>agree</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/agree.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/join\" method =\"get\" onsubmit=\"return agreeCheck()\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"divKing\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"divs\" id=\"firstDiv\">\r\n");
      out.write("            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/foreign.jpg\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <section>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"divs\" id=\"secondDiv\">\r\n");
      out.write("          \r\n");
      out.write("\r\n");
      out.write("            <input type=\"checkbox\" id=\"checkAll\" class=\"boxs\" >\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"checkAll\" class=\"labels\">\r\n");
      out.write("                <span id=\"bold\">축제축제의 개인정보 처리방침, 서비스 이용약관, 마케팅 수신 여부에 대해 모두 동의합니다.</span>\r\n");
      out.write("            </label>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"divs\" id=\"thirdDiv\">\r\n");
      out.write("            \r\n");
      out.write("        <article>\r\n");
      out.write("            <input type=\"checkbox\" id=\"checkOne\" class=\"boxs\" >\r\n");
      out.write("            <label for=\"checkOne\" class=\"labels\">\r\n");
      out.write("                <span class=\"spans\">개인정보 처리방침 동의 <span class=\"necessary\">(필수)</span></span>\r\n");
      out.write("            </label>\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        <article class=\"textareaArticle\">\r\n");
      out.write("            <textarea readonly>\r\n");
      out.write("                여러분을 환영합니다.\r\n");
      out.write("                네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 \r\n");
      out.write("                이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 \r\n");
      out.write("                이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, \r\n");
      out.write("                아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.\r\n");
      out.write("    \r\n");
      out.write("                네이버 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 \r\n");
      out.write("                본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 \r\n");
      out.write("                주의 깊게 살펴봐 주시기 바랍니다.\r\n");
      out.write("                \r\n");
      out.write("                다양한 네이버 서비스를 즐겨보세요.\r\n");
      out.write("                네이버는 www.naver.com을 비롯한 네이버 도메인의 웹사이트 및 응용프로그램(어플리케이션, 앱)을 통해 \r\n");
      out.write("                정보 검색, 다른 이용자와의 커뮤니케이션, 콘텐츠 제공, 상품 쇼핑 등 여러분의 생활에 편리함을 \r\n");
      out.write("                더할 수 있는 다양한 서비스를 제공하고 있습니다.여러분은 PC, 휴대폰 등 인터넷 이용이 \r\n");
      out.write("                가능한 각종 단말기를 통해 각양각색의 네이버 서비스를 자유롭게 이용하실 수 있으며, \r\n");
      out.write("                개별 서비스들의 구체적인 내용은 각 서비스 상의 안내, 공지사항, 네이버 \r\n");
      out.write("                웹고객센터(이하 ‘고객센터’) 도움말 등에서 쉽게 확인하실 수 있습니다.\r\n");
      out.write("                \r\n");
      out.write("                네이버는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다. \r\n");
      out.write("                다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 \r\n");
      out.write("                연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, \r\n");
      out.write("                이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다. \r\n");
      out.write("                자세한 내용은 역시 각 서비스 상의 안내, 공지사항, \r\n");
      out.write("                고객센터 도움말 등에서 확인하실 수 있습니다.\r\n");
      out.write("\r\n");
      out.write("            </textarea>\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"divs\" id=\"forthDiv\"> \r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            <article>\r\n");
      out.write("            <input type=\"checkbox\" id=\"checkTwo\" class=\"boxs\">\r\n");
      out.write("           \r\n");
      out.write("            <label for=\"checkTwo\" class=\"labels\">\r\n");
      out.write("                \r\n");
      out.write("                <span class=\"spans\">서비스 이용약관 동의 <span class=\"necessary\">(필수)</span></span>\r\n");
      out.write("\r\n");
      out.write("            </label>\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        <article class=\"textareaArticle\">\r\n");
      out.write("\r\n");
      out.write("            <textarea readonly>\r\n");
      out.write("                네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 \r\n");
      out.write("                이용과 관련하여 네이버 서비스를 제공하는 네이버 주식회사(이하 ‘네이버’)와 \r\n");
      out.write("                이를 이용하는 네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, \r\n");
      out.write("                아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.\r\n");
      out.write("\r\n");
      out.write("                네이버 서비스를 이용하시거나 네이버 서비스 회원으로 가입하실 경우 여러분은 \r\n");
      out.write("                본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 \r\n");
      out.write("                주의 깊게 살펴봐 주시기 바랍니다.\r\n");
      out.write("                \r\n");
      out.write("                다양한 네이버 서비스를 즐겨보세요.\r\n");
      out.write("                네이버는 www.naver.com을 비롯한 네이버 도메인의 웹사이트 및 응용프로그램(어플리케이션, 앱)을 통해 \r\n");
      out.write("                정보 검색, 다른 이용자와의 커뮤니케이션, 콘텐츠 제공, 상품 쇼핑 등 여러분의 생활에 편리함을 \r\n");
      out.write("                더할 수 있는 다양한 서비스를 제공하고 있습니다.여러분은 PC, 휴대폰 등 인터넷 이용이 \r\n");
      out.write("                가능한 각종 단말기를 통해 각양각색의 네이버 서비스를 자유롭게 이용하실 수 있으며, \r\n");
      out.write("                개별 서비스들의 구체적인 내용은 각 서비스 상의 안내, 공지사항, 네이버 \r\n");
      out.write("                웹고객센터(이하 ‘고객센터’) 도움말 등에서 쉽게 확인하실 수 있습니다.\r\n");
      out.write("                \r\n");
      out.write("                네이버는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다. \r\n");
      out.write("                다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 \r\n");
      out.write("                연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, \r\n");
      out.write("                이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다. \r\n");
      out.write("                자세한 내용은 역시 각 서비스 상의 안내, 공지사항, \r\n");
      out.write("                고객센터 도움말 등에서 확인하실 수 있습니다.\r\n");
      out.write("            </textarea>\r\n");
      out.write("       \r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"divs\" id=\"fifthDiv\">\r\n");
      out.write("           \r\n");
      out.write("        <article>\r\n");
      out.write("            <input type=\"checkbox\" id=\"checkThree\" class=\"boxs\" >\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"checkThree\" class=\"labels\">\r\n");
      out.write("                \r\n");
      out.write("                <span class=\"spans\">마케팅 수신 동의 <span id=\"notNecessary\">(선택)</span></span>\r\n");
      out.write("\r\n");
      out.write("            </label>\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("        <article class=\"textareaArticle\">\r\n");
      out.write("\r\n");
      out.write("            <textarea readonly>\r\n");
      out.write("                여러분을 환영합니다.\r\n");
      out.write("                네이버 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.\r\n");
      out.write("                본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 \r\n");
      out.write("                제공하는 네이버 주식회사(이하 ‘네이버’)와 이를 이용하는 \r\n");
      out.write("                네이버 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, \r\n");
      out.write("                아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 \r\n");
      out.write("                포함하고 있습니다.\r\n");
      out.write("            </textarea>\r\n");
      out.write("\r\n");
      out.write("        </article>    \r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("	\r\n");
      out.write("        <div class=\"divs\" id=\"sixthDiv\">\r\n");
      out.write("            <button id = \"btn\">다음</button>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    \r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("            <footer>\r\n");
      out.write("\r\n");
      out.write("			<sec class=\"find1\">\r\n");
      out.write("\r\n");
      out.write("				<a> 이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 </a>\r\n");
      out.write("\r\n");
      out.write("			</sec>\r\n");
      out.write("\r\n");
      out.write("			<sec class=\"find1\">\r\n");
      out.write("\r\n");
      out.write("				<sec>\r\n");
      out.write("\r\n");
      out.write("					<a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>\r\n");
      out.write("\r\n");
      out.write("				</sec>\r\n");
      out.write("\r\n");
      out.write("			</sec>\r\n");
      out.write("		</footer>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/agree.js\"></script> \r\n");
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
