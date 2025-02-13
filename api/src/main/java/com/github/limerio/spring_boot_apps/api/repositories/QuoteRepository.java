package com.github.limerio.spring_boot_apps.api.repositories;

import com.github.limerio.spring_boot_apps.api.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
