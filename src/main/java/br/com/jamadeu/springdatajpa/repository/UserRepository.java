package br.com.jamadeu.springdatajpa.repository;

import br.com.jamadeu.springdatajpa.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jean Amadeu 08/12/2020
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);

    List<User> findByEmailEndingWith(String domain);

    @Query("from User where email like %domain")
    List<User> findByDomain(String domain);
}
