//package com.beadnet.test;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import study.jsp.helper.BaseController;
//import study.jsp.helper.RegexHelper;
//import study.jsp.helper.WebHelper;
//import study.jsp.movie.dao.MyBatisConnectionFactory;
//import study.jsp.movie.model.Member;
//import study.jsp.movie.service.MemberService;
//import study.jsp.movie.servie.impl.MemberServiceImpl;
//
//@WebServlet("/user_common/find_id.do")
//public class FindId extends BaseController {
//
//	private static final long serialVersionUID = -3475522699663957330L;
//
//    /** (1) 사용하고자 하는 Helper 객체 선언 */
//    Logger logger;
//    SqlSession sqlSession;
//    WebHelper web;
//    MemberService memberService;
//    RegexHelper regex;
//	
//    @Override
//	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    
//	    /** (2) 사용하고자 하는 Helper+Service 객체 생성 */
//        logger = LogManager.getFormatterLogger(request.getRequestURI());
//        sqlSession = MyBatisConnectionFactory.getSqlSession();
//        web = WebHelper.getInstance(request, response);
//        memberService = new MemberServiceImpl(sqlSession, logger);
//        regex = RegexHelper.getInstance();
//        
//        /** (3) 로그인 여부 검사 */
//        // 로그인 중이라면 이 페이지를 이용할 수 없다.
//        if (web.getSession("loginInfo") != null) {
//            sqlSession.close();
//            web.redirect(web.getRootPath() + "/index.do", "이미 로그인 중입니다.");
//            return null;
//        }
//        
//        String userEmail = web.getString("user_email");
//        
//        
//        // 이메일 검사
//        if (!regex.isValue(userEmail)) {
//            sqlSession.close();
//            web.redirect(null, "이메일을 입력하세요.");
//            return null;
//        }
//
//        if (!regex.isEmail(userEmail)) {
//            sqlSession.close();
//            web.redirect(null, "이메일의 형식이 잘못되었습니다.");
//            return null;
//        }
//        
//      Member member = new Member(null, null, null, userEmail, null, null, null, null,  null,  null, null);
//        
//        try {
//            member = memberService.selectIdMember(member);
//        }    
//        catch (Exception e) {
//            web.redirect(null, e.getLocalizedMessage());
//            return null;
//        } finally {
//            sqlSession.close();
//        }
//        
//        web.redirect(null, "회원님의 ID  " + member.getUserId() + "입니다.");
//		return null;
//	}
//}
