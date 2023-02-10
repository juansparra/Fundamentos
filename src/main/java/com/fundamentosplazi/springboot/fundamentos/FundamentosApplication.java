package com.fundamentosplazi.springboot.fundamentos;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.apache.commons.logging.Log;
import org.apache.juli.logging.LogFactory;
import com.fundamentosplazi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplazi.springboot.fundamentos.entity.User;
import com.fundamentosplazi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplazi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplazi.springboot.fundamentos.service.UserService;
import com.fundamentosplazi.springboot.fundamentosBean.MyBean;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependency;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithDependencyImplement;
import com.fundamentosplazi.springboot.fundamentosBean.MyBeanWithProperties;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final org.apache.juli.logging.Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
	private ComponentDependency componentDependecy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;

	public FundamentosApplication(ComponentDependency componentDependecy, MyBean myBean,
			MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,
			UserRepository userRepository, UserService userService) {
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// TODO Auto-generated method stub
		// ejemplos();
		saveUsersInDataBase();
		getInformationJpaqlFromUser();
		saveWithErrorTransactional();

	}

	private void saveWithErrorTransactional() {
		User test1 = new User("TestTransactional1", "TestTransactional1@email.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@email.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@email.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@email.com", LocalDate.now());
		List<User> users = Arrays.asList(test1, test2, test3, test4);
		try {
		userService.saveTransactional(users);}
		catch(Exception e) {
			LOGGER.error("Esta es una exception dentro del metodo transaccional"+ e);
		}
		userService.getAllUsers().stream().forEach(user -> LOGGER.info("Este es el usuario de transaccional"+users));
	}

	private void getInformationJpaqlFromUser() {
		LOGGER.info("Usuario con el metodo findByemail" + userRepository.findByUserEmail("user2@hotmail.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("user", Sort.by("id").descending()).stream()
				.forEach(user -> LOGGER.info("usuario con metodo sort" + user));
		userRepository.findByName("John").stream().forEach(user -> LOGGER.info("usuario con query method " + user));
		LOGGER.info("Usuario con query method findbyemailandname"
				+ userRepository.findByEmailAndName("john@hotmail.com", "John")
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
		// userRepository.findByNameLike("%user%").stream().forEach(user ->
		// LOGGER.info("USUARIO CON FIND BY NAME LIKE " +user));

		userRepository.findByNameOrEmail("user2", "john@hotmail.com").stream()
				.forEach(user -> LOGGER.info("USUARIO CON findByNameOrEmail " + user));

		// userRepository.findBybirthdateBetween(LocalDate.of(2003,2,22),
		// LocalDate.of(2007,2,22)).stream().forEach(user -> LOGGER.info("USUARIO CON
		// INTERVALO DE FECHAS" +user));
		/*
		 * LOGGER.info("El usuario apartir del named parameter es "+
		 * userRepository.getAllByBirthDateAndEmail(LocalDate.of(2005, 11, 22),
		 * "user4@hotmail.com") .orElseThrow(() -> new
		 * RuntimeException("no se encontro el usuario apartir de named parameter")));
		 */
	}

	private void saveUsersInDataBase() {
		User user1 = new User("John", "john@hotmail.com", LocalDate.of(2021, 03, 02));
		User user2 = new User("user2", "user2@hotmail.com", LocalDate.of(2003, 02, 22));
		User user3 = new User("user3", "user3@hotmail.com", LocalDate.of(2004, 04, 22));
		User user4 = new User("user4", "user4@hotmail.com", LocalDate.of(2005, 11, 22));
		User user5 = new User("user5", "user5@hotmail.com", LocalDate.of(2006, 07, 22));
		User user6 = new User("user6", "user6@hotmail.com", LocalDate.of(2007, 02, 22));
		User user7 = new User("anuser7tony", "user7@hotmail.com", LocalDate.of(2008, 07, 22));
		List<User> lista = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
		lista.stream().forEach(userRepository::save);
	}

	private void ejemplos() {
		componentDependecy.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();

		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword() + "a" + userPojo.getAge());
	}
}
