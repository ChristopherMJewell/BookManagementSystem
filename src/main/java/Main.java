import Model.Author;
import Model.Books;
import Model.Reviews;
import Repository.AuthorDao;
import Repository.BooksDao;
import Repository.ReviewsDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.Hibernate;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Hibernate.getConnectionBD();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please select one option");
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("1: Create new Author"); //ok
            System.out.println("2: List all authors"); //ok
            System.out.println("3: Delete Author"); //ok
            System.out.println("4: Update Author"); //nok
            System.out.println("5: Create new Book"); //ok
            System.out.println("6: List all Books"); //ok
            System.out.println("7: Delete a Book"); //ok
            System.out.println("8: Update a Book"); //ok
            System.out.println("9: Create a Review"); //ok
            System.out.println("10: Delete a Review"); //ok
            System.out.println("11: Exit program"); //ok

            int choice = scanner.nextInt();
            if(choice < 1 || choice > 11){
                System.out.println("Enter a valid number!\n");
            }

            switch(choice){

                case 1 : // create new author
                    Author author = new Author();
                    System.out.println("Please enter the first name");
                    String firstName = scanner.next();
                    author.setFirstName(firstName);
                    System.out.println("Please enter the last name");
                    String lastName = scanner.next();
                    author.setLastName(lastName);
                    AuthorDao authorDao = new AuthorDao();
                    authorDao.createAuthor(author);
                    break;

                case 2 :  // List all authors
                    Session session = Hibernate.getConnectionBD();
                    Criteria criteria = session.createCriteria(Author.class);
                    List<Author> listOfAuthors = criteria.list();
                    for(Author test: listOfAuthors) {
                        System.out.println(test.getId()+ " " + test.getFirstName() + " " + test.getLastName());
                    }
                    break;


                case 3: // delete author
                    author = new Author();
                    System.out.print("Please enter author ID: ");
                    long authorId  = scanner.nextLong();
                    author.getId();
                    authorDao = new AuthorDao();
                    authorDao.deleteAuthor(authorId);
                    break;

                case 4: // Update author
                    break;



                case 5 : // Create new Book
                    Books book = new Books();
                    System.out.print("Please enter the title of the book: ");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    book.setTitle(title);
                    System.out.print("Please enter short description of the book: ");
                    String bookDescription = scanner.nextLine();
                    book.setBookDescription(bookDescription);
                    System.out.print("Please enter genre of the book: ");
                    String genre = scanner.nextLine();
                    book.setGenre(genre);
                    BooksDao booksDao = new BooksDao();
                    booksDao.createBooks(book);
                    break;

                case 6: // List all books
                    session = Hibernate.getConnectionBD();
                    criteria = session.createCriteria(Books.class);
                    List<Books> listOfBooks = criteria.list();
                    for(Books test: listOfBooks) {
                    System.out.println(test.getId()+ " " + test.getTitle() + " " + test.getGenre() + " " + test.getBookDescription());
                    }
                    break;

                case 7 : // delete a abook
                    book = new Books();
                    scanner.nextLine();
                    System.out.print("Please enter book ID: ");
                    long bookId  = scanner.nextLong();
                    book.getId();
                    booksDao = new BooksDao();
                    booksDao.deleteBook(bookId);
                    break;

                case 8: //update a book



                case 9 : // create a Review
                    Reviews reviews = new Reviews();
                    System.out.print("Please enter review of the book:");
                    String review = scanner.nextLine();
                    reviews.setReview(review);
                    scanner.nextLine();
                    System.out.print("Please enter score to book from 1 to 10: ");
                    int score = scanner.nextInt();
                    reviews.setScore(score);
                    ReviewsDao reviewsDao = new ReviewsDao();
                    reviewsDao.createReviews(reviews);
                    break;

                case 10 : // delete a review
                    reviews = new Reviews();
                    System.out.print("Please enter review ID: ");
                    long reviewId  = scanner.nextLong();
                    reviews.getId(reviewId);
                    ReviewsDao reviewsDao1 = new ReviewsDao();
                    reviewsDao1.deleteReview(reviewId);
                    break;
            }
            if(choice == 11){
                break;
            }
        }
    }
}
