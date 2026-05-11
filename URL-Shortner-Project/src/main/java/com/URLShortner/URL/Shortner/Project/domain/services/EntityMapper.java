package com.URLShortner.URL.Shortner.Project.domain.services;
import com.URLShortner.URL.Shortner.Project.domain.entities.ShortUrl;
import com.URLShortner.URL.Shortner.Project.domain.entities.User;
import com.URLShortner.URL.Shortner.Project.domain.models.ShortUrlDto;
import com.URLShortner.URL.Shortner.Project.domain.models.UserDto;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public ShortUrlDto toShortUrlDto(ShortUrl shortUrl) {
        UserDto userDto = null;
        if(shortUrl.getCreatedBy() != null) {
            userDto = toUserDto(shortUrl.getCreatedBy());
        }

        return new ShortUrlDto(
                shortUrl.getId(),
                shortUrl.getShortKey(),
                shortUrl.getOriginalUrl(),
                shortUrl.getPrivate(),
                shortUrl.getExpiresAt(),
                userDto,
                shortUrl.getClickCount(),
                shortUrl.getCreatedAt()
        );
    }

    public UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}