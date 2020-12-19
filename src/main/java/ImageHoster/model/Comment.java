package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;


//Here the name of the table to be created in the database is explicitly mentioned as 'comments'. Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'comments' class
@Entity
@Table(name = "comment")
public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    //text column is used to store the text of the comment
    @Column(name = "text",columnDefinition = "TEXT")
    private String text;

    //localDate to keep track of the commented date
    @Column(name = "createdDate")
    private LocalDate createdDate;

    //Comment table is mapped to the user table with Many:one mapping
    //One user can comment any number of times but one comment will have only one User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //Comment table is mapped to the image table with Many:one mapping
    //One image can have multiple comments but one comment will have only one image
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
