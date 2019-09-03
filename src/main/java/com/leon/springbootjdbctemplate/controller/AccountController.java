package com.leon.springbootjdbctemplate.controller;

import com.leon.springbootjdbctemplate.daomain.Account;
import com.leon.springbootjdbctemplate.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author leon
 * @version V1.0
 * @description: TODO
 * @date 2019/9/3 3:22 下午
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountService accountService;

    // 获取所有用户信息
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts(){
        return accountService.findAccountList();
    }

    // 根据ID获取用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable int id){
        return accountService.findAccountById(id);
    }

    // 根据ID更新用户信息
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name") String name,
                                @RequestParam(value = "money") double money){
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);
        int i = accountService.update(account);
        if (i == 1){
            return account.toString();
        }else {
            return "failed";
        }
    }

    // 新增用户信息
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money){
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        int i = accountService.add(account);
        if (i == 1){
            return account.toString();
        }else {
            return "failed";
        }
    }

    // 根据ID删除用户信息
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAccount(@PathVariable("id") int id){
        int i = accountService.delete(id);
        if (i == 1){
            return "OK";
        }else {
            return "failed";
        }
    }
}
