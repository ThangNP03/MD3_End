package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.controller.UserController;
import rikkei.academy.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static rikkei.academy.config.Config.scanner;

public class UserViews {

    ProductController productController = new ProductController();
    UserController userController = new UserController();
    List<User> listUser = userController.findAll();

    public User formLogin() {
        System.out.println("******************* LOGIN *******************");
        System.out.println("Enter your username: ");
        String username = scanner().nextLine();
        System.out.println("Enter password: ");
        String password = scanner().nextLine();
        User user = userController.login(username, password);
        if (user == null) {
            System.err.println("Icorrect usernam or password not found");
            System.out.println("******************* LOGIN *******************");
            System.out.println("1. Try again");
            System.out.println("2. You forgot password ");
            System.out.println("3. You don't account register now");
            System.out.println("----------------------------------------------");
            System.out.println("Enter your selection");
            int choice = scanner().nextInt();
            if (choice == 2) {
                ///quên mật khẩu
                formLogin();
            } else if (choice == 3) {
                formRegister();
                //Đăg ký
            } else {
                formLogin();
                ///đăng nhập lạinh
            }
        }
        return user;


    }

    public void formRegister() {
        System.out.println("******************* REGISTER *******************");
        User user = new User();
        if (listUser.size() == 0) {
            user.setId(1);
        } else {
            user.setId(listUser.get(listUser.size() - 1).getId() + 1);
        }
        System.out.println("Enter your username: ");
        while (true) {
            user.setUsername(scanner().nextLine());
            if (userController.checkUserNameExit(user.getUsername())) {
                //tồn tại
                System.err.println("username is exit!!");
            } else if (!Validate.checkUserName(user.getUsername())){
                System.err.println("username 6 char!!");
            }
            else {
                break;
            }
        }
        System.out.println("Enter password: ");
        user.setPassword(scanner().nextLine());
        System.out.println("Enter fullName: ");
        user.setFullName(scanner().nextLine());
        userController.create(user);
        System.out.println("CREATE SUCCESS!!!");
    }

    public void showListUser() {
        for (User u : listUser) {
            System.out.println(u);
        }
    }

    public void changeUserStatus() {
        System.out.println("Enter id change");
        int id = scanner().nextInt();
        User user = userController.findById(id);
        if (user == null) {
            System.err.println("id not found");
        } else {
            if (user.getRole() == RoleName.CUSTOMER) {
                userController.changeStatus(id);
                System.out.println("Change stats=us cuccess!!");
            } else {
                System.out.println("you can not change status admin");
            }
        }


    }
    //update password
    public void
    formUpdateUser(User user){
      while (true) {
          System.out.print("Enter old password: ");
          String oldPassword = scanner.nextLine();
          //Kiểm tra mật khẩu cũ
          if(!user.getPassword().equals(oldPassword)){
              System.err.print("Password does not match please re-enter!!!!");
             continue;
          }
          System.out.print("Enter new password: ");
          String newPassWord = scanner.nextLine();
          for (User u: listUser) {
              if (u.getId() == user.getId()){
                  u.setPassword(newPassWord);
                  userController.update(u);
                  break;
              }
          }
          System.out.println("Update password success!!!");
          break;
      }

    }
    //end update password
    public void showListCart(User user) {
        float total = 0 ;

        for (CartItem cart : user.getCart()) {

            System.out.println(cart);
            total+= cart.getProduct().getPrice()*cart.getQuantity();
            System.out.printf("{product: %s , quantity : %d} \n",cart.getProduct(),cart.getQuantity());
        }
        System.out.println("Total amount: "+total + " vnd");
    }

    public void addToCart(User user) {
        new ProductView().showListProduct();
        List<CartItem> cart = user.getCart();
        System.out.println("Enter product id");
        int id = scanner().nextInt();
        if (productController.searchProductById(id) == null) {
            System.err.println("id not found ");
        } else {
            Product product = productController.searchProductById(id);
            System.out.println("enter quantity: ");
            int quantity = scanner().nextInt();
            int idNew = (cart.size() == 0) ? 1 : (cart.get(cart.size() - 1).getId() + 1);
            CartItem cartItemNew = new CartItem(idNew, product, quantity);
            if (cart.size() == 0) {
                //ior hàng trống
                cart.add(cartItemNew);
            } else {
                //sản phẩm trùng
                if (checkCartItemExits(cart, id)) {
                    for (CartItem item : cart) {
                        if (item.getProduct().getProductId() == id) {
                            item.setQuantity(item.getQuantity() + quantity);
                            break;
                        }
                    }
                } else {
                    //sản phẩm không trùng
                    cart.add(cartItemNew);
                }
            }
            System.out.println("Add to cart success!!!");
            user.setCart(cart);
            userController.update(user);
        }
    }

    public boolean checkCartItemExits(List<CartItem> cart, int id) {
        for (CartItem item : cart
        ) {
            if (item.getProduct().getProductId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeQuantytiItem(User user) {
        List<CartItem> cart = user.getCart();
        System.out.println("Enter id cart item change: ");
        int idCartItem = scanner().nextInt();
        if (checkCartItemExit(cart, idCartItem)) {
            for (CartItem item : cart) {
                if (item.getId() == idCartItem) {
                    System.out.println("Enter new quantity ,old quantity " + item.getQuantity());
                    item.setQuantity(scanner().nextInt());
                    user.setCart(cart);
                    userController.update(user);
                    System.out.println("update success!!!!");
                    break;
                }
            }
        } else {
            System.err.println("id not found in cart");
        }
    }

    public void deleteCartItem(User user) {
        new ProductView().showListProduct();
        List<CartItem> cart = user.getCart();
        System.out.println("Enter id cart item change: ");
        int idCartItem = scanner().nextInt();
        if (checkCartItemExit(cart,idCartItem)){
            for (CartItem item: cart) {
                //xóa nó
                if (item.getId()==idCartItem){
                    cart.remove(item);
                    user.setCart(cart);
                    userController.update(user);
                    break;
                }
            }
        }
        else {
            System.err.println("Id not found in cart!!!!!");
        }
    }

    public boolean checkCartItemExit(List<CartItem> cart, int idCartItem) {
        for (CartItem item : cart) {
            if (item.getId() == idCartItem) {
                return true;
            }
        }
        return false;
    }
//    public  void checkOut(){}
}

