package com.rico.demo.controller;

import com.rico.demo.domain.User;
import com.rico.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rico on 2017/6/16.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user -> index
     *
     * http://localhost:8080/user?limit=3&
     * @return
     */
    @GetMapping
    public String toUserIndex(ModelMap modelMap) {
        List<User> userList = this.userService.getAllUserList();
        if(userList != null) {
            for (User user: userList
                 ) {
                log.info("id = {}", user.getId());
                log.info("name = {}", user.getName());
                log.info("age = {}", user.getAge());
            }
        }
        modelMap.put("userList", userList);
        return "user/index";
    }

    @GetMapping("/new")
    public String toUserNew() {
        return "user/new";
    }

    @GetMapping("/{id}")
    public String toUserModify(@PathVariable Long id, ModelMap modelMap){
        log.info("id = {}", id);
        User user = new User(100L, "何峥言", 23);
        modelMap.put("user", user);
        return "user/modify";
    }

    @PostMapping
    @ResponseBody
    public String newUser(User user) {
        return "New a user success.";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String modifyUser(@PathVariable Long id, @RequestBody User user) {
        log.info("id = {}", id);
        if(user != null) {
            log.info("id = {}", user.getId());
            log.info("name = {}", user.getName());
            log.info("age = {}", user.getAge());
        }
        return "Modify a user success.";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String DeleteUser(@PathVariable Long id) {
        log.info("id = {}", id);
        return "Delete a user success.";
    }

}
