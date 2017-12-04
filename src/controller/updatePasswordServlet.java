package controller;

import DAO.PersonDao;
import PO.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
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
@WebServlet(name = "updatePasswordServlet",urlPatterns = "/updatePassword")
public class updatePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SqlSession session = MybatisUtil.getSession();
        PersonDao dao = session.getMapper(PersonDao.class);

        Person person = new Person();
        person.setName((String) request.getSession().getAttribute("username"));
        person.setPassword(request.getParameter("password"));
        person.setIdentity((String) request.getSession().getAttribute("shenfen"));
        String newPassword = request.getParameter("newPassword");

        //查询旧密码是否正确
        if(dao.queryByPerson(person)==null){
            response.sendRedirect("loginfail.jsp");
        }else{
            person.setPassword(newPassword);
            dao.updatePassword(person);

            session.commit();
            session.close();
            response.sendRedirect("index.jsp");
        }
        session.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Test
    public void test(){
        int a=0;
        a++;
        a++;
        a++;

    }

}
