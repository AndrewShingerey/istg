package com.istg.domain;

import java.util.Objects;

public class FeedBack {
    private Long id_feedback;
    private Long id_tb_game;
    private String name_client;
    private String soname_client;
    private String email_client;
    private Integer mark;

    public FeedBack() {
    }

    public FeedBack(Long id_tb_game, String name_client, String soname_client, String email_client, Integer mark) {
        this.id_tb_game = id_tb_game;
        this.name_client = name_client;
        this.soname_client = soname_client;
        this.email_client = email_client;
        this.mark = mark;
    }

    public Long getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(Long id_feedback) {
        this.id_feedback = id_feedback;
    }

    public Long getId_tb_game() {
        return id_tb_game;
    }

    public void setId_tb_game(Long id_tb_game) {
        this.id_tb_game = id_tb_game;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getSoname_client() {
        return soname_client;
    }

    public void setSoname_client(String soname_client) {
        this.soname_client = soname_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedBack feedBack = (FeedBack) o;
        return Objects.equals(id_feedback, feedBack.id_feedback) &&
                Objects.equals(id_tb_game, feedBack.id_tb_game) &&
                Objects.equals(name_client, feedBack.name_client) &&
                Objects.equals(soname_client, feedBack.soname_client) &&
                Objects.equals(email_client, feedBack.email_client) &&
                Objects.equals(mark, feedBack.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_feedback, id_tb_game, name_client, soname_client, email_client, mark);
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id_feedback=" + id_feedback +
                ", id_tb_game=" + id_tb_game +
                ", name_client='" + name_client + '\'' +
                ", soname_client='" + soname_client + '\'' +
                ", email_client='" + email_client + '\'' +
                ", mark=" + mark +
                '}';
    }
}
