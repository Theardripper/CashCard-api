package com.CashCard.controller;

import com.CashCard.dto.CashCard;
import com.CashCard.repository.CashCardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.net.URI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {
    private final CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<CashCard> findById(@PathVariable Long requestId){
        Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestId);
        if(cashCardOptional.isPresent()){
            return ResponseEntity.ok(cashCardOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Void> createCashCard(@RequestBody CashCard newwCashCardRequest, UriComponentsBuilder ucb){
        CashCard savedCashCard = cashCardRepository.save(newwCashCardRequest);
        URI locationOfNewCashCard = ucb
                .path("cashcards/{id}")
                .buildAndExpand(savedCashCard.id())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();
    }
}
