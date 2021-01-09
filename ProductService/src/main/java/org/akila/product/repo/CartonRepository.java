package org.akila.product.repo;

import java.util.List;

import org.akila.product.entity.Carton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartonRepository extends JpaRepository<Carton, Long>{
	
	@Query("select c from Carton c inner join c.product p where p.name = :name")
	List<Carton> findByProductName(String name);

}
