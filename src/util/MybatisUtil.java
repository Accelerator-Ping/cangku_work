package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by hp on 2017/11/22.
 */
public class MybatisUtil {
    private static SqlSessionFactory factory=null;
    static{
        try {
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            factory=builder.build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        SqlSession session=factory.openSession();
        return session;
    }
    public static void close(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
