package Model;

import javax.persistence.*;


@Entity
@Table(schema = "BookManagementSystem", name = "reviews")

public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Long id;

    @Column(name = "score")
    private int score;

    @Column(name = "review")
    private String review;

    public Reviews() {
    }

    public Reviews(int score, String review) {
        this.score = score;
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
