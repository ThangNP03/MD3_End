package rikkei.academy.service.user;

import rikkei.academy.model.User;
import rikkei.academy.service.IGenericService;

public interface IUserService extends IGenericService<User> {
    User login (String username, String password);
    boolean changeUserStatus (int id);
    boolean checkUserNameExit(String username);

}
