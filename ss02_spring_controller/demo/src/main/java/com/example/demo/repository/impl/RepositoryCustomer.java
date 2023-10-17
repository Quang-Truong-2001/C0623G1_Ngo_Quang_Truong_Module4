package com.example.demo.repository.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.IRepositoryCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositoryCustomer implements IRepositoryCustomer {

    private static final List<Customer> customers=new ArrayList<>();
    static {
        customers.add(new Customer(1,"Nguyễn Văn A", "a@gmail.com", "Hà Nội"));
        customers.add(new Customer(2,"Nguyễn Văn B", "b@gmail.com", "Hà Nội"));
        customers.add(new Customer(3,"Nguyễn Văn C", "c@gmail.com", "Hà Nội"));
        customers.add(new Customer(4,"Nguyễn Văn D", "d@gmail.com", "Hà Nội"));
    }
    @Override
    public List<Customer> getList() {
        return customers;
    }

    @Override
    public Customer selectCustomer(int id) {
        for(Customer c:customers){
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void edit(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void save(Customer customer) {
        customer.setId(customers.size()+1);
        customers.add(customer);
    }
}
