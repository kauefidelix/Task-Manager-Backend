package com.taskmanager.backend.controller;

import com.taskmanager.backend.model.Card;
import com.taskmanager.backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/")
    public Map<String, Object> index() {
        List<Card> cards = cardService.getAllCards();
        LocalDate today = LocalDate.now();
        Map<String, Object> map = new HashMap<>();
        map.put("cards", cards);
        map.put("today", today);
        return map;
    }

    @GetMapping("/cards/{cardId}")
    public Card cardDetail(@PathVariable("cardId") UUID cardId) {
        return cardService.getCard(cardId);
    }

    @PutMapping("/cards/{cardId}/update_column/{newColumn}")
    public Map<String, String> updateCardColumn(@PathVariable("cardId") UUID cardId, @PathVariable("newColumn") String newColumn) {
        Card card = cardService.updateCardColumn(String.valueOf(cardId), newColumn);
        Map<String, String> map = new HashMap<>();
        map.put("column", card.getColumn());
        return map;
    }

    @PostMapping("/cards/{cardId}/saveCardInfo")
    public Map<String, String> saveCardInfo(@RequestBody Map<String, String> request, @PathVariable("cardId") UUID cardId) {
        Card card = cardService.updateCard(cardId, request.get("name"), request.get("content"), request.get("column"));
        Map<String, String> map = new HashMap<>();
        map.put("name", card.getName());
        map.put("content", card.getContent());
        map.put("column", card.getColumn());
        return map;
    }

    @PostMapping("/cards/create")
    public ResponseEntity<Void> createCard(@RequestBody Map<String, String> request) {
        cardService.createCard(request.get("name"), request.get("column"), request.get("content"), LocalDate.parse(request.get("creation_date")));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cards/{cardId}/delete")
    public ResponseEntity<Void> deleteCard(@PathVariable("cardId") UUID cardId) {
        cardService.deleteCard(String.valueOf(cardId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/cards")
    public Map<String, Object> cards() {
        List<Card> cards = cardService.getAllCards();
        LocalDate today = LocalDate.now();
        Map<String, Object> map = new HashMap<>();
        map.put("cards", cards);
        map.put("today", today);
        return map;
    }
}

