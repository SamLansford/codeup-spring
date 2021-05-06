package com.example.demo.controller;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repositories.PostRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepo postsDao;
    private final UserRepo usersDao;

    public PostController(PostRepo postsDao, UserRepo usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String index(Model vModel) {
        vModel.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postsDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model vModel) {
        Post postToEdit = postsDao.getOne(id);
        vModel.addAttribute("post", postToEdit);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(
            @PathVariable long id,
            @RequestParam String title,
            @RequestParam String body) {

        Post postToUpdate = new Post(
                id,
                title,
                body
        );

        postsDao.save(postToUpdate);

        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@RequestParam String title, @RequestParam String body) {
        User author = usersDao.getOne(1L);
        Post post = postsDao.save(new Post(
                title,
                body,
                author
        ));
        return "redirect:/posts/" + post.getId();
    }

}