package io.github.sd3v.mflashcardsbe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MaintenanceService {

    private final DeckService deckService;

    public void addIdToFlashcards() {
        deckService.getAll()
                .filter(deck -> deck.name().equals("example")) // just for development, delete later
    }
}
