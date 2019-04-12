package com.example.demomongodb.repository;

import com.example.demomongodb.model.Domain;
import com.mongodb.client.result.UpdateResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class DomainRepositoryCustomImpl implements DomainRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int update(String domain, Boolean displayAds) {
        Query query = new Query(Criteria.where("domain").is(domain));
        Update update = new Update();
        update.set("displayAds", displayAds);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Domain.class);

        if (updateResult != null) {
            return new Long(updateResult.getModifiedCount()).intValue();
        } else {
            return 0;
        }
    }

}