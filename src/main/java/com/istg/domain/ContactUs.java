package com.istg.domain;

import java.sql.Date;
import java.util.Objects;

public class ContactUs {

    private Long id_ct;
    private String name_ct;
    private String soname_ct;
    private String email_ct;
    private String phone_ct;
    private Date date_add;

    public ContactUs() {
    }

    public ContactUs(Long id_ct, String name_ct, String soname_ct, String email_ct, String phone_ct, Date date_add) {
        this.id_ct = id_ct;
        this.name_ct = name_ct;
        this.soname_ct = soname_ct;
        this.email_ct = email_ct;
        this.phone_ct = phone_ct;
        this.date_add = date_add;
    }

    public Long getId_ct() {
        return id_ct;
    }

    public void setId_ct(Long id_ct) {
        this.id_ct = id_ct;
    }

    public String getName_ct() {
        return name_ct;
    }

    public void setName_ct(String name_ct) {
        this.name_ct = name_ct;
    }

    public String getSoname_ct() {
        return soname_ct;
    }

    public void setSoname_ct(String soname_ct) {
        this.soname_ct = soname_ct;
    }

    public String getEmail_ct() {
        return email_ct;
    }

    public void setEmail_ct(String email_ct) {
        this.email_ct = email_ct;
    }

    public String getPhone_ct() {
        return phone_ct;
    }

    public void setPhone_ct(String phone_ct) {
        this.phone_ct = phone_ct;
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
        ContactUs contactUs = (ContactUs) o;
        return Objects.equals(id_ct, contactUs.id_ct) &&
                Objects.equals(name_ct, contactUs.name_ct) &&
                Objects.equals(soname_ct, contactUs.soname_ct) &&
                Objects.equals(email_ct, contactUs.email_ct) &&
                Objects.equals(phone_ct, contactUs.phone_ct) &&
                Objects.equals(date_add, contactUs.date_add);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ct, name_ct, soname_ct, email_ct, phone_ct, date_add);
    }

    @Override
    public String toString() {
        return "ContactUs{" +
                "id_ct=" + id_ct +
                ", name_ct='" + name_ct + '\'' +
                ", soname_ct='" + soname_ct + '\'' +
                ", email_ct='" + email_ct + '\'' +
                ", phone_ct='" + phone_ct + '\'' +
                ", date_add=" + date_add +
                '}';
    }
}
