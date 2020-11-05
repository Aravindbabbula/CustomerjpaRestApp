package com.cg.go.greatoutdoor.order.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.go.greatoutdoor.order.entity.OrderEntity;
public interface IOrderService {

	public List<OrderEntity> findOrdersByUserId(String userId);

	public List<OrderEntity> findAllOrders();

	public OrderEntity addOrder(OrderEntity orderEntity);

	public void deleteAllOrders() ;

	public void deleteOrderById(String orderId);

	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate);

}
