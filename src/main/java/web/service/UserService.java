package web.service;

import web.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> userList();
    UserModel show(long id);
    void update(long id, UserModel newUser);
    void delete(long id);
    void save(UserModel userModel);
}
