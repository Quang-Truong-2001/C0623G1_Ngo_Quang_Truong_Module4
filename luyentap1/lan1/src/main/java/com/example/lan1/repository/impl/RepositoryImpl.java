package com.example.lan1.repository.impl;

import com.example.lan1.model.Student;
import com.example.lan1.repository.IRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
@Repository
public class RepositoryImpl implements IRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Student> showList() {
        TypedQuery<Student> query=entityManager.createQuery("select s from Student as s",Student.class);
        return query.getResultList();
    }

    @Override
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(detail(id));
    }

    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    public Student detail(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query=entityManager.createQuery("select s from Student as s where s.name like :name",Student.class);
        query.setParameter("name","%"+name+"%");
        return query.getResultList();
    }
}
