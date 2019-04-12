package com.example.demomongodb.repository;

import java.util.List;

import com.example.demomongodb.model.Domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * DomainRepository
 */
public interface DomainRepository extends MongoRepository<Domain, Long>, DomainRepositoryCustom {

    public Domain findFirstByDomain(String domain);

    public Domain findFirstByDomainAndDisplayAds(String domain, Boolean displayAds);

    @Query("{domain: '?0'}")
    public List<Domain> findByDomain(String domain);

    @Query("{domain : {$regex: ?0} }")
    public List<Domain> findByRegexDomain(String maRegex);

}