package tes.tes.tse.emailAjax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/check")
public class Check {

    private MemberDAO dao = new MemberDAO();

    @RequestMapping("/checkEmail")
    public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        System.out.println("test");
        
        PrintWriter resp = response.getWriter();

        String email = request.getParameter("email");

        try {
            boolean result = dao.isEmailExist(email);

            if (result) { // true 
                resp.println("이미 사용중인 email 입니다.");
                System.out.println("성공");
            } else { // false
                resp.println("사용 가능한 email 입니다.");
                System.out.println("실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.println("조회하는 도중 오류가 발생했습니다.");
            System.out.println("오류");
        }
        
    }
}