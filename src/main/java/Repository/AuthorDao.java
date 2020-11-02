package Repository;

import Model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

public class AuthorDao {

    public void createAuthor(Author author){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getConnectionBD();

            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            //session.close();

        }catch(Exception e){
           // System.out.println(e.getMessage());
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
}
