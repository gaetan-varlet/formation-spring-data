package com.example.demoldap.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.DnAttribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.odm.annotations.Transient;
import org.springframework.ldap.support.LdapNameBuilder;

@Entry(objectClasses = { "person", "top" })
public class Person {

    private static final String BASE_DN = "dc-data, dc=com";

    @Id
    private Name dn;
    @DnAttribute("uid")
    private String uid;
    @Attribute(name = "cn")
    private String fullName;
    @Attribute(name = "sn")
    private String lastName;
    @DnAttribute("ou")
    @Transient
    private String group;

    public Person() {
    }

    public Person(String fullName, String lastName) {
        this.dn = LdapNameBuilder.newInstance(BASE_DN).add("ou", "people").add("uid", fullName).build();
        this.fullName = fullName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" + " dn='" + getDn() + "'" + ", uid='" + getUid() + "'" + ", fullName='" + getFullName() + "'"
                + ", lastName='" + getLastName() + "'" + ", group='" + getGroup() + "'" + "}";
    }

    public Name getDn() {
        return this.dn;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}