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
import java.util.List;


/**
 * Created by hp on 2017/11/24.
 */
@WebServlet(name = "findCpAllServlet",urlPatterns = "/findCpAll")
public class findCpAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = MybatisUtil.getSession();
        C_pDao dao = session.getMapper(C_pDao.class);

        List<C_p> cpAllList=dao.queryAll();
        request.getSession(true).setAttribute("cpAllList",cpAllList);
        response.sendRedirect("readCpAll.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
