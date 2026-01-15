package com.telusco.SpringMVC.dao;

import com.telusco.SpringMVC.model.Alien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AlienDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Alien> getAliens() {

        Session session = sessionFactory.getCurrentSession();
//        List<Alien> aliens = session.createQuery("from Alien", Alien.class).list();

        List<Alien> aliens = session.createQuery("from Alien").list();
        return aliens;
    }


    @Transactional
    public void addAlien(Alien a) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(a);
    }

    @Transactional
    public Alien getAlien(int aid) {
        Session session = sessionFactory.getCurrentSession();
        Alien a = session.get(Alien.class, aid);
        return a;
    }

}
