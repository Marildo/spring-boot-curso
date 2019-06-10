package br.com.curso.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;


@Entity
public class Student extends AbstractEntity{

    @NotEmpty
    private String name;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
