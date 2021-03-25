package service;

import model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface UserService {
    List<UserModel> userList();
    UserModel show(long id);
    void update(long id, UserModel newUser);
    void delete(long id);
    void save(UserModel userModel);
}
