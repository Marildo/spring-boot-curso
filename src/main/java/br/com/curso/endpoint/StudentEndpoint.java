package br.com.curso.endpoint;

import br.com.curso.error.CustonErrorType;
import br.com.curso.model.Student;
import br.com.curso.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final StudentRepository dao;

    @Autowired
    public StudentEndpoint(StudentRepository dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") Long id) {
        Optional<Student> opt = dao.findById(id);

        if (opt.isPresent())
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        return new ResponseEntity<>(new CustonErrorType("Student not found"), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        return new ResponseEntity<>(dao.save(student), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        return new ResponseEntity<>(dao.save(student), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
         dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
