package com.fundamentosplazi.springboot.fundamentos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fundamentosplazi.springboot.fundamentos.dto.UserDto;
import com.fundamentosplazi.springboot.fundamentos.entity.User;

@EnableJpaRepositories
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> ,CrudRepository<User, Long> {
	@Query("Select u from User u where u.email=?1")
	Optional<User> findByUserEmail(String email);
	@Query("Select u from User u where u.name like ?1%")
	List<User> findAndSort(String name, Sort sort);
	
	List <User> findByName(String name);
	Optional<User>findByEmailAndName(String email, String name);
	List<User> findByNameLike(String name);
	
	List<User> findByNameOrEmail(String name, String email);
	//List<User> findBybirthdateBetween(LocalDate begin, LocalDate end);
	List<User> findByNameLikeOrderByIdDesc(String name);
/*	@Query("SELECT new com.fundamentosplazi.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthDate)" 
	+ "FROM User u" 
	+"where u.birthDate =:parametroFecha " 
	+"and u.mail=:parametroEmail")
	Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate date, 
			@Param("parametroEmail") String email);*/
	
	List<User> findAll();
}

