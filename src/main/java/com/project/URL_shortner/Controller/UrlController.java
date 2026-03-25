package com.project.URL_shortner.Controller;

import com.project.URL_shortner.Dto.UrlLongRequest;
import com.project.URL_shortner.Service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UrlController {
    public final UrlService urlService;

    public UrlController(UrlService urlService)
    {
        this.urlService = urlService;
    }

    @PostMapping("/short")
    public String createShortUrl(@RequestBody UrlLongRequest urlLongRequest)
    {
        return urlService.convertToShortUrl(urlLongRequest);
    }

    @GetMapping("r/{shortUrl}")
    public ResponseEntity<Void> getAndRedirect(@PathVariable String shortUrl)
    {
        String longUrl = urlService.getOriginalUrl(shortUrl);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }

    @GetMapping("/test")
    public String test() {
        return "working";
    }

}
