package cn.angetech.test;

import cn.angetech.dao.IAccountDao;
import cn.angetech.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run() throws Exception{
        Account account = new Account();
        account.setName("姓名");
        account.setMoney(200d);
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlsessionfactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);

        iAccountDao.saveAccount(account);

        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void run2() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlsessionfactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccountDao iAccountDao = sqlSession.getMapper(IAccountDao.class);
        List<Account> list = iAccountDao.findAll();
        for(Account account: list){
            System.out.println(account);
        }
        sqlSession.close();
        inputStream.close();
    }

}
