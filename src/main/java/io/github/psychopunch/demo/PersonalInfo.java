package io.github.psychopunch.demo;

public class PersonalInfo {

    private final String name;
    private final Integer age;

    public PersonalInfo() {
        name = "";
        age = -1;
    }

    public PersonalInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
