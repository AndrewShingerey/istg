package com.istg.service.implementations;

import com.istg.dao.Interface.FeedBackDao;
import com.istg.dao.implementations.FeedBackDaoImpl;
import com.istg.domain.FeedBack;
import com.istg.service.interfaces.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackDao feedBackDao;

    private static final Logger log = Logger.getLogger(String.valueOf(FeedBackServiceImpl.class));
    //539572

    @Override
    public int save(FeedBack feedBack) {
        if(!feedBack.getName_client().equals("")&&!feedBack.getSoname_client().equals("")) {
            log.info("Save feed back");
            return feedBackDao.save(feedBack);
        }else{
            return 0;
        }
    }

    @Override
    public List<FeedBack> getAll() {
        log.info("Get all feed back");
        return feedBackDao.getAll();
    }

    @Override
    public int update(FeedBack feedBack) {
        if(feedBack.getId_feedback()!=null) {
            log.info("Update feed back");
            return feedBackDao.update(feedBack);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(FeedBack feedBack) {
        if(feedBack!=null) {
            log.info("Delete feed back");
            return feedBackDao.delete(feedBack);
        }else{
            return 0;
        }
    }

    @Override
    public FeedBack getById(Long id) {
        if(id!=null) {
            log.info("Get feed back by id");
            return feedBackDao.getById(id);
        }else{
            return null;
        }
    }
}
