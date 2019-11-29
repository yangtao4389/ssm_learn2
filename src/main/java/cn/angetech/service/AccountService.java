package cn.angetech.service;

import cn.angetech.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);

}
