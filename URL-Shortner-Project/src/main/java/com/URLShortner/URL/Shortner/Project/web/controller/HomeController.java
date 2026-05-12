package com.URLShortner.URL.Shortner.Project.web.controller;

import com.URLShortner.URL.Shortner.Project.ApplicationProperties;
import com.URLShortner.URL.Shortner.Project.domain.models.CreateShortUrlCmd;
import com.URLShortner.URL.Shortner.Project.domain.models.ShortUrlDto;
import com.URLShortner.URL.Shortner.Project.domain.services.ShortUrlService;
import com.URLShortner.URL.Shortner.Project.web.dtos.CreateShortUrlForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class HomeController {
    private ShortUrlService shortUrlService;
    private final ApplicationProperties applicationProperties;
    public HomeController(ShortUrlService shortUrlService, ApplicationProperties applicationProperties) {
        this.shortUrlService = shortUrlService;
        this.applicationProperties = applicationProperties;
    }
    @GetMapping("/")
    public String homePage(Model UrlModel) {
        List<ShortUrlDto> shortUrls = shortUrlService.findAllPublicShortUrls();
        UrlModel.addAttribute("createShortUrlForm", new CreateShortUrlForm(""));
        UrlModel.addAttribute("title", "URL-Shortner");
        UrlModel.addAttribute("shortUrls", shortUrls);
        UrlModel.addAttribute("baseUrl", applicationProperties.baseUrl());
        return "index";
    }

    @PostMapping("/short-urls")
    String createShortUrl(@ModelAttribute("createShortUrlForm") @Valid CreateShortUrlForm form,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        if(bindingResult.hasErrors()) {
            List<ShortUrlDto> shortUrls = shortUrlService.findAllPublicShortUrls();
            model.addAttribute("shortUrls", shortUrls);
            model.addAttribute("baseUrl", "http://localhost:8080/");
            return "index";
       }
        try {
           CreateShortUrlCmd cmd = new CreateShortUrlCmd(form.originalUrl());
           var shortUrlDto = shortUrlService.createShortUrl(cmd);
           redirectAttributes.addFlashAttribute("successMessage", "Short URL created successfully "+
                   applicationProperties.baseUrl() +"/s/"+shortUrlDto.shortKey());
      } catch (Exception e) {
           redirectAttributes.addFlashAttribute("errorMessage", "Failed to create short URL");

        }
        return "redirect:/";
    }

}
