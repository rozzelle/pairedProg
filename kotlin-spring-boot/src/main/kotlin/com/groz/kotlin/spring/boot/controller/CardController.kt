package com.groz.kotlin.spring.boot.controller

import com.groz.kotlin.spring.boot.entity.Card
import com.groz.kotlin.spring.boot.repository.CardRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/cards")
class CardController(private val cardRepository: CardRepository) {

    @GetMapping()
    fun getAllArticles(): List<Card> =
            cardRepository.findAll()


    @PostMapping()
    fun createNewCard(@Valid @RequestBody card: Card): Card =
            cardRepository.save(card)


    @GetMapping("/{id}")
    fun getCardsById(@PathVariable(value = "id") cardId: Long): ResponseEntity<Card> {
        return cardRepository.findById(cardId).map { card ->
            ResponseEntity.ok(card)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateCardsById(@PathVariable(value = "id") cardId: Long,
                          @Valid @RequestBody newCard: Card): ResponseEntity<Card> {
        return cardRepository.findById(cardId).map { existingArticle ->
            val updatedArticle: Card = existingArticle
                    .copy(suit = newCard.suit, name = newCard.name)

            ResponseEntity.ok().body(cardRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/{id}")
    fun deleteCardById(@PathVariable(value = "id") cardId: Long): ResponseEntity<Void> {
        return cardRepository.findById(cardId).map { card  ->
            cardRepository.delete(card)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}