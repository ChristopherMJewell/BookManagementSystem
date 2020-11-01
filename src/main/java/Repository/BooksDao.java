package Repository;

import Model.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

public class BooksDao {
    public void createBooks(Books books){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.save(books);
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
