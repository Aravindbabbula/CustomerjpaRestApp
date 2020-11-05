package com.cg.go.greatoutdoor.order.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.go.greatoutdoor.order.dao.IOrderRepository;
import com.cg.go.greatoutdoor.order.service.OrderServiceImpl;
import com.cg.go.greatoutdoor.order.entity.OrderEntity;

@Transactional
@Service

public class OrderServiceImpl implements IOrderService {
	private static final Logger Log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	 @Autowired
	    IOrderRepository daoOrder;
	 @Override
	public List<OrderEntity>findOrdersByUserId(String userId){
        List<OrderEntity> list= daoOrder.findOrdersByUserId(userId);
		return list;
	}
	@Override
	public List<OrderEntity> findAllOrders(){
        List<OrderEntity> list= daoOrder.findAllOrders();
		return list;
	}
	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) {
		
		OrderEntity Order=daoOrder.save(orderEntity);
		return Order;
	}
	@Override
	public void deleteAllOrders() {
		
        daoOrder.deleteAllOrders();
        
	}
	@Override
	public void deleteOrderById(String orderId){
		//Optional<OrderEntity> optional=daoOrder.findById(orderId);
        daoOrder.deleteOrderById(orderId);
        
	}
	@Override
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) {
		
        daoOrder.updateDate(orderId, dispatchDate, arrivalDate);
       
	}

}
