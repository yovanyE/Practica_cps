package com.gps.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.dao.OrderDao;
import com.gps.model.Order;
@Service("orderService")
@Transactional
public class OrderServiceImplement implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Override
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
        
    }

    @Override
    public List<Order> findAllOrder() {
        // TODO Auto-generated method stub
        return orderDao.findAllOrder();
    }

    @Override
    public Double getCotization(Order order) {
        // TODO Auto-generated method stub
        return orderDao.getCotization(order);
    }
    
}
