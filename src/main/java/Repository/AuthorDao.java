package Repository;

import Model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.util.List;
import java.util.Scanner;

public class AuthorDao {

    public void createAuthor(Author author) {
        Transaction transaction = null;

        try {
            Session session = Hibernate.getConnectionBD();

            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            session.close();

        } catch (Exception e) {
            // System.out.println(e.getMessage());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Author> getAuthors() {
        Session session = Hibernate.getConnectionBD();
        return session.createQuery("from Author", Author.class).list();
    }

    public void updateAuthor(Long iD) {
        Scanner scanner = new Scanner(System.in);
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;
        Author author1 = session.find(Author.class,iD);
        System.out.println("first name?");
        String newName = scanner.nextLine();
        System.out.println("last name?");
        String lastName = scanner.nextLine();
        author1.setFirstName(newName);
        author1.setLastName(lastName);


        try {
            transaction = session.beginTransaction();
            session.update(author1);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    public void deleteAuthor(long id) {
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Author author = session.find(Author.class,id);
            session.delete(author);

            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
