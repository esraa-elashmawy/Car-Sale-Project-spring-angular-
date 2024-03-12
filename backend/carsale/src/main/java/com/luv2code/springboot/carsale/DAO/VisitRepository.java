package com.luv2code.springboot.carsale.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.carsale.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

	//@EntityGraph(value = "Visit.buyer_id", type = EntityGraphType.FETCH)
//	List<Visit> findByBuyer_idId(int id);
   List<Visit> findByBuyer_UserId(int BuyerId);


}
