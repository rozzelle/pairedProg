package com.groz.kotlin.spring.boot.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.groz.kotlin.spring.boot.entity.Card

@Repository
interface CardRepository : JpaRepository<Card, Long>