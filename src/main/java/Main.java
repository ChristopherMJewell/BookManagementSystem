import Model.Author;
import Repository.AuthorDao;

import java.util.Scanner;
import org.hibernate.Session;
import util.Hibernate;


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
            System.out.println("6: View Books By Genre");
            System.out.println("7: Create Review");
            System.out.println("8: Delete Review");
            System.out.println("9: Quit");

            int choice = scanner.nextInt();
            if(choice < 1 || choice > 9){
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

            }

        }




    }
}
