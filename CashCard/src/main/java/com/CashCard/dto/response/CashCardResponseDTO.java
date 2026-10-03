package com.CashCard.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashCardResponseDTO {

    private Long id;
    private Double amount;
    private String owner;
}
