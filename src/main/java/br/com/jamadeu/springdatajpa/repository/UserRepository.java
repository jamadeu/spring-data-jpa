package br.com.jamadeu.springdatajpa.repository;

import br.com.jamadeu.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Jean Amadeu 08/12/2020
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    List<User> findByEmailEndingWith(String domain);

    @Query("from User where email like concat('%', ?1)")
    List<User> findByDomain(String domain);
}
