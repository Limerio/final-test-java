package com.github.limerio.spring_boot_apps.api.services;

import com.github.limerio.spring_boot_apps.api.models.Quote;
import com.github.limerio.spring_boot_apps.api.repositories.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        Random random = new Random();
        return quotes.get(random.nextInt(quotes.size()));
    }
}
