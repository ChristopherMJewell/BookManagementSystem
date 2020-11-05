package Model;

import javax.persistence.*;

@Entity
@Table(schema = "BookManagementSystem", name = "booksAuthorsReviews")

public class BooksAuthorsReviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany




    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
}
