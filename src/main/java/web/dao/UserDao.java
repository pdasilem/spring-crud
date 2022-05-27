package web.dao;

import web.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> usersList();
    UserModel show(Long id);
    void save(UserModel userModel);
    void delete(Long id);
    void update(Long id, UserModel newUser);
}
