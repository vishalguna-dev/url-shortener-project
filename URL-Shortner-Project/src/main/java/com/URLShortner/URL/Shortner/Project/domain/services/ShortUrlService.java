package com.URLShortner.URL.Shortner.Project.domain.services;

import com.URLShortner.URL.Shortner.Project.domain.entities.ShortUrl;
import com.URLShortner.URL.Shortner.Project.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }
    public List<ShortUrl> findPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls();
    }
}
