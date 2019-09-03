package com.leon.springbootjdbctemplate.dao;

import com.leon.springbootjdbctemplate.daomain.Account;

import java.util.List;

/**
 * @author leon
 * @version V1.0
 * @description: TODO
 * @date 2019/9/3 2:51 下午
 */
public interface IAccountDao {
    int add(Account account);

    int update(Account account);

    int delete(int id);

    Account findAccountById(int id);

    List<Account> findAccountList();
}
