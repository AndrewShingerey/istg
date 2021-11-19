package com.istg.service.implementations;

import com.istg.dao.Interface.CardProductDao;
import com.istg.dao.implementations.CardProductDaoImpl;
import com.istg.domain.Card;
import com.istg.domain.CardProduct;
import com.istg.domain.User;
import com.istg.service.interfaces.CardProductService;
import com.istg.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class CardProductServiceImpl implements CardProductService {

    @Autowired
    private CardProductDao cardProductDao;

    @Autowired
    private UserService userService;
    private static final Logger log = Logger.getLogger(String.valueOf(CardProductServiceImpl.class));

    @Override
    public List<CardProduct> find_all_by_id_user(Long id_user) {
        if(id_user !=-1 || id_user!=null){
            return cardProductDao.find_all_by_id_user(id_user);
        }else{
            return null;
        }

    }

    @Override
    public int save(CardProduct cardProduct, User user) {
        if(user!=null) {
            cardProduct.setDate_add(new Date(new java.util.Date().getTime()));
            return cardProductDao.save(cardProduct, user);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(CardProduct cardProduct, User user) {
        if(cardProduct!=null){
            return cardProductDao.delete(cardProduct,user);
        }else{
            return 0;
        }
    }

    @Override
    public int create_card(User user) {
        if(user!=null) {
            return cardProductDao.create_card(user);
        }else{
            return 0;
        }
    }

    @Override
    public boolean checkExists(Long id) {
        if(id!=null) {
            return cardProductDao.checkExists(id);
        }else{
            return false;
        }
    }


    @Override
    public int save(CardProduct cardProduct) {
        if(cardProduct.getId_game()!=-1 && cardProduct.getId_card()!=-1){
            return cardProductDao.save(cardProduct);
        }else {
            return 0;
        }
    }

    @Override
    public List<CardProduct> getAll() {
        return cardProductDao.getAll();
    }

    @Override
    public int update(CardProduct cardProduct) {
        if(cardProduct!=null) {
            return cardProductDao.update(cardProduct);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(CardProduct cardProduct) {
        if(cardProduct!=null) {
            return cardProductDao.delete(cardProduct);
        }else{
            return 0;
        }
    }

    @Override
    public CardProduct getById(Long id) {
        if(id != null) {
            return cardProductDao.getById(id);
        }else{
            return null;
        }
    }
}
