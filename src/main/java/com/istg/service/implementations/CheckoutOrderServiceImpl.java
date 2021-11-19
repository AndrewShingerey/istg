package com.istg.service.implementations;

import com.istg.dao.Interface.CardProductDao;
import com.istg.dao.Interface.CheckoutOrderDao;
import com.istg.domain.CheckoutOrder;
import com.istg.domain.User;
import com.istg.service.interfaces.CheckoutOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class CheckoutOrderServiceImpl implements CheckoutOrderService {

    @Autowired
    private CheckoutOrderDao checkoutOrderDao;

    private static final Logger log = Logger.getLogger(String.valueOf(CheckoutOrderService.class));

    @Override
    public int save(CheckoutOrder checkoutOrder) {
        if(!checkoutOrder.getName_client().equals("")&&!checkoutOrder.getPhone_client().equals("")) {
            log.info("Save new order" + " " + new Date(new java.util.Date().getTime()));
            checkoutOrder.setDate_order(new Date(new java.util.Date().getTime()));
            return checkoutOrderDao.save(checkoutOrder);
        }else{
            log.info("Not save order");
            return 0;
        }
    }

    @Override
    public List<CheckoutOrder> getAll() {
        log.info("Get all order" + " " + new Date(new java.util.Date().getTime()));
        return checkoutOrderDao.getAll();
    }

    @Override
    public int update(CheckoutOrder checkoutOrder) {
        if(checkoutOrder.getId_c_or()!=null) {
            log.info("Update order info" + " " + new Date(new java.util.Date().getTime()));
            return checkoutOrderDao.update(checkoutOrder);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(CheckoutOrder checkoutOrder) {
        if(checkoutOrder.getId_c_or()!=null) {
            log.info("Delete order by id - " + checkoutOrder.getId_c_or() + " " + new Date(new java.util.Date().getTime()));
            return checkoutOrderDao.delete(checkoutOrder);
        }else{
            return 0;
        }
    }

    @Override
    public CheckoutOrder getById(Long id) {
        if(id!=null) {
            log.info("Get one order by id - " + id + " " + new Date(new java.util.Date().getTime()));
            return checkoutOrderDao.getById(id);
        }else{
            return null;
        }
    }

    @Override
    public int save(CheckoutOrder checkoutOrder, User user) {
        if(user!=null) {
            checkoutOrder.setDate_order(new Date(new java.util.Date().getTime()));
            return checkoutOrderDao.save(checkoutOrder, user);
        }else{
            return 0;
        }
    }
}
