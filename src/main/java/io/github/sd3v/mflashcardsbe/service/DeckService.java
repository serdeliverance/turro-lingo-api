package io.github.sd3v.mflashcardsbe.service;

import io.github.sd3v.mflashcardsbe.domain.CreateDeck;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeckService {
    public Mono<Void> create(CreateDeck toDomain) {
        // TODO implement
        return null;
    }
}
