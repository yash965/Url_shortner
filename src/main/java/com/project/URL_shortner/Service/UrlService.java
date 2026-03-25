package com.project.URL_shortner.Service;

import com.project.URL_shortner.Dto.UrlLongRequest;
import com.project.URL_shortner.Entity.URL;
import com.project.URL_shortner.Repository.UrlShortnerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlService {
    public final BaseConversion baseConversion;
    public final UrlShortnerRepo urlRepository;

    public UrlService(BaseConversion baseConversion, UrlShortnerRepo urlRepository)
    {
        this.baseConversion = baseConversion;
        this.urlRepository = urlRepository;
    }

    public String convertToShortUrl(UrlLongRequest urlLongRequest)
    {
        URL url = new URL();

        url.setLongUrl(urlLongRequest.longUrl);
        url.setCreatedDate(new Date());
        url.setExpireDate(urlLongRequest.expireDate);

        var entity = urlRepository.save(url);

        return baseConversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl)
    {
        long id = baseConversion.decode(shortUrl);
        URL url = urlRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        if(url.getExpireDate() != null && url.expireDate.before(new Date()))
        {
            urlRepository.delete(url);
            throw new EntityNotFoundException("Link Expired");
        }

        return url.getLongUrl();
    }
}
