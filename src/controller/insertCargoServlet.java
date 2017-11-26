package controller;

import DAO.C_pDao;
import DAO.CargoDao;
import PO.C_p;
import PO.Cargo;
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
@WebServlet(name = "insertCargoServlet",urlPatterns = "/insertCargo")
public class insertCargoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SqlSession session = MybatisUtil.getSession();
        CargoDao dao = session.getMapper(CargoDao.class);
        C_pDao dao2 =session.getMapper(C_pDao.class);

        Cargo cargo = new Cargo();
        cargo.setName(request.getParameter("name"));
        cargo.setNum(Integer.parseInt(request.getParameter("num")));
        cargo.setType(request.getParameter("type"));

        C_p cp=new C_p();
        cp.setUser_name((String) request.getSession(true).getAttribute("username"));
        cp.setCargo_name(cargo.getName());
        cp.setOperation("增加新货物");
        cp.setNumber(cargo.getNum());

        dao.insertCargo(cargo);
        dao2.insertCp(cp);
        session.commit();
        session.close();

        response.sendRedirect("findCargoAll");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
