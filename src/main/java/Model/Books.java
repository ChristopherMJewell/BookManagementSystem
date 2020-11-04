package Model;

import javax.persistence.*;

@Entity
@Table(schema = "BookManagementSystem", name = "books")

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "bookDescription")
    private String bookDescription;

    @Column(name = "genre")
    private String genre;

    public Books() {

    }

    public Books(String title, String bookDescription, String genre) {
        this.title = title;
        this.bookDescription = bookDescription;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
