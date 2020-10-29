package com.mysqltest.mysqltest;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    private String id;

    private String name;
}
