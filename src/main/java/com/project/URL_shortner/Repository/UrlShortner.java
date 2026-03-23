package com.project.URL_shortner.Repository;

import com.project.URL_shortner.Entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortner extends JpaRepository<URL, Long> {
}
