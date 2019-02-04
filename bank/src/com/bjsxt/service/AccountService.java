package com.bjsxt.service;

import com.bjsxt.pojo.Account;

import java.io.IOException;

public interface AccountService {
    /**
     * 账号密码不匹配
     */
    int ACCOUNT_PASSWORD_NOT_MATH=1;
    /**
     * 余额不足
     */
    int BALANCE_NOT_ENOUGH=2;

    /**
     * 存入账户不存在
     */
    int ACCOUNT_NOT_EXISTENT=3;
    /**
     * 转账成功
     */
    int SUCCESS = 4;
    /**
     * 转账失败
     */
    int FAIL = 5;
    int transfer(Account accIn,Account accOut) throws IOException;
}
