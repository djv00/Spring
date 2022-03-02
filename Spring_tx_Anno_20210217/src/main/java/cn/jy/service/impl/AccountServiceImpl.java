package cn.jy.service.impl;


import cn.jy.dao.AccountDao;
import cn.jy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")

@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        //开启事物
        accountDao.out(outMan,money);
        //int i = 1/0;
        accountDao.in(inMan,money);
        //提交事物
    }

    //@Transactional(isolation = Isolation.DEFAULT)
    public void xxx(){

    }
}
