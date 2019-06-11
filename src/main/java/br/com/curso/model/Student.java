package br.com.curso.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
