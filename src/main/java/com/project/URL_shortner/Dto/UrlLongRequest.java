package com.project.URL_shortner.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UrlLongRequest {
    public String longUrl;
    public Date createdDate;
    public Date expireDate;
}
