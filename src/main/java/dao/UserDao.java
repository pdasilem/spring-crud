package dao;

import model.UserModel;

import java.util.List;

public interface UserDao {
    List<UserModel> usersList();
    UserModel show(long id);
    void save(UserModel userModel);
    void delete(long id);
    void update(long id, UserModel newUser);
}
