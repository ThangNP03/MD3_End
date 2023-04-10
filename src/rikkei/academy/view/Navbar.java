package rikkei.academy.view;

import rikkei.academy.config.Config;



public class Navbar {
    public static void navbarHomePage() {
        System.out.println("******************* ADIDAS SHOE STORE *******************");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exits");
    }
    //admin
    public static   void navbarCategoryManager(){
        System.out.println("******************* ADMIN MANAGER *******************");
        System.out.println("1. Show Category");
        System.out.println("2. Create Category");
        System.out.println("3. Update Category");
        System.out.println("4. Exit");
        System.out.println("-----------------------------------------------------");
    }
    public static   void navbarProductManager(){
        System.out.println("******************* ADMIN MANAGER *******************");
        System.out.println("1. Show Product");
        System.out.println("2. Create Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Search by name ");
        System.out.println("6.exit");
        System.out.println("-------------------------------------------------------");
    }
    public static   void navbarUserManager(){
        System.out.println("******************* ADMIN MANAGER *******************");
        System.out.println("1. Show list User");
        System.out.println("2. Change user");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------------");
    }
    // admin
    public static void navbarAdmin(){
        System.out.println("******************* ADMIN MANAGER *******************");
        System.out.println("1. Category manage");
        System.out.println("2. Product manage");
        System.out.println("3. User manage");
        System.out.println("4. Order manage");
        System.out.println("5. Feedback");
        System.out.println("6.Logout");
        System.out.println("------------------------------------------------------");
    }
    //Admin
    //Customer
    public  static void navbarCustomer(){
        System.out.println("******************* ADIDAS SHOE STORE *******************");
        System.out.println("1. Show all product");
        System.out.println("2. Search product by category`s name ");
        System.out.println("3. Search product by product name ");
        System.out.println("4. Cart");
        System.out.println("5. Order show");
        System.out.println("6.Logout");
        System.out.println("----------------------------------------------------------");
    }

    public static void  navbarCart(){
        System.out.println("******************* ADIDAS SHOE STORE *******************");
        System.out.println("1. Show my cart");
        System.out.println("2. Add product my cart ");
        System.out.println("3. Change quantity");
        System.out.println("4. Delete Items ");
        System.out.println("5. CheckOut");
        System.out.println("6.Exit");
        System.out.println("----------------------------------------------------------");
    }
    // Customer

}