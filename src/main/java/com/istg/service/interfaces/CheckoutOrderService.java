package com.istg.service.interfaces;

import com.istg.domain.CheckoutOrder;
import com.istg.domain.User;

public interface CheckoutOrderService extends BaseService<CheckoutOrder> {
    int save(CheckoutOrder checkoutOrder, User user);
}
