package com.okta.developer.spring_boot_postgressql.entities;


import javax.persistence.*;

@Entity
public class Course extends EntityWithUUID {

    private String name;
    private int workload;
    private short rate;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_course_teacher"))
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }
}
