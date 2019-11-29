package cn.angetech.service.impl;

import cn.angetech.dao.IAccountDao;
import cn.angetech.domain.Account;
import cn.angetech.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dd")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public List<Account> findAll(){
        System.out.println("Service业务层：查询所有账户...");
        return iAccountDao.findAll();
    }

    @Override
    public void saveAccount(Account account){
        System.out.println("Service业务层：保存帐户...");
        iAccountDao.saveAccount(account);
    }
}
