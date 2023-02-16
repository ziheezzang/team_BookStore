package com.test.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.test.dto.Orders;
public interface OrderRepository extends JpaRepository<Orders, Long> {
	@Query(value="SELECT o FROM orders o", nativeQuery=true)
	Page<Orders> getOrderList(Pageable page);

}
