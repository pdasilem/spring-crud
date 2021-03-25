package dao;

import model.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserModel> usersList(){
        return entityManager.createQuery("from UserModel", UserModel.class).getResultList();
    }

    @Override
    public UserModel show(long id) {
        return entityManager.find(UserModel.class, id);
    }

    @Override
    public void save(UserModel userModel) {
        entityManager.persist(userModel);
    }

    @Override
    public void update(long id, UserModel newUser) {
        UserModel updateUser = entityManager.find(UserModel.class, id);
        updateUser.setName(newUser.getName());
        updateUser.setSurName(newUser.getSurName());
        updateUser.setAge(newUser.getAge());
        updateUser.setProfession(newUser.getProfession());
        updateUser.setYearsExp(newUser.getYearsExp());
        entityManager.persist(updateUser);
    }

    @Override
    public void delete(long id) {
        UserModel userModel = entityManager.find(UserModel.class, id);
        entityManager.remove(userModel);
    }
}
