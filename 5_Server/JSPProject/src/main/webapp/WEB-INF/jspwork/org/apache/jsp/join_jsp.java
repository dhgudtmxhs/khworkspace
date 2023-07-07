/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-06 07:58:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>ohsjoin</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/join.css\">\r\n");
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
      out.write("        <header>\r\n");
      out.write("            <selection>\r\n");
      out.write("                <img src=\"resources/images/humanmadelogo.svg\" style=\"width:150px;\">\r\n");
      out.write("                \r\n");
      out.write("            </selection>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("    <selection class=\"content\">\r\n");
      out.write("\r\n");
      out.write("        <selectionmargin></selectionmargin>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\" id = \"sel1\">\r\n");
      out.write("            \r\n");
      out.write("            <img src=\"resources/images/id.png\" style=\"width:50px; height:45px;\">\r\n");
      out.write("             <input type=\"text\" size =\"50\" maxlength=\"14\" \r\n");
      out.write("            placeholder=\"아이디\" id = \"idInput\">\r\n");
      out.write("        \r\n");
      out.write("        </selection>\r\n");
      out.write("        \r\n");
      out.write("        <selection class=\"content1\" id = \"sel2dot1\">\r\n");
      out.write("            <img src=\"resources/images/password2.png\" style=\"width:50px; height:45px;\">\r\n");
      out.write("            <input type=\"password\" size = \"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"비밀번호\" id = \"pwInput1\" >\r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\" id = \"sel2dot2\">\r\n");
      out.write("            <img src=\"resources/images/password.jpg\" style=\"width:50px;\" >\r\n");
      out.write("            <input type=\"password\" size = \"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"비밀번호 확인\" id = \"pwInput2\">\r\n");
      out.write("        </selection>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <selectionmargin>\r\n");
      out.write("            <span style=\"margin-left:22px;\" id=\"firstSpan\"></span>\r\n");
      out.write("        </selectionmargin>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\" id=\"sel4\">\r\n");
      out.write("            \r\n");
      out.write("            <div>\r\n");
      out.write("                <img src=\"../이미지/name.png\" style=\"width:30px; height:30px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("           \r\n");
      out.write("            <input type=\"text\" size =\"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"이름\" id=\"nameInput\">\r\n");
      out.write("            \r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\" id=\"sel5\">\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("            <img src=\"../이미지/birth.png\" style=\"width:28px; height:28px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"text\" size =\"50\" maxlength=\"10\" \r\n");
      out.write("            placeholder=\"생년월일 8자리 (-포함)\" id=\"birthInput\">\r\n");
      out.write("\r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selection class=\"content1\" id=\"sel3\">\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("            <img src=\"../이미지/email.jpg\" style=\"width:32px; height:35px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <input type = \"email\" size = \"50\" \r\n");
      out.write("            placeholder=\"비밀번호 분실시 확인용 이메일\" id=\"emailInput\"> \r\n");
      out.write("       \r\n");
      out.write("        </selection>\r\n");
      out.write("        \r\n");
      out.write("        <selection class=\"content1\" id=\"sel6\" >\r\n");
      out.write("            \r\n");
      out.write("            <div>\r\n");
      out.write("                <img src=\"../이미지/gender3.jpg\" style=\"width:35px; height:35px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div1 >\r\n");
      out.write("            <label for=\"man\"><button class=\"btn\" id=\"btn1\">\r\n");
      out.write("                <div style=\"width:10px; margin-top:4px;\">남</div>\r\n");
      out.write("                <input type=\"radio\" name=\"gender\" id=\"man\"></button>\r\n");
      out.write("            </label>\r\n");
      out.write("            </div1>\r\n");
      out.write("\r\n");
      out.write("            <div1 id=\"input2\">\r\n");
      out.write("            <label for=\"woman\"><button class=\"btn\" id=\"btn2\">\r\n");
      out.write("                <div style=\"width:10px; margin-top:7px;\">여</div>\r\n");
      out.write("                <input type=\"radio\" name=\"gender\" id=\"woman\"></button>\r\n");
      out.write("            </label>\r\n");
      out.write("            </div1>\r\n");
      out.write("\r\n");
      out.write("        </selection>\r\n");
      out.write("            \r\n");
      out.write("        <selection class=\"content1\" id=\"sel7\">\r\n");
      out.write("            \r\n");
      out.write("                <div>\r\n");
      out.write("                <img src=\"../이미지/foreign.jpg\" style=\"width:40px; height:40px;\">\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <label for=\"korean\">\r\n");
      out.write("                   \r\n");
      out.write("                    <button class=\"btn\" id=\"btn3\">\r\n");
      out.write("                        <div style=\"width:38px; margin-top:4px;\">내국인</div>\r\n");
      out.write("                        <input type=\"radio\" name=\"nationality\" id=\"korean\"></button>\r\n");
      out.write("                \r\n");
      out.write("                </label>\r\n");
      out.write("               \r\n");
      out.write(" \r\n");
      out.write("                <label for=\"foreigner\">\r\n");
      out.write("                    \r\n");
      out.write("                    <button class=\"btn\" id=\"btn4\" >\r\n");
      out.write("                        <div style=\"width:38px; margin-top:4px;\">외국인</div>\r\n");
      out.write("                        <input type=\"radio\" name=\"nationality\" id=\"foreigner\"></button>\r\n");
      out.write("                \r\n");
      out.write("                </label>\r\n");
      out.write("        \r\n");
      out.write("            </selection>\r\n");
      out.write("        \r\n");
      out.write("        <selection class=\"content1\" id=\"sel8\">\r\n");
      out.write("            \r\n");
      out.write("            <div>\r\n");
      out.write("            <img src=\"../이미지/phone4.png\" style=\"width:30px; height:30px;\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <input type=\"text\" size=\"50\" placeholder=\"전화번호 (-포함)\" id=\"phoneInput\">\r\n");
      out.write("\r\n");
      out.write("        </selection>\r\n");
      out.write("\r\n");
      out.write("        <selectionmargin>\r\n");
      out.write("            <span style=\"margin-left:22px;\" id=\"secondSpan\"></span>\r\n");
      out.write("        </selectionmargin> \r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("    </selection>\r\n");
      out.write("\r\n");
      out.write("    <selection class=\"content2\" id=\"sel9\" style=\"border-radius:30px;\">\r\n");
      out.write("\r\n");
      out.write("        <article style=\"border-radius: 20px;\">\r\n");
      out.write("         <input type=\"radio\" id=\"agree\">    \r\n");
      out.write("         <a style=\"font-size:17px; font-weight:bold; font-family: 'Hi Melody', cursive;\r\n");
      out.write("                    margin-top:5px; margin-left:5px;\">\r\n");
      out.write("            [필수] 인증 약관 전체동의</a>\r\n");
      out.write("         <img src=\"../이미지/v.jfif\">\r\n");
      out.write("        </article>\r\n");
      out.write("\r\n");
      out.write("    </selection>\r\n");
      out.write("    <footer>\r\n");
      out.write("        <article>\r\n");
      out.write("            <button id=\"btn\">\r\n");
      out.write("            <a href=\"ohslogin.html\"\r\n");
      out.write("            style=\"font-family: 'Hi Melody', cursive;\">\r\n");
      out.write("            회원가입</a>\r\n");
      out.write("            </button>\r\n");
      out.write("        </article>\r\n");
      out.write("    </footer>\r\n");
      out.write(" \r\n");
      out.write("       <script>\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 아이디 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const idInput = document.getElementById(\"idInput\");\r\n");
      out.write("\r\n");
      out.write("            idInput.addEventListener(\"keyup\", function(){\r\n");
      out.write("              \r\n");
      out.write("                const regExp = /^([a-z]|[0-9]){6,14}$/;\r\n");
      out.write("                const firstSpan = document.getElementById(\"firstSpan\");\r\n");
      out.write("                const sel1 = document.getElementById(\"sel1\");\r\n");
      out.write("\r\n");
      out.write("                if(regExp.test(idInput.value)){\r\n");
      out.write("                    firstSpan.style.color = \"green\";\r\n");
      out.write("                    firstSpan.innerText = \" * 아이디가 형식에 맞습니다.\";\r\n");
      out.write("                    sel1.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                }else{\r\n");
      out.write("                    firstSpan.style.color = \"red\";\r\n");
      out.write("                    firstSpan.innerText = \" * 영어(소문자) , 숫자로만 이루어진 6~14 글자로 입력해주세요.\"\r\n");
      out.write("                    sel1.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("                \r\n");
      out.write("                idInput.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel1.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                idInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    firstSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 비번 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const pwInput1 = document.getElementById(\"pwInput1\");\r\n");
      out.write("            const pwInput2 = document.getElementById(\"pwInput2\");\r\n");
      out.write("            \r\n");
      out.write("            pwInput2.addEventListener(\"keyup\", function(){\r\n");
      out.write("                \r\n");
      out.write("                if(pwInput1.value == ''){\r\n");
      out.write("                    this.value = \"\";\r\n");
      out.write("                    alert(\"비밀번호를 입력해주세요\");\r\n");
      out.write("                    pwInput1.focus();\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            pwInput1.addEventListener(\"keyup\", function(){\r\n");
      out.write("                \r\n");
      out.write("                const regExp = /^([a-zA-Z0-9]){8,16}$/;\r\n");
      out.write("\r\n");
      out.write("                if(regExp.test(pwInput1.value)){\r\n");
      out.write("                    firstSpan.style.color = \"green\";\r\n");
      out.write("                    firstSpan.innerText = \" * 올바른 비밀번호입니다.\";\r\n");
      out.write("                    sel2dot1.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                }else{\r\n");
      out.write("                    firstSpan.style.color = \"red\";\r\n");
      out.write("                    firstSpan.innerText = \" * 영어, 숫자로만 8~16 글자로 입력해주세요.\";\r\n");
      out.write("                    sel2dot1.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                pwInput1.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel2dot1.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                pwInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    firstSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            pwInput2.addEventListener(\"keyup\", function(){\r\n");
      out.write("\r\n");
      out.write("            if( (pwInput1.value == pwInput2.value) && pwInput1.value.length != 0  ){\r\n");
      out.write("                firstSpan.style.color = \"green\";\r\n");
      out.write("                firstSpan.innerText = \"비밀번호 일치합니다.\";\r\n");
      out.write("                sel2dot2.style.border = \"3px solid lightcoral\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            } else{\r\n");
      out.write("                firstSpan.style.color = \"red\";\r\n");
      out.write("                firstSpan.innerText = \"비밀번호가 불일치합니다.\";\r\n");
      out.write("                sel2dot2.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            pwInput2.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(pwInput1.value != pwInput2.value){\r\n");
      out.write("                    sel3.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            if( pwInput1.value.length == 0 && pwInput2.value.length == 0 ){\r\n");
      out.write("                firstSpan.innerText = '';\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            pwInput2.addEventListener(\"change\", function(){\r\n");
      out.write("                    firstSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            \r\n");
      out.write("            /* ---------------------------------------- 이름 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const nameInput = document.getElementById(\"nameInput\");\r\n");
      out.write("            \r\n");
      out.write("            nameInput.addEventListener(\"keyup\", function(){\r\n");
      out.write("                const regExp = /^[가-힣]{2,5}$/;\r\n");
      out.write("\r\n");
      out.write("                if(regExp.test(nameInput.value)){\r\n");
      out.write("                    secondSpan.style.color = \"green\";\r\n");
      out.write("                    secondSpan.innerText = \" * 이름이 형식에 맞습니다.\";\r\n");
      out.write("                    sel4.style.border = \"3px solid lightcoral\";\r\n");
      out.write("\r\n");
      out.write("                } else {\r\n");
      out.write("                    secondSpan.style.color = \"red\";\r\n");
      out.write("                    secondSpan.innerText = \" * 형식(한글)에 맞게 입력해주세요.\";\r\n");
      out.write("                    sel4.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                nameInput.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel4.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("                nameInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    secondSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 생년월일 ---------------------------------------- */\r\n");
      out.write("          \r\n");
      out.write("            const birthInput = document.getElementById(\"birthInput\");\r\n");
      out.write("            \r\n");
      out.write("            birthInput.addEventListener(\"keyup\", function(){\r\n");
      out.write("                const regExp = /^[0-9]{4}\\-[0-9]{2}\\-[0-9]{2}$/;\r\n");
      out.write("\r\n");
      out.write("                if(regExp.test(birthInput.value)){\r\n");
      out.write("                    secondSpan.style.color = \"green\";\r\n");
      out.write("                    secondSpan.innerText = \" * 생년월일이 형식에 맞습니다.\";\r\n");
      out.write("                    sel5.style.border = \"3px solid lightcoral\";\r\n");
      out.write("\r\n");
      out.write("                } else {\r\n");
      out.write("                    secondSpan.style.color = \"red\";\r\n");
      out.write("                    secondSpan.innerText = \" * 형식에 맞게 입력해주세요.\";\r\n");
      out.write("                    sel5.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                birthInput.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel5.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("                birthInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    secondSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            /* ---------------------------------------- 이메일 ---------------------------------------- */\r\n");
      out.write("            \r\n");
      out.write("            const emailInput = document.getElementById(\"emailInput\");\r\n");
      out.write("\r\n");
      out.write("            emailInput.addEventListener(\"keyup\",function(){\r\n");
      out.write("\r\n");
      out.write("            const regExp = /^[a-zA-Z0-9]+@[a-z0-9]+\\.[a-z]{2,}$/;\r\n");
      out.write("               \r\n");
      out.write("                if(regExp.test(emailInput.value)){\r\n");
      out.write("                secondSpan.style.color = \"green\";\r\n");
      out.write("                secondSpan.innerText = \" * 이메일이 형식에 맞습니다.\"\r\n");
      out.write("                sel3.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                }else{\r\n");
      out.write("                    secondSpan.style.color = \"red\";\r\n");
      out.write("                    secondSpan.innerText = \" * 형식에 맞게 입력해주세요 (@사용, 도메인 입력).\"\r\n");
      out.write("                    sel3.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                emailInput.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel3.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("                emailInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    secondSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("             /* ---------------------------------------- 성별 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const gender = document.getElementsByName(\"gender\");\r\n");
      out.write("            const man = document.getElementById(\"man\");\r\n");
      out.write("            const woman = document.getElementById(\"woman\");\r\n");
      out.write("            const btn1 = document.getElementById(\"btn1\");\r\n");
      out.write("            const btn2 = document.getElementById(\"btn2\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            man.addEventListener(\"click\", function(){\r\n");
      out.write("                btn2.style.border = \"1px solid lightgray\";\r\n");
      out.write("                btn1.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                 sel6.style.border = \"3px solid lightcoral\"; \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            woman.addEventListener(\"click\", function(){\r\n");
      out.write("                btn1.style.border = \"1px solid lightgray\";\r\n");
      out.write("                btn2.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                 sel6.style.border = \"3px solid lightcoral\"; \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 국적 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const nationality = document.getElementsByName(\"nationality\");\r\n");
      out.write("            const korean = document.getElementById(\"korean\");\r\n");
      out.write("            const foreigner = document.getElementById(\"foreigner\");\r\n");
      out.write("            const btn3 = document.getElementById(\"btn3\");\r\n");
      out.write("            const btn4 = document.getElementById(\"btn4\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            korean.addEventListener(\"click\", function(){\r\n");
      out.write("                btn4.style.border = \"1px solid lightgray\";\r\n");
      out.write("                btn3.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                sel7.style.border = \"3px solid lightcoral\"; \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            foreigner.addEventListener(\"click\", function(){\r\n");
      out.write("                btn3.style.border = \"1px solid lightgray\";\r\n");
      out.write("                btn4.style.border = \"3px solid lightcoral\";\r\n");
      out.write("                 sel7.style.border = \"3px solid lightcoral\";\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 전화번호 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const phoneInput = document.getElementById(\"phoneInput\");\r\n");
      out.write("\r\n");
      out.write("            phoneInput.addEventListener(\"keyup\", function(){\r\n");
      out.write("                const regExp = /^[0-9]{2,3}\\-[0-9]{3,4}\\-[0-9]{3,4}$/;\r\n");
      out.write("\r\n");
      out.write("                if(regExp.test(phoneInput.value)){\r\n");
      out.write("                    secondSpan.style.color = \"green\";\r\n");
      out.write("                    secondSpan.innerText = \" * 전화번호가 형식에 맞습니다.\";\r\n");
      out.write("                    sel8.style.border = \"3px solid lightcoral\";\r\n");
      out.write("\r\n");
      out.write("                } else {\r\n");
      out.write("                    secondSpan.style.color = \"red\";\r\n");
      out.write("                    secondSpan.innerText = \" * 형식에 맞게 입력해주세요.\";\r\n");
      out.write("                    sel8.style.border = \"3px solid rgb(227 31 25)\";\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                phoneInput.addEventListener(\"blur\", function(){\r\n");
      out.write("                if(!regExp.test(this.value)){\r\n");
      out.write("                    sel8.style.border = \"1px solid lightgray\";\r\n");
      out.write("                    this.value = '';\r\n");
      out.write("                }\r\n");
      out.write("                })\r\n");
      out.write("\r\n");
      out.write("                phoneInput.addEventListener(\"change\", function(){\r\n");
      out.write("                    secondSpan.innerText = '';\r\n");
      out.write("                })\r\n");
      out.write("            \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 약관 동의 버튼 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const agree = document.getElementById(\"agree\");\r\n");
      out.write("\r\n");
      out.write("            agree.addEventListener(\"click\", function(){\r\n");
      out.write("                \r\n");
      out.write("                 sel9.style.border = \"3px solid lightcoral\";\r\n");
      out.write("               \r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("            /* ---------------------------------------- 회원가입버튼 ---------------------------------------- */\r\n");
      out.write("\r\n");
      out.write("            const btn = document.getElementById(\"btn\");\r\n");
      out.write("\r\n");
      out.write("            btn.addEventListener(\"click\", function(e){\r\n");
      out.write("                \r\n");
      out.write("                if(!gender[0].checked && !gender[1].checked){\r\n");
      out.write("                    alert(\"성별을 선택해주세요.\");\r\n");
      out.write("                    e.preventDefault(); \r\n");
      out.write("                }else if(!nationality[0].checked && !nationality[1].checked){\r\n");
      out.write("                    alert(\"국적을 선택해주세요.\");\r\n");
      out.write("                    e.preventDefault();\r\n");
      out.write("                }else if(!agree.checked){\r\n");
      out.write("                    alert(\"필수 약관에 동의해주세요.\");\r\n");
      out.write("                    e.preventDefault();\r\n");
      out.write("                }else {\r\n");
      out.write("                    alert(\"회원 가입 완료\");\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script> \r\n");
      out.write("\r\n");
      out.write("    </main>\r\n");
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
