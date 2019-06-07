package br.com.curso.endpoint;

import br.com.curso.Util.DateUtil;
import br.com.curso.error.CustonErrorType;
import br.com.curso.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

    @Autowired
    private DateUtil dateUtil;

    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(Student.studentsList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index = Student.studentsList.indexOf(student);
        if(index ==-1)
             return  new ResponseEntity<>(new CustonErrorType("Student not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Student.studentsList.get(index),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.studentsList.add(student);
        return new ResponseEntity<>(student,HttpStatus.OK);

    }

}
