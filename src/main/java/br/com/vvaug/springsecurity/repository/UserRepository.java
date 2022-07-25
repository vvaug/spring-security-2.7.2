package br.com.vvaug.springsecurity.repository;

import br.com.vvaug.springsecurity.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
}
