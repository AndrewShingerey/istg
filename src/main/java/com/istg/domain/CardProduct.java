package com.istg.domain;
import java.util.*;
public class CardProduct {
    private Long id_card;
    private Long id_game;
    private Date date_add;

    public CardProduct() {
    }

    public CardProduct(Long id_card, Long id_game, Date date_add) {
        this.id_card = id_card;
        this.id_game = id_game;
        this.date_add = date_add;
    }

    public Long getId_card() {
        return id_card;
    }

    public void setId_card(Long id_card) {
        this.id_card = id_card;
    }

    public Long getId_game() {
        return id_game;
    }

    public void setId_game(Long id_game) {
        this.id_game = id_game;
    }

    public Date getDate_add() {
        return date_add;
    }

    public void setDate_add(Date date_add) {
        this.date_add = date_add;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardProduct that = (CardProduct) o;
        return id_card.equals(that.id_card) &&
                id_game.equals(that.id_game) &&
                date_add.equals(that.date_add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_card, id_game, date_add);
    }

    @Override
    public String toString() {
        return "CardProduct{" +
                "id_card=" + id_card +
                ", id_game=" + id_game +
                ", date_add=" + date_add +
                '}';
    }
}
