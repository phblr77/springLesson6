package ru.geekbrains.repositories;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.geekbrains.daoConnection.SessionManager;
import ru.geekbrains.entities.Product;
import ru.geekbrains.entities.User;

import java.util.List;

@Repository
public class DAORepository {
    private static final Session session = SessionManager.getSession();

    private void beginTran() {
        session.getTransaction().begin();
    }

    private void commitTran() {
        session.getTransaction().commit();
    }

    //нужен ли здесь begin и commit, если и без них работает
    public List<User> getListUser() {
        // beginTran();
        List<User> users = session.createQuery("select c from User c", User.class).getResultList();
        // commitTran();
        return users;
    }

    public List<Product> getListProduct() {
        //beginTran();
        List<Product> products = session.createQuery("select p from Product p", Product.class).getResultList();
        //commitTran();
        return products;
    }


    public void deleteProductByUserId(Long user_id, Long product_id) {
        beginTran();
        User user = getUserById(user_id);
        List<Product> products = user.getProducts();

        for (Product p : products) {
            if (p.getId().equals(product_id)) {
                products.remove(p);
                break;
            }
        }
        session.merge(user);
        commitTran();
    }

    public User getUserById(Long user_id) {
        return session.find(User.class, user_id);
    }


    public List<User> getListUserByProductId(Long product_id) {
        //beginTran();
        List<User> customers = session.find(Product.class, product_id).getUsers();
        //commitTran();
        return customers;
    }


    public List<Product> getListProductByUserId(Long user_id) {
        //beginTran();
        List<Product> products = getUserById(user_id).getProducts();
        //commitTran();
        // SessionManager.close(); где нужно закрывать session и factory?
        return products;

    }
}
