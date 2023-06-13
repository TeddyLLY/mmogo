package com.smart.mmogo.bean;


import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/*
 * Document 表示為這是個 MongoDB Object
 */
@Document
public class Employee {
    @Id
    private long id ;
    @BsonProperty(value = "first_name")
    private String firstName;
    @BsonProperty(value = "last_name")
    private String lastName;
    @Indexed
    private String job;
    private BigDecimal salary;
    private Boolean internship ;
    @BsonProperty(value = "regular_date")
    private Date regularDate ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getInternship() {
        return internship;
    }

    public void setInternship(Boolean internship) {
        this.internship = internship;
    }

    public Date getRegularDate() {
        return regularDate;
    }

    public void setRegularDate(Date regularDate) {
        this.regularDate = regularDate;
    }
}
