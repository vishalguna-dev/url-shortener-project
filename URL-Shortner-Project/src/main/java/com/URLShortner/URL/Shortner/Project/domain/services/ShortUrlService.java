package com.URLShortner.URL.Shortner.Project.domain.services;

import com.URLShortner.URL.Shortner.Project.domain.entities.ShortUrl;
import com.URLShortner.URL.Shortner.Project.domain.models.ShortUrlDto;
import com.URLShortner.URL.Shortner.Project.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShortUrlService {
    private final ShortUrlRepository shortUrlRepository;
    private final EntityMapper entityMapper;

    public ShortUrlService(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.entityMapper = entityMapper;
    }

    public List<ShortUrlDto> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls()
                .stream().map(entityMapper::toShortUrlDto).toList();
    }
}
