package controller;

import DAO.C_pDao;
import DAO.PersonDao;
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
 * 从c_p person中删除记录
 * Created by hp on 2017/11/23.
 */
@WebServlet(name = "deletePersonServlet",urlPatterns = "/deletePerson")
public class deletePersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = MybatisUtil.getSession();
        PersonDao dao = session.getMapper(PersonDao.class);
        C_pDao dao2 = session.getMapper(C_pDao.class);
        String name=request.getParameter("name");
        dao2.deletPerson(name);
        dao.deletPerson(name);

        session.commit();
        session.close();
        response.sendRedirect("findPersonAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
