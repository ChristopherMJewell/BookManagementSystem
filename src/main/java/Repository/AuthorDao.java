package Repository;

import Model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

import java.util.List;

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

    public void updateAuthor(Author savedAuthor) {
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(savedAuthor);
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
