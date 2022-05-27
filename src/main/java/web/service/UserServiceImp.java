package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import web.model.UserModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> userList() {
        return userDao.usersList();
    }

    @Override
    public UserModel show(long id) {
        return userDao.show(id);
    }

    @Override
    public void update(long id, UserModel newUser) {
        userDao.update(id, newUser);
    }

    @Override
    public void save(UserModel userModel) {
        userDao.save(userModel);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
