package com.istg.dao.Interface;

import com.istg.domain.CheckoutOrder;
import com.istg.domain.User;

public interface CheckoutOrderDao extends BaseDaoCRUD<CheckoutOrder> {
    int save(CheckoutOrder checkoutOrder, User user);
}
