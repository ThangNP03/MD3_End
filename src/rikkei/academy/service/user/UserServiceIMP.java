package rikkei.academy.service.user;

import rikkei.academy.config.Config;
import rikkei.academy.model.Category;
import rikkei.academy.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMP implements IUserService{

    List<User> listUser = new Config<User>().readFromFile(Config.PATH_USER);
    @Override
    public List<User> findAll() {
        return listUser;
    }

    @Override
    public void save(User user) {
        if (findById(user.getId()) == null){
            listUser.add(user);
        }
        else {
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getId() == user.getId()){
                    listUser.set(i,user);
                }
            }
        }
        new  Config<User>().writeToFile(Config.PATH_USER,listUser);
    }

    @Override
    public User findById(int id) {
        for (User user: listUser) {
            if(user.getId() ==id){
                return user;
            }
        } return null;
    }

    @Override
    public void deleteById(int id) {
        for (User user: listUser) {
            if (user.getId() == id) {
                listUser.remove(user);
                new Config<User>().writeToFile(Config.PATH_USER,listUser);
            }
        }

    }



//    @Override
//    public List<User> searchByName(String searchName) {
//        List<Category> categoryListSearch = new ArrayList<>();
//        for (Category category:categoryList) {
//            if (category.getName().toLowerCase().contains(searchName.toLowerCase())){
//                categoryListSearch.add(category);
//            }
//        }
//       return categoryListSearch;
//    }


    @Override
    public User login(String username, String password) {
        for (User user: listUser) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) ) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean checkUserNameExit(String username) {
        for (User user: listUser) {
            if (user.getUsername()!=null && user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean changeUserStatus(int id) {
      if (findById(id)==null){
          return false;
      }
      else {
          for (User user: listUser) {
              if (user.getId() == id){
                  user.setStatus(user.isStatus());
                  new Config<User>().writeToFile(Config.PATH_USER,listUser);
                  break;
              }
          }
      }
      return true;
    }
}
