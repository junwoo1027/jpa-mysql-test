package com.mysqltest.mysqltest;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Account {

    @Id
    private String userId;

    private String password;
}
