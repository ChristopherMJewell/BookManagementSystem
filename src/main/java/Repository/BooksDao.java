package Repository;

import Model.Author;
import Model.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.awt.print.Book;
import java.util.Scanner;

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
    public void updateBook(Long booksId) {
        Scanner scanner = new Scanner(System.in);
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;
        Books books = session.find(Books.class,booksId);
        System.out.println("Please enter a new title.");
        String newTitle = scanner.nextLine();
        System.out.println("Please enter a new description.");
        String newDescription = scanner.nextLine();
        System.out.println("Please enter a new genre.");
        String newGenre = scanner.nextLine();
        books.setTitle(newTitle);
        books.setBookDescription(newDescription);
        books.setGenre(newGenre);

        try {
            transaction = session.beginTransaction();
            session.update(books);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
}
