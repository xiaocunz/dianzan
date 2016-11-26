package net.xiaocun.controller;

import jdk.nashorn.internal.parser.JSONParser;
import net.xiaocun.common.PageResult;
import net.xiaocun.model.Blog;
import net.xiaocun.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/11/26.
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ResponseEntity<PageResult<Blog>> getBlogs(@RequestParam int page, @RequestParam int pageSize) {
        Blog param = new Blog();
        PageResult<Blog> result = blogService.getBlogByPram(param, page, pageSize);

        return new ResponseEntity<PageResult<Blog>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        Blog blog = blogService.getBlogById(id);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}
