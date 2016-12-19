package net.xiaocun.controller;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.Category;
import net.xiaocun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/11/29.
 */
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<PageResult<Category>> getCategorys(@RequestParam int page, @RequestParam int pageSize) {
        Category param = new Category();
        PageResult<Category> result = categoryService.getCategoryByPram(param, page, pageSize);

        return new ResponseEntity<PageResult<Category>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getBlog(@PathVariable("id") int id) {
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
