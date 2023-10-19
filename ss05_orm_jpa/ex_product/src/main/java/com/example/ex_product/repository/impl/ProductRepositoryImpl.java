package com.example.ex_product.repository.impl;

import com.example.ex_product.model.Product;
import com.example.ex_product.repository.ConnectionUtil;
import com.example.ex_product.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements IProductRepository {



    @Override
    public List<Product> showList() {
        Session session = null;
        List<Product> products=null;
        try{
            session= ConnectionUtil.sessionFactory.openSession();
            products=session.createQuery("FROM Product ").getResultList();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return products;
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction=null;
        try{
            session= ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }
        finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.remove(detail(id));
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public Product detail(int id) {
        Session session = null;
        Product product=null;
        try{
            session= ConnectionUtil.sessionFactory.openSession();
            product=session.find(Product.class,id);
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
//        String queryString="select p from Product as p where p.name like :name";
//        TypedQuery<Product> query=ConnectionUtil.entityManager.createQuery(queryString,Product.class);
//        query.setParameter("name","%"+name+"%");
//        return query.getResultList();
        Session session = null;
        List<Product> products=null;
        try{
            session= ConnectionUtil.sessionFactory.openSession();
            String queryString="FROM Product where name like :name";
            Query query=session.createQuery(queryString);
            query.setParameter("name","%"+name+"%");
            products=query.getResultList();
        } finally {
            if(session!=null){
                session.close();
            }
        }
        return products;
    }
}
