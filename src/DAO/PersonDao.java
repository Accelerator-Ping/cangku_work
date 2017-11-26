package DAO;

import PO.Person;

import java.util.List;

/**
 * Created by hp on 2017/11/22.
 */
public interface PersonDao {
    public void insertPerson(Person p);
    //账号、密码、身份查询
    public Person queryByPerson(Person p);
    public List<Person> queryPersonAll();
    public void deletPerson(String name);
    public void updatePassword(Person person);
}
