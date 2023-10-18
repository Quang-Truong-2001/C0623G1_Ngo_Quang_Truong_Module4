package com.example.ex_product.repository.impl;

import com.example.ex_product.model.Product;
import com.example.ex_product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private static final Map<Integer, Product> products=new HashMap<>();
    static {
        products.put(1,new Product(1,"Gao", 25000.0));
        products.put(2,new Product(2,"Tao",15000.0));
        products.put(3,new Product(3,"Bap",20000.0));
    }
    @Override
    public List<Product> showList() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        product.setId(products.size()+1);
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product detail(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> findList=new ArrayList<>();
        for(Product product:showList()){
            if(product.getName().contains(name)){
                findList.add(product);
            }
        }
        return findList;
    }
}
