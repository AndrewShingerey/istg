package com.istg.service.implementations;

import com.istg.config.AppConfig;
import com.istg.dao.Interface.CardProductDao;
import com.istg.dao.Interface.UserDao;
import com.istg.domain.CardProduct;
import com.istg.domain.User;
import com.istg.service.interfaces.CardProductService;
import com.istg.service.interfaces.UserService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
public class CardProductServiceImplTest extends TestCase {

    @Autowired
    private CardProductService cardProductService;

    @MockBean
    private CardProductDao cardProductDao;

    @MockBean
    private UserService userService;

    @Test
    public void testFind_all_by_id_user() {
        when(cardProductService.find_all_by_id_user(1L)).thenReturn(Stream.of(new CardProduct(1L,1L,null)).collect(Collectors.toList()));

        assertEquals(1,cardProductService.find_all_by_id_user(1L).size());

        verify(cardProductDao, times(1)).find_all_by_id_user(1L);

    }

    @Test
    public void testGetAll() {
        when(cardProductService.getAll()).thenReturn(Stream.of(new CardProduct(1L,1L,new Date(new java.util.Date().getTime()))).collect(Collectors.toList()));

        assertEquals(1,cardProductService.getAll().size());

        verify(cardProductDao, times(1)).getAll();

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setId_user(1L);
        user.setName("Tim");
        user.setPassword("Smth");

        CardProduct cardProduct = new CardProduct();
        when(cardProductDao.save(cardProduct,user )).thenReturn(1);
        assertEquals(1,cardProductService.save(cardProduct,user));
        verify(cardProductDao,times(1)).save(cardProduct,user);
    }

    @Test
    public void testFailedSave() {
        CardProduct cardProduct = new CardProduct();
        when(cardProductDao.save(cardProduct,null)).thenReturn(0);
        assertEquals(0,cardProductService.save(cardProduct,null));
        verify(cardProductDao,times(0)).save(cardProduct,null);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setId_user(1L);
        user.setName("Tim");
        user.setPassword("Smth");

        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.delete(cardProduct,user)).thenReturn(1);
        assertEquals(1,cardProductService.delete(cardProduct,user));


        verify(cardProductDao,times(1)).delete(cardProduct,user);
     }
    @Test
    public void testFailedDelete() {
        User user = new User();
        user.setId_user(1L);
        user.setName("Tim");
        user.setPassword("Smth");

        when(cardProductDao.delete(null,user)).thenReturn(0);
        assertEquals(0,cardProductService.delete(null,user));

        verify(cardProductDao,times(0)).delete(null,user);
    }

    @Test
    public void testCreate_card() {
        User user = new User();
        user.setId_user(1L);
        user.setName("Tim");
        user.setPassword("Smth");

        when(cardProductDao.create_card(user)).thenReturn(1);
        assertEquals(1,cardProductService.create_card(user));
        verify(cardProductDao,times(1)).create_card(user);

    }

    @Test
    public void testFailedCreate_card() {
        when(cardProductDao.create_card(null)).thenReturn(0);
        assertEquals(0,cardProductService.create_card(null));
        verify(cardProductDao,times(0)).create_card(null);
    }

    @Test
    public void testCheckExists() {
        when(cardProductDao.checkExists(1L)).thenReturn(true);
        assertTrue(cardProductService.checkExists(1L));
        verify(cardProductDao,times(1)).checkExists(1L);
    }

    @Test
    public void testCheckExistsFailed() {
        when(cardProductDao.checkExists(null)).thenReturn(false);
        assertFalse(cardProductService.checkExists(null));
        verify(cardProductDao,times(0)).checkExists(null);
    }

    @Test
    public void testTestSave() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.save(cardProduct)).thenReturn(1);
        assertEquals(1,cardProductService.save(cardProduct));
        verify(cardProductDao,times(1)).save(cardProduct);
    }

    @Test
    public void testFailedTestSave() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(-1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.save(cardProduct)).thenReturn(0);
        assertEquals(0,cardProductService.save(cardProduct));
        verify(cardProductDao,times(0)).save(cardProduct);
    }

    @Test
    public void testTestGetAll() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(-1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.getAll()).thenReturn(Stream.of(cardProduct).collect(Collectors.toList()));
        assertEquals(1,cardProductService.getAll().size());

        verify(cardProductDao,times(1)).getAll();
    }

    @Test
    public void testUpdate() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.update(cardProduct)).thenReturn(1);
        assertEquals(1,cardProductService.update(cardProduct));

        verify(cardProductDao,times(1)).update(cardProduct);
    }

    @Test
    public void testFailedUpdate() {
        when(cardProductDao.update(null)).thenReturn(0);
        assertEquals(0,cardProductService.update(null));

        verify(cardProductDao,times(0)).update(null);
    }

    @Test
    public void testTestDelete() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(1L);
        cardProduct.setId_game(1L);
        when(cardProductDao.delete(cardProduct)).thenReturn(1);
        assertEquals(1,cardProductService.delete(cardProduct));
        verify(cardProductDao,times(1)).delete(cardProduct);
    }

    @Test
    public void testTestFailedDelete() {
        when(cardProductDao.delete(null)).thenReturn(0);
        assertEquals(0,cardProductService.delete(null));
        verify(cardProductDao,times(0)).delete(null);
    }

    @Test
    public void testGetById() {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(1L);
        cardProduct.setId_game(1L);

        when(cardProductDao.getById(1L)).thenReturn(cardProduct);
        assertEquals(Long.valueOf(1),cardProductService.getById(1L).getId_card());
        verify(cardProductDao,times(1)).getById(1L);
    }
    @Test
    public void testFailedGetById() {
        when(cardProductDao.getById(null)).thenReturn(null);
        assertNull(cardProductService.getById(1L));
        verify(cardProductDao,times(1)).getById(1L);
    }
}