package com.example.demomongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Domain {

    @Id
    private String id;
    @Indexed
    private String domain;
    Boolean displayAds;

    public Domain() {
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", domain='" + getDomain() + "'" + ", displayAds='" + isDisplayAds()
                + "'" + "}";
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean isDisplayAds() {
        return this.displayAds;
    }

    public Boolean getDisplayAds() {
        return this.displayAds;
    }

    public void setDisplayAds(Boolean displayAds) {
        this.displayAds = displayAds;
    }

}