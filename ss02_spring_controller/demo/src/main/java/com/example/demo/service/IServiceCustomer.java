package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface IServiceCustomer {
    List<Customer> getList();
    Customer selectCustomer(int id);
    void edit(Customer customer);
    void delete(int id);
    void save(Customer customer);
}
