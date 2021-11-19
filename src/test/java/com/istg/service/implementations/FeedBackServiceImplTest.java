package com.istg.service.implementations;

import com.istg.config.AppConfig;
import com.istg.dao.Interface.FeedBackDao;
import com.istg.domain.FeedBack;
import com.istg.service.interfaces.FeedBackService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
public class FeedBackServiceImplTest extends TestCase {

    @Autowired
    private FeedBackService feedBackService;

    @MockBean
    private FeedBackDao feedBackDao;


    @Test
    public void testSave() {
        FeedBack feedBack = new FeedBack();
        feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");

        when(feedBackDao.save(feedBack)).thenReturn(1);
        assertEquals(1,feedBackService.save(feedBack));
        verify(feedBackDao,times(1)).save(feedBack);
    }

    @Test
    public void testSaveFailed() {
        FeedBack feedBack = new FeedBack();
        feedBack.setName_client("");
        feedBack.setSoname_client("Tim");

        when(feedBackDao.save(feedBack)).thenReturn(0);
        assertEquals(0,feedBackService.save(feedBack));
        verify(feedBackDao,times(0)).save(feedBack);
    }

    @Test
    public void testGetAll() {
        FeedBack feedBack = new FeedBack();
        feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");

        when(feedBackDao.getAll()).thenReturn(Stream.of(feedBack).collect(Collectors.toList()));
        assertEquals(1,feedBackService.getAll().size());
        verify(feedBackDao,times(1)).getAll();
    }

    @Test
    public void testUpdate() {
        FeedBack feedBack = new FeedBack();
        feedBack.setId_feedback(1L);
        feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");

        when(feedBackDao.update(feedBack)).thenReturn(1);
        assertEquals(1,feedBackService.update(feedBack));
        verify(feedBackDao,times(1)).update(feedBack);
    }

    @Test
    public void testUpdateFailed() {
        FeedBack feedBack = new FeedBack();
         feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");

        when(feedBackDao.update(feedBack)).thenReturn(0);
        assertEquals(0,feedBackService.update(feedBack));
        verify(feedBackDao,times(0)).update(feedBack);
    }

    @Test
    public void testDelete() {
        FeedBack feedBack = new FeedBack();
        feedBack.setId_feedback(1L);
        feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");
        when(feedBackDao.delete(feedBack)).thenReturn(1);
        assertEquals(1,feedBackService.delete(feedBack));
        verify(feedBackDao,times(1)).delete(feedBack);
    }


    @Test
    public void testDeleteFailed() {
        when(feedBackDao.delete(null)).thenReturn(0);
        assertEquals(0,feedBackService.delete(null));
        verify(feedBackDao,times(0)).delete(null);
    }

    @Test
    public void testGetById() {
        FeedBack feedBack = new FeedBack();
        feedBack.setId_feedback(1L);
        feedBack.setName_client("Tim");
        feedBack.setSoname_client("Tim");
        when(feedBackDao.getById(1L)).thenReturn(feedBack);
        assertEquals("Tim",feedBackService.getById(1L).getName_client());
        verify(feedBackDao,times(1)).getById(1L);
    }

    @Test
    public void testGetByIdFailed() {
        when(feedBackDao.getById(null)).thenReturn(null);
        assertNull(feedBackService.getById(null));
        verify(feedBackDao,times(0)).getById(null);
    }
}