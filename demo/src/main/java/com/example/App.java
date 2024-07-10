package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Foo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        //setupHibernate();
        //modifHibernate();
        borraHibernate();
        System.out.println("Hello World!");
    }

    public static void setupHibernate() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Foo.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        var tr = session.beginTransaction();

        Foo foo = new Foo();

        foo.id = 2;
        foo.name = "Oscar GF";
        foo.dni = "07502882Y";

        session.persist(foo);

        tr.commit();

        //  Si no se hace el sesion close, los objetos siguen en memoria
        session.close();    

        //172,174,179,91,230,160,76,160,188,49,145,255,50,230,157,178
    }

    public static void modifHibernate() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Foo.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        var tr = session.beginTransaction();
       
        Foo foo = session.get(Foo.class,1);
        
        foo.dni = "57502883P";
        //session.persist(foo);


        tr.commit();

        //  Si no se hace el sesion close, los objetos siguen en memoria
        session.close();    



    }

    public static void borraHibernate() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Foo.class)
                .buildMetadata()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        var tr = session.beginTransaction();
       
        Foo foo = session.get(Foo.class,1);
        
        session.remove(foo);

        tr.commit();

        //  Si no se hace el sesion close, los objetos siguen en memoria
        session.close();    



    }

}
