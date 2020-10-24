package com.cg.go.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.*;
import com.cg.go.service.*;
import com.cg.go.service.ICustomerService;
import com.cg.go.service.OrderServiceImpl;
public class Test {
	public static void main(String[] args) throws Exception{
			EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyPU");
			EntityManager entityManager = factory.createEntityManager();
			EntityTransaction et=entityManager.getTransaction();
			IOrderService orderService=new OrderServiceImpl();
			IProductRepository daoProduct=new ProductRepositoryImpl(entityManager);
			LocalDate dispatchDate = LocalDate.of( 2015 , 6 , 7 );
			LocalDate localDate = LocalDate.of( 2017 , 9 , 12 );
			ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
			List<ProductEntity> list=new ArrayList<ProductEntity>();
			list=daoProduct.findAllProducts();
			Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
			for(ProductEntity l:list) {
				products.put(l,l.getQuantity());
			}
			OrderEntity orderEntity1=new OrderEntity("5","70",products,50,10l,localDate,dispatchDate);
			OrderEntity orderEntity2=new OrderEntity("12","80",products,500,102,localDate,dispatchDate);
			OrderEntity orderEntity3=new OrderEntity("15","90",products,100,102,localDate,dispatchDate);
			et.begin();
 			entityManager.persist(productEntity);
 			et.commit();
			orderService.addOrder(orderEntity1);
			orderService.addOrder(orderEntity2);
			orderService.addOrder(orderEntity3);
			orderService.deleteOrderById("12");
			orderService.updateDate("5",dispatchDate,localDate);
			System.out.println("Added Sucessfully");
	}
		 
}