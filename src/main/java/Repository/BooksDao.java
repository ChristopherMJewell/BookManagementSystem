package Repository;

import Model.Author;
import Model.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.awt.print.Book;

public class BooksDao {
    public void createBooks(Books books){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getConnectionBD();

            transaction = session.beginTransaction();
            session.save(books);
            transaction.commit();
            //session.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public void deleteBook(long id) {
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Books books = session.find(Books.class,id);
            session.delete(books);

            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
