package com.evol.dao;

import com.evol.domain.model.Transaction;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Transaction getTransById(int id){
        Query query = new Query(Criteria.where("Id").is(id));
        Transaction trans = mongoTemplate.findOne(query, Transaction.class);
        return trans;
    }

    public Transaction getTransByOrderNo(String orderNo){
        Query query = new Query(Criteria.where("OrderNo").is(orderNo));
        Transaction trans = mongoTemplate.findOne(query, Transaction.class);
        return trans;
    }

    public boolean deleteTransById(String id){
        Query query = new Query(Criteria.where("Id").is(id));
        DeleteResult result = mongoTemplate.remove(query, Transaction.class);
        return result.getDeletedCount() >= 1;
    }

    public boolean updateTransStatusById(int id, int state){
        Query query = new Query(Criteria.where("Id").is(id));
        Update update = (new Update()).set("State", state);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Transaction.class);
        return  result.getModifiedCount() == 1;
    }

    public Transaction addTrans(Transaction trans){
        Transaction tran1 = mongoTemplate.save(trans);
        return tran1;
    }
}
