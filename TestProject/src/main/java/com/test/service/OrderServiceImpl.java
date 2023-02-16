package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.dto.Orders;
import com.test.persistence.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepo;


	@Override
	public Page<Orders> getOrderList(int page) {
		
		return orderRepo.findAll(PageRequest.of(page, 10, Sort.Direction.DESC,"seq"));	
	}


	@Override
	public void updateOrder(Orders order) {

		Orders findOrder = orderRepo.findById(order.getSeq()).get();
		findOrder.setBoard(order.getBoard());
		findOrder.setMember(order.getMember());
		findOrder.setResult(order.getResult());
		findOrder.setQuantity(order.getQuantity());
		orderRepo.save(findOrder);
	}


	@Override
	public Orders getOrder(Orders order) {
		
		return orderRepo.findById(order.getSeq()).get();
	}


	@Override
	public void deleteOrder(Orders order) {
	orderRepo.deleteById(order.getSeq());
	}

	
}
