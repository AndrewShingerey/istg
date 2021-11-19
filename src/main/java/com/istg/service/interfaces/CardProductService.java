package com.istg.service.interfaces;

import com.istg.domain.Card;
import com.istg.domain.CardProduct;
import com.istg.domain.User;

import java.util.List;

public interface CardProductService extends BaseService<CardProduct> {

    List<CardProduct> find_all_by_id_user(Long id_user);
    int save(CardProduct cardProduct, User user);
    int delete(CardProduct cardProduct,User user);
    int create_card(User user);
    boolean checkExists(Long id);
}
