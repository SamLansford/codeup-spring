package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs",
    uniqueConstraints = @UniqueConstraint(name = "UK_name_AND_reside_state", columnNames = {"name", "residestate"})
)
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int id;

    @Column(columnDefinition = "TINYINT(3) UNSIGNED", nullable = false)
    private int age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, columnDefinition = "char(2) DEFAULT 'xx'")
    private String resideState;

    public Dog() {

    }

    public Dog(int id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }

}
