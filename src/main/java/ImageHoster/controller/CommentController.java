package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    //This method is called to update the comments
    //The method takes in id,title as PathVariable and also comment as the message
    @RequestMapping(value = "/image/{id}/{title}/comments",method = RequestMethod.POST)
    public String createComment(@PathVariable(name = "id") Integer id, @PathVariable(name = "title") String title, String comment, HttpSession session)
    {
        User loggeduser = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(id);
        Comment newComment = new Comment();
        newComment.setText(comment);
        newComment.setUser(loggeduser);
        newComment.setImage(image);
        newComment.setCreatedDate(LocalDate.now());
        commentService.addComment(newComment);
        return "redirect:/images/"+id+"/"+title;
    }
}
