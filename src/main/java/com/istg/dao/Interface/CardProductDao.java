package com.istg.dao.Interface;

import com.istg.domain.Card;
import com.istg.domain.CardProduct;
import com.istg.domain.User;

import java.util.*;

public interface CardProductDao extends BaseDaoCRUD<CardProduct>{
    List<CardProduct>find_all_by_id_user(Long id_user);
    int save(CardProduct cardProduct, User user);
    int delete(CardProduct cardProduct,User user);
    int create_card(User user);
    boolean checkExists(Long id);
}
