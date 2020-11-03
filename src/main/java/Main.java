import Model.Author;
import Model.Books;
import Model.Reviews;
import Repository.AuthorDao;
import Repository.BooksDao;
import Repository.ReviewsDao;
import util.Hibernate;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Hibernate.getConnectionBD();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Please select one option");
            System.out.println("+++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println("1: Add Author");
            System.out.println("2: Delete Author");
            System.out.println("3: Update Author");
            System.out.println("4: Add Book");
            System.out.println("5: Delete Book");
            System.out.println("6: Create Review");
            System.out.println("7: Delete Review");
            System.out.println("8: Quit");

            int choice = scanner.nextInt();
            if(choice < 1 || choice > 8){
                System.out.println("Enter a valid number!\n");
            }

            switch(choice){

                case 1 :
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

                case 2 :
                    author = new Author();
                    System.out.print("Please enter author ID: ");
                    long authorId  = scanner.nextLong();
                    author.getId(authorId);
                    authorDao = new AuthorDao();
                    authorDao.deleteAuthor(authorId);

                    // list of authors

                    AuthorDao authorList = new AuthorDao();
                    System.out.println(authorList.getAuthors());
                    break;


//                case 3 :
//
//                    Author authorToUpdate = new Author();
//                    System.out.println("Please enter the first name");
//                    String firstName = scanner.next();
//                    author.setFirstName(firstName);
//                    System.out.println("Please enter the last name");
//                    String lastName = scanner.next();
//                    author.setLastName(lastName);
//                    AuthorDao authorDao = new AuthorDao();
//                    authorDao.createAuthor(author);



                case 4 :
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

                case 5 :
                    book = new Books();
                    scanner.nextLine();
                    System.out.print("Please enter book ID: ");
                    long bookId  = scanner.nextLong();
                    book.getId(bookId);
                    booksDao = new BooksDao();
                    booksDao.deleteBook(bookId);
                    break;


                case 6 :
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

                case 7 :
                    reviews = new Reviews();
                    System.out.print("Please enter review ID: ");
                    long reviewId  = scanner.nextLong();
                    reviews.getId(reviewId);
                    ReviewsDao reviewsDao1 = new ReviewsDao();
                    reviewsDao1.deleteReview(reviewId);


                case 8:
                    break;

            }
        }
    }
}
