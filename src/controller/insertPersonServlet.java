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
@WebServlet(name = "insertPersonServlet",urlPatterns = "/insertPerson")
public class insertPersonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SqlSession session = MybatisUtil.getSession();
        PersonDao dao = session.getMapper(PersonDao.class);

        //创建perso类
        String name = request.getParameter("name");
        String password =request.getParameter("password");

        if(request.getParameter("password").equals("")){
            password="123456";
        }
        Person person = new Person();
        person.setPassword(password);
        person.setName(name);
        person.setIdentity("管理员");

        //检测是否有重名的
        if(dao.queryByPerson(person)!=null){
            response.sendRedirect("insertfail.jsp");
        }else {
            System.out.println(person.getName());
            System.out.println(person.getPassword());
            System.out.println(person.getIdentity());

            dao.insertPerson(person);
            session.commit();
            session.close();
            response.sendRedirect("findPersonAll");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Test
    public void test1(){
        SqlSession session = MybatisUtil.getSession();
        PersonDao dao = session.getMapper(PersonDao.class);

        //创建perso类
        String name = "aaa";
        String password ="";

        if(password.equals("")){
            password="123456";
        }
        Person person = new Person();
        person.setPassword(password);
        person.setName(name);
        person.setIdentity("管理员");

        System.out.println(dao.queryByPerson(person)!=null);
        //检测是否有重名的
        if(dao.queryByPerson(person)!=null){
            System.out.println("重复");
        }else {
            System.out.println(person.getName());
            System.out.println(person.getPassword());
            System.out.println(person.getIdentity());

            dao.insertPerson(person);
            session.commit();
            session.close();
        }
    }
}
