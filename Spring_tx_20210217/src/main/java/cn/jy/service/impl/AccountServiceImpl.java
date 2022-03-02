package cn.jy.service.impl;


import cn.jy.dao.AccountDao;
import cn.jy.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String outMan, String inMan, double money) {
        //开启事物
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
        //提交事物
    }
}
