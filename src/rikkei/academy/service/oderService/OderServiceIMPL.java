package rikkei.academy.service.oderService;

import rikkei.academy.config.Config;
import rikkei.academy.model.CartItem;
import rikkei.academy.model.Oder;
import rikkei.academy.model.Product;
import rikkei.academy.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OderServiceIMPL implements IOderService{
    List<Oder> oderList = new ArrayList<>();

    //@todo code thêm phần logic ở đây.
    @Override
    public List<Oder> findAll() {
        return null;
    }

    @Override
    public void save(Oder oder) {

    }

    @Override
    public Oder findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Oder create(User userPrinciple) {
        Oder oder = new Oder(userPrinciple.getId(),userPrinciple, userPrinciple.getCart(), totalPrice(userPrinciple.getCart()), new Date());
        userPrinciple.setCart(new ArrayList<>());
        //@todo code phần cập nhật user và list user trong data  đây.
        for (Oder oderss: oderList) {
            if (oderss == null) {
                oderList.add(oderss);
            }else {
//              oderList.set()
            }
        }
        //@todo ghi ra file cái oder này
//        new Config<Oder>().writeToFile(Config.PATH_ODER,);
        return oder;
    }

    @Override
    public Double totalPrice(List<CartItem> cartItems) {
        Double totalPrice = 0.0;
        for (CartItem c: cartItems) {
            totalPrice += (c.getQuantity() * c.getProduct().getPrice());
        }
        return totalPrice;
    }
}
