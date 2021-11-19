package com.istg.dao.Mappers;

 import com.istg.domain.ContactUs;
 import org.springframework.jdbc.core.RowMapper;

 import java.sql.ResultSet;
 import java.sql.SQLException;

public class ContactUsMapper implements RowMapper<ContactUs> {
    @Override
    public ContactUs mapRow(ResultSet resultSet, int i) throws SQLException {
        ContactUs contactUs = new ContactUs();
        contactUs.setId_ct(resultSet.getLong("id_ct"));
        contactUs.setName_ct(resultSet.getString("name_ct"));
        contactUs.setSoname_ct(resultSet.getString("soname_ct"));
        contactUs.setEmail_ct(resultSet.getString("email_ct"));
        contactUs.setPhone_ct(resultSet.getString("phone_ct"));
        contactUs.setDate_add(resultSet.getDate("date_send"));
        return contactUs;
    }
}
