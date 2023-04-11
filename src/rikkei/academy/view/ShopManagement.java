package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.UserController;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.user.UserServiceIMP;

import static rikkei.academy.config.Config.scanner;

public class ShopManagement {

    public static User userLogin = null;

    public static void main(String[] args) {
//        User admin = new User(1, "Nguyễn Phúc Thắng","adminthang","adminthang",null,null);
//        admin.setRole(RoleName.ADMIN);
//        new UserServiceIMP().save(admin);
        new UserViews().showListUser();
        while (true) {
            Navbar.navbarHomePage();
            System.out.print("Enter the choice: ");
            int choice = scanner().nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Good bye see you again!!!!");
                    break;
                default:
                    System.err.println("Please enter number for 1 to 3: ");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }

    public static void login() {
        User user = new UserViews().formLogin();
        System.out.println("LOGIN SUCCESS!!!!");
        if (user == null) {
            System.err.println("Incorrect username or password");
            System.out.println("----------Login---------");
            System.out.println("1. Try Again");
            System.out.println("2. You forgot password?");
            System.out.println("3. You don't have account, register now");
            System.out.println("------------------------");
            System.out.print("Please enter choice: ");
            int choice = scanner().nextInt();
            if (choice == 2) {
                // quên mật khẩu
                login();
            } else if (choice == 3) {
                // đăng kí
                register();
            } else {
                // đăng nhập lại
                login();
            }
        } else {
            userLogin = user;

            if (userLogin.getRole() == RoleName.ADMIN) {
                // chuyển hướng sang trang admin
                adminViews();
            } else if (user.getRole() == RoleName.CUSTOMER) {
                // chuyển hướng sang trang người dùng
                customerViews();
            }
        }

    }

    public static void register() {
        new UserViews().formRegister();
    }

    public static void adminViews() {
        while (true) {
            Navbar.navbarAdmin();
            System.out.print("Enter choice: ");
            int choice = scanner().nextInt();
            switch (choice) {
                case 1:
                    categoryManage();
                    break;
                case 2:
                    productManage();
                    break;
                case 3:
                    userManage();
                    break;
                case 4:
                    //order
                    break;
                case 5:
                    //feedBack
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Please enter number for 1 to 6: ");
            }
            if (choice == 6) {

                break;
            }
        }
    }

    public static void customerViews() {
        while (true) {
            Navbar.navbarCustomer();
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner().nextLine());
            switch (choice) {
                case 1:
                    new ProductView().showListProduct();
                    break;
                case 2:
                    CategoryView.formSearchCategory();
                    break;
                case 3:
                    new ProductView().searchProductsByName();
                    break;
                case 4:
                    cartView();

                    break;
                case 5:
                    //orderShow
                    break;
                case 6:
                    //feedback
                    break;
                case 7:
                    new UserViews().formUpdateUser(userLogin);
                    //UpdateUser
                    break;
                default:
                    System.err.println("Please enter number for 1 to 7: ");
            }
            if (choice == 8) {
                break;
            }
        }
    }

    //category quản lí danh mục
    public static void categoryManage() {
        while (true) {
            Navbar.navbarCategoryManager();
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner().nextLine());
            switch (choice) {
                case 1:
                    new CategoryView().showFormCategoryList();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                    break;
                case 3:
                    new CategoryView().formUpdateCategory();
                    break;
                case 4:
                    new CategoryView().deleteById();
                case 5:
                    adminViews();
                    break;
                default:
                    System.err.println("Please enter number for 1 to 4: ");
            }
        }
    }

    //user quản lí người dùng
    public static void userManage() {
        Navbar.navbarUserManager();
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner().nextLine());
        switch (choice) {
            case 1:
                new UserViews().showListUser();
                break;
            case 2:
                new UserViews().changeUserStatus();
                break;
            case 3:
                Navbar.navbarAdmin();
                break;
            default:
                System.err.println("Please enter number for 1-2: ");
        }

    }

    //product quản lí sản phẩm
    public static void productManage() {
        Navbar.navbarProductManager();
        System.out.println("Enter choice: ");
        int choice = Integer.parseInt(scanner().nextLine());
        switch (choice) {
            case 1:
                new ProductView().showListProduct();
                break;
            case 2:
                new ProductView().formCreateProduct();
                break;
            case 3:
                new ProductView().updateProducts();
                break;
            case 4:
                new ProductView().deleteProductById();
                break;
            case 5:
                new ProductView().searchProductsByName();
            case 6:
                adminViews();
            default:
                System.err.println("Please enter number for 1 to 6: ");
        }


    }

    public static void cartView() {
        while (true) {
            Navbar.navbarCart();
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner().nextLine());
            switch (choice) {
                case 1:
                    new UserViews().showListCart(userLogin);
                    break;
                case 2:
                    new UserViews().addToCart(userLogin);
                    break;
                case 3:
                    new UserViews().changeQuantytiItem(userLogin);
                    break;
                case 4:
                    new UserViews().deleteCartItem(userLogin);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Please enter number for 1 to 5: ");
            }
            if (choice == 6) {
                break;
            }
        }
    }
}
