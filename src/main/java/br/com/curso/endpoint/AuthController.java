package br.com.curso.endpoint;

import static org.springframework.http.ResponseEntity.ok;
import br.com.curso.model.User;
import br.com.curso.repository.UserRepository;
import br.com.curso.security.AccountCredentialsVO;
import br.com.curso.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("auth/")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/signin", produces = "application/json")
    public ResponseEntity<String> init() {
        System.out.println("teste de get");
        return new ResponseEntity<String>("{\"Message\": \"Serviço em operacao\"}",HttpStatus.OK);
    }


    @PostMapping(value = "/signin", produces = "application/json")
    public ResponseEntity<String> posy() {
        System.out.println("teste de post");
        return new ResponseEntity<String>("{\"Message\": \"Serviço em operacao\"}",HttpStatus.OK);
    }

    /*
    @PostMapping(value = "/signin", produces = {"application/json"},
            consumes = { "application/json"})
     public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = userRepository.findByUsername(username);

            String token = "";

            if (user != null) {
                token = tokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return  ok(model);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

     */
}
