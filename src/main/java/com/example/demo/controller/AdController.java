package com.example.demo.controller;

import com.example.demo.models.Ad;
import com.example.demo.repositories.AdRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    // Constructor dependency injection
    private final AdRepo adsDao;

    public AdController(AdRepo adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAllAds() {
        return adsDao.findAll();
    }


    @GetMapping("/ads/{id}")
    public String getOneAd(@PathVariable long id, Model vModel) {
        Ad ad = adsDao.getOne(id);
        vModel.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/delete")
    public String deleteAd() {
        adsDao.deleteById(4L);
        return "redirect:/ads";
    }

    @GetMapping("/ads/create")
    public String createAD() {
        Ad ad = new Ad(
                "Unicorn",
                "It is a very small unicorn",
                2000
        );
        adsDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/update")
    public String updateAd() {
        Ad updatedAd = new Ad(
                101,
                "Dragon",
                "It is a dragon.",
                200
        );
        adsDao.save(updatedAd);
        return "redirect:/ads";
    }
}
