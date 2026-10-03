package com.CashCard.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashCardRequestDTO {

    @NotBlank(message = "Quantia é obrigatório. ")
    private Double amount;

    @NotBlank(message = "Dono é obrigatório. ")
    private String owner;

}
