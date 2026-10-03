package com.CashCard.repository;

import com.CashCard.model.CashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CashCardRepository extends JpaRepository<CashCard, Long> {
}

