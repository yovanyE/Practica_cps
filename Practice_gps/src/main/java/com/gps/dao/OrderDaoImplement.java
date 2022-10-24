package com.gps.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.transaction.Transactional;

import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Repository;

import com.gps.model.Order;
@Repository
@Transactional
public class OrderDaoImplement extends AbstractSession implements OrderDao{

    @Override
    public void saveOrder(Order order) {
        // TODO Auto-generated method stub
        getSession().save(order);
    }

    @Override
    public List<Order> findAllOrder() {
        // TODO Auto-generated method stub
        return getSession().createQuery("from Order").list();
    }

    @Override
    public Double getCotization(Order order) {
       // ProcedureCall procedureCall=getSession().createStoredProcedureCall("spc_cotiza",Order.class);
        /*procedureCall.registerParameter("peso",Double.class, ParameterMode.IN).bindValue(order.getWeight());
        procedureCall.registerParameter("tarifa",Double.class, ParameterMode.IN).bindValue(order.getRate());
        procedureCall.registerParameter("alto",Double.class, ParameterMode.IN).bindValue(order.getTall());
        procedureCall.registerParameter("largo",Double.class, ParameterMode.IN).bindValue(order.getLongg());
        procedureCall.registerParameter("ancho",Double.class, ParameterMode.IN).bindValue(order.getWidth());
        */
       /* procedureCall.registerStoredProcedureParameter("peso", Double.class, ParameterMode.IN);
        procedureCall.setParameter("peso",order.getWeight());
        procedureCall.registerStoredProcedureParameter("tarifa", Double.class, ParameterMode.IN);
        procedureCall.setParameter("tarifa",order.getRate());
        procedureCall.registerStoredProcedureParameter("alto", Double.class, ParameterMode.IN);
        procedureCall.setParameter("alto",order.getTall());
        procedureCall.registerStoredProcedureParameter("largo", Double.class, ParameterMode.IN);
        procedureCall.setParameter("largo",order.getLongg());
        procedureCall.registerStoredProcedureParameter("ancho", Double.class, ParameterMode.IN);
        procedureCall.setParameter("ancho",order.getWidth());*/
        Double estimate=0.0;
        double dicountClient=1.12;
        estimate=(order.getWeight()*order.getRate())+(1.66*order.getTall()*order.getLongg()*order.getWidth())-(dicountClient*0.5*order.getWeight());
        /*if(procedureCall.execute()){
            System.out.println("registrado");
            prueba=(Double)procedureCall.getSingleResult();
        }else{
            prueba=0.0;
        }*/
        return estimate;
    }
    
}
