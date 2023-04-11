package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;
import rikkei.academy.model.Product;

import java.util.List;

import static rikkei.academy.config.Config.scanner;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void showFormCategoryList() {
        System.out.println("=================== TABLE CATEGORY ========================");
        System.out.println("ID  - NAME : ");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println("ID " + categoryList.get(i).getId() + " - NAME: " + categoryList.get(i).getName());
        }
        System.out.println("Enter any key to continue or 'back' to return Menu: ");
        String backMenu = scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Navbar();
        }
    }

    public void formCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Enter the name: ");
            String name = scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategoryToDB(category);
            System.out.println("Create Success!");
            System.out.println("Enter the any key to continue or Enter back to return Menu: ");
            String backMenu = scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Navbar();
                break;
            }
        }

    }

    public void formUpdateCategory() {
        while (true) {
            System.out.println("Enter the id to update: ");
            int id = scanner().nextInt();
            if (categoryController.detailCategory(id) == null) {
                System.err.println("Id not found! Please try again!");
//                id = Config.scanner().nextInt();
            } else {
                System.out.println("Enter the name: ");
                String name = scanner().nextLine();
                Category category = new Category(id, name);
                categoryController.updateCategory(category);
                System.out.println("Update success!");
                System.out.println("Enter the any key to continue or Enter back to return Menu: ");
                String backMenu = scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Navbar();
                    break;
                }
            }
        }
    }

    public static void formSearchCategory() {
        System.out.println("Enter category name");
        String name = scanner().nextLine();

        CategoryController categoryController = new CategoryController();
        List<Category> listSearch = categoryController.searchCategoryByName(name);
        if (listSearch.size() == 0) {
            System.out.println("Category not found");
        } else {
            for (Category category : listSearch) {
                System.out.println("-------------------------");
                System.out.println(category);
            }
        }
    }

    public void deleteById() {
        showFormCategoryList();
        System.out.println("Enter id to delete");
        int id = Integer.parseInt(scanner.nextLine());
        categoryController.deleteCategory(id);

    }
}
