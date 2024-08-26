package com.ddev.guess_the_number.shared.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ddev.guess_the_number.domain.repositories.MatchRepository;

@Component
public class CleanDatabase {

    private final MatchRepository repository;

    public CleanDatabase(MatchRepository repository) {
        this.repository = repository;
    }

    // Cron Order = Seconds, Minutes, Hours, Day of Month, Month, Day of Week, * = Every, ? = Not Specified
    @Scheduled(cron = "0 0 1 * * ?", zone = "America/Sao_Paulo")
    public void cleanDatabase() {
        repository.clean();
    }

}
