package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.IRepositoryCustomer;
import com.example.demo.service.IServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCustomerImpl implements IServiceCustomer {
    @Autowired
    private IRepositoryCustomer repositoryCustomer;
    @Override
    public List<Customer> getList() {
        return repositoryCustomer.getList();
    }

    @Override
    public Customer selectCustomer(int id) {
        return repositoryCustomer.selectCustomer(id);
    }

    @Override
    public void edit(Customer customer) {
        repositoryCustomer.edit(customer);
    }

    @Override
    public void delete(int id) {
        repositoryCustomer.delete(id);
    }

    @Override
    public void save(Customer customer) {
        repositoryCustomer.save(customer);
    }
}
