package br.com.curso.repository;

import br.com.curso.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
}
