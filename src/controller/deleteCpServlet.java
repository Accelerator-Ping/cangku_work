package controller;

import DAO.C_pDao;
import PO.C_p;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 2017/11/24.
 */
@WebServlet(name = "deleteCpServlet",urlPatterns = "/deleteCp")
public class deleteCpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = MybatisUtil.getSession();
        C_pDao dao = session.getMapper(C_pDao.class);

        C_p cp=new C_p();
        cp.setCargo_name(request.getParameter("cargo_name"));
        cp.setNumber(Integer.parseInt(request.getParameter("number")));
        cp.setOperation(request.getParameter("operation"));
        cp.setUser_name(request.getParameter("user_name"));

        dao.deletCp(cp);
        session.commit();
        session.close();
        response.sendRedirect("findCpAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
