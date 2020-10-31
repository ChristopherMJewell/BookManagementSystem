package dao;

import entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.Hibernate;

public class AuthorDao {

    public void createAuthor(Author author){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            session.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
