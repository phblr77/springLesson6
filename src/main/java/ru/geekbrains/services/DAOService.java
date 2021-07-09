package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Product;
import ru.geekbrains.entities.User;
import ru.geekbrains.repositories.DAORepository;

import java.util.List;


@Service
public class DAOService {

    private final DAORepository daoRepository;

    @Autowired
    public DAOService(DAORepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    public List<User> getListUser() {
        return daoRepository.getListUser();
    }

    public List<Product> getListProduct() {
        return daoRepository.getListProduct();
    }


    public void deleteProductByUserId(Long user_id, Long product_id) {
        daoRepository.deleteProductByUserId(user_id, product_id);

    }

    public User getUserById(Long user_id) {
        return daoRepository.getUserById(user_id);
    }


    public List<User> getListUserByProductId(Long product_id) {
        return daoRepository.getListUserByProductId(product_id);
    }


    public List<Product> getListProductByUserId(Long user_id) {
        return daoRepository.getListProductByUserId(user_id);
    }
}