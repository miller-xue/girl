package com.x.girl.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by miller on 2018/5/1
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl() {
    }

    public Girl(String cupSize, Integer age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, String cupSize, Integer age) {
        this.id = id;
        this.cupSize = cupSize;
        this.age = age;
    }



    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
