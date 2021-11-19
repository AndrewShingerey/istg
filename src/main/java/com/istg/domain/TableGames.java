package com.istg.domain;

import java.util.Objects;

public class TableGames {

    private Long id_game;
    private String name_game;
    private String describe_game;
    private String filename_photo_game;
    private Integer price;
    private Long type_id;

    public TableGames() {
    }

    public TableGames(String name_game, String describe_game, String filename_photo_game, Integer price, Long type_id) {
        this.name_game = name_game;
        this.describe_game = describe_game;
        this.filename_photo_game = filename_photo_game;
        this.price = price;
        this.type_id = type_id;
    }

    public Long getId_game() {
        return id_game;
    }

    public void setId_game(Long id_game) {
        this.id_game = id_game;
    }

    public String getName_game() {
        return name_game;
    }

    public void setName_game(String name_game) {
        this.name_game = name_game;
    }

    public String getDescribe_game() {
        return describe_game;
    }

    public void setDescribe_game(String describe_game) {
        this.describe_game = describe_game;
    }

    public String getFilename_photo_game() {
        return filename_photo_game;
    }

    public void setFilename_photo_game(String filename_photo_game) {
        this.filename_photo_game = filename_photo_game;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableGames that = (TableGames) o;
        return Objects.equals(id_game, that.id_game) &&
                Objects.equals(name_game, that.name_game) &&
                Objects.equals(describe_game, that.describe_game) &&
                Objects.equals(filename_photo_game, that.filename_photo_game) &&
                Objects.equals(price, that.price) &&
                Objects.equals(type_id, that.type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_game, name_game, describe_game, filename_photo_game, price, type_id);
    }

    @Override
    public String toString() {
        return "TableGames{" +
                "id_game=" + id_game +
                ", name_game='" + name_game + '\'' +
                ", describe_game='" + describe_game + '\'' +
                ", filename_photo_game='" + filename_photo_game + '\'' +
                ", price=" + price +
                ", type_id=" + type_id +
                '}';
    }
}
