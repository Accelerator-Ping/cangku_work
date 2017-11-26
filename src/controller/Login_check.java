package controller;

import DAO.C_pDao;
import DAO.PersonDao;
import PO.Person;
import PO.C_p;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MybatisUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hp on 2017/11/21.
 */
public class Login_check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String type     = request.getParameter("type");

        //加载Util得到session
        SqlSession session =MybatisUtil.getSession();
        //得到dao的实现类
        PersonDao dao = session.getMapper(PersonDao.class);


        Person person = new Person();
        person.setName(username);
        person.setIdentity(type);
        person.setPassword(password);
        person=dao.queryByPerson(person);
        //session.commit();
        session.close();

        if(person==null){
            response.sendRedirect("loginfail.jsp");
        }else if (type.equals("老板")){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("shenfen",type);
            response.sendRedirect("boss_login.jsp");
        }else if(type.equals("管理员")){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("shenfen",type);
            response.sendRedirect("findCargoAll");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
