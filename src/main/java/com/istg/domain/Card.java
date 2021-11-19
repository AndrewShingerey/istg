package com.istg.domain;

import java.util.Objects;

public class Card {
    private Long id_card;
    private Long id_user;

    public Card(Long id_card, Long id_user) {
        this.id_card = id_card;
        this.id_user = id_user;
    }

    public Card() {
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id_card, card.id_card) &&
                Objects.equals(id_user, card.id_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_card, id_user);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id_card=" + id_card +
                ", id_user=" + id_user +
                '}';
    }
}
