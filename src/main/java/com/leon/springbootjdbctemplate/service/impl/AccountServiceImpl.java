package com.leon.springbootjdbctemplate.service.impl;

import com.leon.springbootjdbctemplate.dao.IAccountDao;
import com.leon.springbootjdbctemplate.daomain.Account;
import com.leon.springbootjdbctemplate.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leon
 * @version V1.0
 * @description: TODO
 * @date 2019/9/3 3:14 下午
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountDao accountDao;

    @Override
    public int add(Account account) {
        return accountDao.add(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public int delete(int id) {
        return accountDao.delete(id);
    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAccountList() {
        return accountDao.findAccountList();
    }
}
