package com.bjsxt.service.impl;

import com.bjsxt.pojo.Account;
import com.bjsxt.pojo.Log;
import com.bjsxt.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class AccountServiceImpl implements AccountService {
    @Override
    public int transfer(Account accIn, Account accOut) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        Account accOutSelect = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoPwd", accOut);

        if(accOutSelect!=null){
            if(accOutSelect.getBalance()>=accOut.getBalance()){
                Account accIntSelect = session.selectOne("com.bjsxt.mapper.AccountMapper.selByAccnoName",accIn);
                if(accIntSelect!=null){
                    accOut.setBalance(-accOut.getBalance());
                    int index = session.insert("com.bjsxt.mapper.AccountMapper.updBalanceByAccno",accOut);
                    index += session.insert("com.bjsxt.mapper.AccountMapper.updBalanceByAccno",accIn);
                    if (index==2){
                        Log log = new Log();
                        log.setAccout(accOut.getAccno());
                        log.setAccin(accIn.getAccno());
                        log.setMoney(accIn.getBalance());
                        Date date = new Date();
                        log.setDate(date);
                        Logger logger = Logger.getLogger(AccountServiceImpl.class);
                        logger.info(log.getAccout()+"给"+log.getAccin()+"在"+ date.toLocaleString()+"转了"+log.getMoney());
                        session.insert("com.bjsxt.mapper.LogMapper.insLog",log);
                        session.commit();
                        session.close();
                        return SUCCESS;
                    }else {
                        session.rollback();
                        session.close();
                        return FAIL;
                    }

                }else {
                    return ACCOUNT_NOT_EXISTENT;
                }
            }else {
                return BALANCE_NOT_ENOUGH;
            }

        }else {
            return ACCOUNT_PASSWORD_NOT_MATH;
        }
    }
}
