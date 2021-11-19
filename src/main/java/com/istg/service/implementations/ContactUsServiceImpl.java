package com.istg.service.implementations;

import com.istg.dao.Interface.ContactUsDao;
import com.istg.domain.ContactUs;
import com.istg.service.interfaces.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsDao contactUsDao;
    private static final Logger log = Logger.getLogger(String.valueOf(FeedBackServiceImpl.class));

    @Override
    public int save(ContactUs contactUs) {
        if(!contactUs.getName_ct().equals("")&&!contactUs.getSoname_ct().equals("")) {
            log.info("Save contact us " + " " + new Date(new java.util.Date().getTime()));
            contactUs.setDate_add(new Date(new java.util.Date().getTime()));
            return contactUsDao.save(contactUs);
        }else{
            return 0;
        }
    }

    @Override
    public List<ContactUs> getAll() {
        log.info("Get all contact us request "+" "+new Date(new java.util.Date().getTime()));
        return contactUsDao.getAll();
    }

    @Override
    public int update(ContactUs contactUs) {
        if(contactUs!=null) {
            log.info("Update contact us request " + " " + new Date(new java.util.Date().getTime()));
            return contactUsDao.update(contactUs);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(ContactUs contactUs) {
        if(contactUs!=null) {
            log.info("Delete contact us " + " " + new Date(new java.util.Date().getTime()));
            return contactUsDao.delete(contactUs);
        }else{
            return 0;
        }
    }

    @Override
    public ContactUs getById(Long id) {
        if(id!=null) {
            log.info("Get one contact us request " + " " + new Date(new java.util.Date().getTime()));
            return contactUsDao.getById(id);
        }else {
            return null;
        }
    }
}
