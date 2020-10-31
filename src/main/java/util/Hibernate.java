package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Hibernate {
    static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        try{
            Configuration configuration = new org.hibernate.cfg.Configuration();
            Properties properties = new Properties();

            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/users?createDatabaseIfNotExist=true&serverTimeZone=UTC");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "Faithful777");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            properties.put(Environment.HBM2DDL_AUTO, "create-drop");
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            configuration.setProperties(properties);

            //Needs configuration.addAnnotatedClass();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return sessionFactory;
    }
}
