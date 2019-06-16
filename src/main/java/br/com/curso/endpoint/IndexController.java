package br.com.curso.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping()
    public ResponseEntity index(){
        return new ResponseEntity("{\"Message\":\"Api rodandodando\"}", HttpStatus.OK);
    }
}
