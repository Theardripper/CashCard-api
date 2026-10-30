package com.CashCard.service.impl;

import com.CashCard.dto.request.CashCardRequestDTO;
import com.CashCard.dto.response.CashCardResponseDTO;
import com.CashCard.model.CashCard;
import com.CashCard.repository.CashCardRepository;
import com.CashCard.service.CashCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CashCardServiceImpl implements CashCardService {

    private final CashCardRepository cashCardRepository;
    private final CashCardService cashCardService;

    @Autowired
    public CashCardServiceImpl(CashCardRepository cashCardRepository, CashCardService cashCardService){
        this.cashCardRepository = cashCardRepository;
        this.cashCardService = cashCardService;
    }

    @Override
    public CashCardResponseDTO create(CashCardResponseDTO dto){
        CashCard cashCard = new CashCard();
        cashCard.setAmount(dto.getAmount());
        cashCard.setOwner(dto.getOwner());

        CashCard salved = cashCardRepository.save(cashCard);
        return toResponseDTO(salved);
    }

    @Override
    public CashCardResponseDTO findById(Long id){
        CashCard cashCard = cashCardRepository.findById(id)
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Card not found with ID" + id));
        return toResponseDTO(cashCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CashCardResponseDTO> updated (@PathVariable Long id, @Valid @RequestBody CashCardRequestDTO dto){
        return ResponseEntity.ok(cashCardService.update(id, dto));
    }

    private CashCardResponseDTO toResponseDTO(CashCard cashCard){
        return new CashCardResponseDTO(
                cashCard.getId(),
                cashCard.getAmount(),
                cashCard.getOwner()
        );
    }
}
