package com.example.demo.controller;

import com.example.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    public String post(Model vModel) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Post Title 1", "something 1"),
                new Post("Post Title 2", "something 2"),
                new Post("Post Title 3", "something 3")
        ));
        vModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postsID(@PathVariable Long id, Model vModel) {
        Post post = new Post("test Title", "Test Body");
        vModel.addAttribute("id",id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String postsCreate() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postingCreate() {
        return "create a new post";
    }
}
