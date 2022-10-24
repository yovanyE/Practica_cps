package com.gps.dao;

import java.util.List;

import com.gps.model.Order;

public interface OrderDao {
    //metodo para envio de producto
    void saveOrder(Order order);

    List<Order> findAllOrder();
    //Descuento cliente manejar desde base de datos
    Double getCotization(Order order);

}
