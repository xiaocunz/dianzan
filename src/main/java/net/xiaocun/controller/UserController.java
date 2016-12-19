package net.xiaocun.controller;

import net.xiaocun.common.PageResult;
import net.xiaocun.model.User;
import net.xiaocun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/11/27.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getBlogById(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.getById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getBlogByNickName(@RequestParam String nickName) {
        System.out.println("Fetching User with nickName " + nickName);
        User user = userService.getByNickName(nickName);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/auth", method = RequestMethod.GET)
    public ResponseEntity<User> login(@RequestParam String userName, @RequestParam String password) {

        User user = userService.authUser(userName, password);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("Insert User with param " + user);
        User temp = new User();
        if (user != null)
            temp = user;
        User result = userService.register(temp);
        return new ResponseEntity<User>(result, HttpStatus.OK);
    }
}
