
package com.example.ProductDemo;

		import com.example.ProductDemo.entity.Product;
		import jakarta.annotation.PostConstruct;
		import org.hibernate.Session;
		import org.hibernate.SessionFactory;
		import org.hibernate.cfg.Configuration;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductDemoApplication {

	private final SessionFactory sessionFactory;

	public ProductDemoApplication() {
		// Configuration for Hibernate, not needed if using Spring's configuration
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		// Use the session to interact with the database
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Product(1l,"Sample Product", 10.99));
		session.getTransaction().commit();
		session.close();
	}
}
