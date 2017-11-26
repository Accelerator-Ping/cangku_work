package controller;

import DAO.PersonDao;
import PO.Person;
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
 * 得到全部职员信息，展示在表单中
 * Created by hp on 2017/11/23.
 */
@WebServlet(name = "findPeronAll",urlPatterns = {"/findPersonAll"})
public class findPeronAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession session = MybatisUtil.getSession();
        PersonDao dao =session.getMapper(PersonDao.class);

        List<Person> personList=dao.queryPersonAll();
        request.getSession(true).setAttribute("personList",personList);
        response.sendRedirect("readPersonAll.jsp");
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
