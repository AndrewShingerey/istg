package com.istg.domain;

import java.util.Date;
import java.util.Objects;

public class CheckoutOrder {
    private Long id_c_or;
    private Long id_card_pr;
    private String name_client;
    private String soname_client;
    private String email_client;
    private String phone_client;
    private Integer summa_order;
    private Date date_order;

    public CheckoutOrder() {
    }

    public CheckoutOrder(Long id_c_or, Long id_card_pr, String name_client, String soname_client,
                         String email_client, String phone_client, Integer summa_order, Date date_order) {
        this.id_c_or = id_c_or;
        this.id_card_pr = id_card_pr;
        this.name_client = name_client;
        this.soname_client = soname_client;
        this.email_client = email_client;
        this.phone_client = phone_client;
        this.summa_order = summa_order;
        this.date_order = date_order;
    }

    public Long getId_c_or() {
        return id_c_or;
    }

    public void setId_c_or(Long id_c_or) {
        this.id_c_or = id_c_or;
    }

    public Long getId_card_pr() {
        return id_card_pr;
    }

    public void setId_card_pr(Long id_card_pr) {
        this.id_card_pr = id_card_pr;
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

    public String getPhone_client() {
        return phone_client;
    }

    public void setPhone_client(String phone_client) {
        this.phone_client = phone_client;
    }

    public Integer getSumma_order() {
        return summa_order;
    }

    public void setSumma_order(Integer summa_order) {
        this.summa_order = summa_order;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutOrder that = (CheckoutOrder) o;
        return Objects.equals(id_c_or, that.id_c_or) &&
                Objects.equals(id_card_pr, that.id_card_pr) &&
                Objects.equals(name_client, that.name_client) &&
                Objects.equals(soname_client, that.soname_client) &&
                Objects.equals(email_client, that.email_client) &&
                Objects.equals(phone_client, that.phone_client) &&
                Objects.equals(summa_order, that.summa_order) &&
                Objects.equals(date_order, that.date_order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_c_or, id_card_pr, name_client, soname_client, email_client, phone_client, summa_order, date_order);
    }

    @Override
    public String toString() {
        return "CheckoutOrder{" +
                "id_c_or=" + id_c_or +
                ", id_card_pr=" + id_card_pr +
                ", name_client='" + name_client + '\'' +
                ", soname_client='" + soname_client + '\'' +
                ", email_client='" + email_client + '\'' +
                ", phone_client='" + phone_client + '\'' +
                ", summa_order=" + summa_order +
                ", date_order=" + date_order +
                '}';
    }
}
