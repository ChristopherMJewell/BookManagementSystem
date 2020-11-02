package util;

import Model.Author;
import Model.Books;
import Model.Reviews;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate {

    private static SessionFactory factory;

    public static synchronized Session getConnectionBD(){
        if(factory == null){
            factory = getSessionFactory();
        }
        return factory.openSession();
    }

    private static SessionFactory getSessionFactory(){
        try{
            Configuration configuration = new org.hibernate.cfg.Configuration();
            Properties properties = new Properties();

            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/users?createDatabaseIfNotExist=true&serverTimeZone=UTC");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Faithful777");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            configuration.setProperties(properties);

            //Needs configuration.addAnnotatedClass();


            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Books.class);
            configuration.addAnnotatedClass(Reviews.class);


            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return factory;
    }
}
