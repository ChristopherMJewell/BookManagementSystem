import Model.Author;
import Repository.AuthorDao;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
            System.out.println("7: ");

            int choice = scanner.nextInt();

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
