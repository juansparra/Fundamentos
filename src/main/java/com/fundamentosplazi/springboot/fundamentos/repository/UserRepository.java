package com.fundamentosplazi.springboot.fundamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.fundamentosplazi.springboot.fundamentos.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User, Long> 	{
	@Query("Select u from User u where u.email=?1")
	Optional<User> findByUserEmail(String email);
	@Query("Select u from User u where u.name like ?1%")
	List<User> findAndSort(String name, Sort sort);
}
