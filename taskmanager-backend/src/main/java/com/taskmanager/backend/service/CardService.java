package com.taskmanager.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.taskmanager.backend.model.Card;
import com.taskmanager.backend.repository.CardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(String cardId) {
        return cardRepository.findById(UUID.fromString(cardId));
    }

    public Card updateCardColumn(String cardId, String newColumn) {
        Optional<Card> cardOptional = cardRepository.findById(UUID.fromString(cardId));
        if (cardOptional.isEmpty()) {
            return null;
        }
        Card card = cardOptional.get();
        card.setColumn(newColumn);
        return cardRepository.save(card);
    }

    public Card saveCardInfo(String cardId, String name, String content, String column) {
        Optional<Card> cardOptional = cardRepository.findById(UUID.fromString(cardId));
        if (cardOptional.isEmpty()) {
            return null;
        }
        Card card = cardOptional.get();
        card.setName(name);
        card.setContent(content);
        card.setColumn(column);
        return cardRepository.save(card);
    }

    public void createCard(String name, String column, String content, LocalDate creationDate) {
        Card card = new Card();
        card.setName(name);
        card.setContent(content);
        card.setColumn(column);
        card.setCreationDate(String.valueOf(creationDate));
        card.setLastModified(String.valueOf(LocalDate.now()));
        cardRepository.save(card);
    }

    public void deleteCard(String cardId) {
        cardRepository.deleteById(UUID.fromString(cardId));
    }


    public Card getCard(UUID cardId) {
        Card[] cards = new Card[0];
        for (Card card : cards) {
            if (card.getId().equals(cardId)) {
                return card;
            }
        }
        return null;
    }

    public Card updateCard(UUID cardId, String name, String content, String column) {
        Card[] cards = new Card[0];
        for (Card card : cards) {
            if (card.getId().equals(cardId)) {
                card.setName(name);
                card.setContent(content);
                card.setColumn(column);
                return card;
            }
        }
        return null;
    }

}
