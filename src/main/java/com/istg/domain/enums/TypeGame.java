package com.istg.domain.enums;

public enum TypeGame {
    ADVENTURE("Adventure",1L),
    ACTION("Action",2L),
    INTELEGENT("Intelegent",3L);

    private final String name_type;
    private final Long id_type;

    TypeGame(String name_type, Long id_type) {
        this.name_type = name_type;
        this.id_type = id_type;
    }

    public String getName_type() {
        return name_type;
    }

    public Long getId_type() {
        return id_type;
    }

    public static String getTypeGameNameById(Long id){
        String typeGame = null;
        if (id == 1L) {
            typeGame= TypeGame.ADVENTURE.getName_type();
        } else if (id == 2L) {
            typeGame= TypeGame.ACTION.getName_type();
        } else if (id == 3L) {
            typeGame= TypeGame.INTELEGENT.getName_type();
        }

        return typeGame;
    }
}
