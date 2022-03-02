package cn.jy.mapper;

import cn.jy.domain.Account;

import java.util.List;
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();

}
