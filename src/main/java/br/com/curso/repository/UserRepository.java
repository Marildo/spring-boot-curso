package br.com.curso.repository;


import br.com.curso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(@Param("userName")String userName );

}
