package com.gps.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.gps.model.Order;
import com.gps.services.OrderService;
@Controller
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    	//Get
	@RequestMapping(value="/orders",method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Order>> getCategorias(@RequestParam(value ="orderid", required = false) String descripcion){
		List<Order> orders = new ArrayList<Order>();
		if(descripcion == null) {
			orders = orderService.findAllOrder();
			if(orders.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
			}
		}
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
	}
    @RequestMapping(value="/orders",method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCategoria(@RequestBody Order order, UriComponentsBuilder uriComponentsBuilder){
		orderService.saveOrder(order);
		return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
    @RequestMapping(value="/orders/cotiza",method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Double> getcotization(@RequestBody Order order, UriComponentsBuilder uriComponentsBuilder){
		Double cotization=0.0;
        cotization=orderService.getCotization(order);
		return new ResponseEntity<Double>(cotization,HttpStatus.CREATED);
	}
}
