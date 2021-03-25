package web.dao;

import web.model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> usersList();
    UserModel show(long id);
    void save(UserModel userModel);
    void delete(long id);
    void update(long id, UserModel newUser);
}
