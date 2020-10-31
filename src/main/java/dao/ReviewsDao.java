package dao;

import entity.Reviews;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

public class ReviewsDao {
    public void createReviews(Reviews reviews){
        Transaction transaction = null;

        try{
            Session session = Hibernate.getSessionFactory().openSession();

            transaction = session.beginTransaction();
            session.save(reviews);
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
