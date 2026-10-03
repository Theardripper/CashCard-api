package com.CashCard.service;

import com.CashCard.dto.request.CashCardRequestDTO;
import com.CashCard.dto.response.CashCardResponseDTO;

import java.util.List;

public interface CashCardService {
    CashCardResponseDTO create(CashCardResponseDTO dto);
    CashCardResponseDTO findById(Long id);
    List<CashCardResponseDTO> findAll();
    CashCardResponseDTO update(Long id, CashCardRequestDTO dto);
    void delete(Long id);
}
