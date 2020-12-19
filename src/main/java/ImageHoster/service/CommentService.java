package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //the method adds the comment in the comments table
    //Input of type comment is taken from the controller and passed to the repository
    public void addComment(Comment comment){
        commentRepository.addComment(comment);
    }
}
