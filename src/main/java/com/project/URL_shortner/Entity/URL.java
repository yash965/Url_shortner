package com.project.URL_shortner.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "URL")
@Getter
@Setter
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column (nullable = false)
    public String longUrl;

    @Column (nullable = false)
    public String createdDate;

    public Date expireDate;
}
