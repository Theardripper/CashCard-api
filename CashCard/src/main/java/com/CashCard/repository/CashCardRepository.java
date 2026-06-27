package com.CashCard.repository;

import com.CashCard.dto.CashCard;
import org.springframework.data.repository.CrudRepository;

interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
