package web.dao;

import web.model.UserModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
         entityManager.merge(newUser);

    }

    @Override
    public void delete(long id) {
        UserModel userModel = entityManager.find(UserModel.class, id);
        entityManager.remove(userModel);
    }
}
