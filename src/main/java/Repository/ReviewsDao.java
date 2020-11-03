package Repository;


import Model.Reviews;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

public class ReviewsDao {
    public void createReviews(Reviews reviews){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getConnectionBD();

            transaction = session.beginTransaction();
            session.save(reviews);
            transaction.commit();
            //session.close();

        }catch(Exception e){
            System.out.println(e.getMessage());

            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public void deleteReview(long id) {
        Session session = Hibernate.getConnectionBD();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Reviews reviews = session.find(Reviews.class,id);
            session.delete(reviews);

            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
