package com.URLShortner.URL.Shortner.Project.domain.web.controller;

import com.URLShortner.URL.Shortner.Project.domain.entities.ShortUrl;
import com.URLShortner.URL.Shortner.Project.domain.services.ShortUrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private ShortUrlService shortUrlService;
    public HomeController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }
    @GetMapping("/")
    public String homePage(Model UrlModel) {
        List<ShortUrl> shortUrls = shortUrlService.findPublicShortUrls();
        UrlModel.addAttribute("title", "URL-Shortner");
        UrlModel.addAttribute("shortUrls", shortUrls);
        UrlModel.addAttribute("baseUrl", "http://localhost:8080/");
        return "index";
    }

}
