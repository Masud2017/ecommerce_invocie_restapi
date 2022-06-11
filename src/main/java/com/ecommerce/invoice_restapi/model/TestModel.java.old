package com.ecommerce.invoice_restapi.model;

import java.util.Objects;

public class TestModel {
    private String name;
    private Integer age;


    public TestModel() {
    }

    public TestModel(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public TestModel name(String name) {
        setName(name);
        return this;
    }

    public TestModel age(Integer age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestModel)) {
            return false;
        }
        TestModel testModel = (TestModel) o;
        return Objects.equals(name, testModel.name) && Objects.equals(age, testModel.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }

    
}
