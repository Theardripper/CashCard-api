package com.CashCard.service.impl;

import com.CashCard.dto.response.CashCardResponseDTO;
import com.CashCard.model.CashCard;
import com.CashCard.repository.CashCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashCardServiceImpl {

    private final CashCardRepository cashCardRepository;

    @Autowired
    public CashCardServiceImpl(CashCardRepository cashCardRepository){
        this.cashCardRepository = cashCardRepository;
    }

    public CashCardResponseDTO create(CashCardResponseDTO dto){
        CashCard cashCard = new CashCard();
        cashCard.setAmount(dto.getAmount());
        cashCard.setOwner(dto.getOwner());

        CashCard salved = cashCardRepository.save(cashCard);
        return toResponseDTO(salved);
    }

    private CashCardResponseDTO toResponseDTO(CashCard cashCard){
        return new CashCardResponseDTO(
                cashCard.getId(),
                cashCard.getAmount(),
                cashCard.getOwner()
        );
    }
}
