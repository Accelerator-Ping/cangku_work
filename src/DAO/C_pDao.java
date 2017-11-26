package DAO;

import PO.C_p;

import java.util.List;

/**
 * Created by hp on 2017/11/23.
 */
public interface C_pDao {
    //按员工名称读取
    public List<C_p> queryByName(String user_name);
    //获得全部信息
    public List<C_p> queryAll();
    //按名字删除记录
    public void deletPerson(String name);
    //全部匹配删除
    public void deletCp(C_p cp);
    //添加记录
    public void insertCp(C_p cp);
}
