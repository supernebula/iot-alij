package com.evol.controller;

import com.evol.dao.TransactionRepository;
import com.evol.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private TransactionRepository transRepository;

    @GetMapping(value = "/add/{id}")
    public Transaction add(@PathVariable("id") Integer id){
        Transaction trans = new Transaction();
        trans.setId(id != null ? id.intValue() : 0);
        String currentDateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        trans.setOrderNo(currentDateStr + ((new Random().nextInt(999999 - 900000) + 900000)));
        trans.setUserName("username1");
        trans.setUserId(1);
        trans.setWays(1);
        trans.setDeviceId(2);
        trans.setDeviceNumber("111111");
        trans.setDeviceWay(1);
        trans.setAgentId(0);
        trans.setAgentName("test0");
        trans.setAreaAgentId(0);
        trans.setAreaAgentName("testa0");
        trans.setMerchantId(0);
        trans.setMerchantName("merch1");
        trans.setProvince("浙江");
        trans.setCity("杭州");
        trans.setCountry("西湖");
        trans.setState(0);
        trans.setPrepayMoney(new BigDecimal(100));
        transRepository.addTrans(trans);
        return trans;
    }

    @GetMapping(value = "/get/{id}")
    public Transaction get(@PathVariable("id") int id){
        Transaction trans = transRepository.getTransById(id);
        return trans;
    }

    @GetMapping(value = "/update/{id}")
    public boolean update(@PathVariable("id") int id){
        boolean success = transRepository.updateTransStatusById(id, 8);
        return success;
    }

    @GetMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") int id){
        boolean success = transRepository.updateTransStatusById(id, 8);
        return success;
    }
}
