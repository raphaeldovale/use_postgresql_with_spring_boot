package com.okta.developer.spring_boot_postgressql.entities;

import javax.persistence.Entity;

@Entity
public class Teacher extends EntityWithUUID {

    private String name;
    private String pictureURL;
    private String email;

}
