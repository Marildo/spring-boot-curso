package br.com.curso.repository;

import br.com.curso.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
}
