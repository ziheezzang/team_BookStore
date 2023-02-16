package com.test.service;

import org.springframework.data.domain.Page;

import com.test.dto.Orders;

public interface OrderService {
	Page<Orders> getOrderList(int page);
	void updateOrder(Orders order);
	Orders getOrder(Orders order);
	void deleteOrder(Orders order);
}
