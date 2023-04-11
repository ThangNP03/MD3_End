package rikkei.academy.service.oderService;

import rikkei.academy.model.CartItem;
import rikkei.academy.model.Oder;
import rikkei.academy.model.Product;
import rikkei.academy.model.User;
import rikkei.academy.service.IGenericService;

import java.util.List;

public interface IOderService extends IGenericService<Oder> {
    Oder create(User userPrinciple);
    Double totalPrice(List<CartItem> cartItems);
}
