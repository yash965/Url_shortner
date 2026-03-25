package com.project.URL_shortner.Repository;

import com.project.URL_shortner.Entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortnerRepo extends JpaRepository<URL, Long> {
}
