package rikkei.academy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Oder implements Serializable {
    private int id;
    private User user;

    private List<CartItem> cartItemList;

    private Double totalPrice;

    private Date payDate;

    @Override
    public String toString() {
        return "Oder{" +
                "id=" + id +
                ", user=" + user +
                ", cartItemList=" + cartItemList +
                ", totalPrice=" + totalPrice +
                ", payDate=" + payDate +
                '}';
    }

    public Oder(int id, User user, List<CartItem> cartItemList, Double totalPrice, Date payDate) {
        this.id = id;
        this.user = user;
        this.cartItemList = cartItemList;
        this.totalPrice = totalPrice;
        this.payDate = payDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Oder() {
    }
}
