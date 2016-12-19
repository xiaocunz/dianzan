package net.xiaocun.controller;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.Comment;
import net.xiaocun.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/11/27.
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public ResponseEntity<PageResult<Comment>> getBlogs(@RequestParam long blogId, @RequestParam int page, @RequestParam int pageSize) {
        Comment param = new Comment();
        param.setBlogId(blogId);
        PageResult<Comment> result = commentService.getCommentByPram(param, page, pageSize);

        return new ResponseEntity<PageResult<Comment>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Comment> register(@RequestBody Comment comment) {
        System.out.println("Insert Comment with param " + comment);
        Comment result = commentService.insert(comment);
        return new ResponseEntity<Comment>(result, HttpStatus.OK);
    }
}
