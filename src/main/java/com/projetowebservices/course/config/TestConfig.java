package com.projetowebservices.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservices.course.entities.Category;
import com.projetowebservices.course.entities.Order;
import com.projetowebservices.course.entities.User;
import com.projetowebservices.course.entities.enums.OrderStatus;
import com.projetowebservices.course.repositories.CategoryRepository;
import com.projetowebservices.course.repositories.OrderRepository;
import com.projetowebservices.course.repositories.UserRepository;

@Configuration
@Profile("test") //igual ao spring.profiles.active= no application.properties
public class TestConfig implements CommandLineRunner{

	@Autowired //injeção de dependência: associar uma instancia do userRespository no TestConfig. resolve a dependência e instancia um userRep
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {//tudo que está aqui vai acontecer ao executar a aplicação
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");//ID será colocado no BD
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); //String no ISO8601. letra Z = horário UTC
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1); //vários objetos (o1 e o3) para o mesmo usuário (u1)
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

	}
	
}
