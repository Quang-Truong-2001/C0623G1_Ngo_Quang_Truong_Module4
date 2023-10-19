package com.example.ex_product.repository.impl;

import com.example.ex_product.model.Product;
import com.example.ex_product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> showList() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p",Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(detail(id));
    }

    @Override
    public Product detail(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findByName(String name) {
        String queryString = "select p from Product as p where p.name like :name";
        TypedQuery<Product> query=entityManager.createQuery(queryString,Product.class);
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }
}
