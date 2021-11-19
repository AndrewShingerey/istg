package com.istg.service.implementations;

import com.istg.config.AppConfig;
import com.istg.dao.Interface.CheckoutOrderDao;
import com.istg.domain.CheckoutOrder;
import com.istg.domain.User;
import com.istg.service.interfaces.CheckoutOrderService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
public class CheckoutOrderServiceImplTest extends TestCase {

    @Autowired
    private CheckoutOrderService checkoutOrderService;

    @MockBean
    private CheckoutOrderDao checkoutOrderDao;

    @Test
    public void testSave() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.save(checkoutOrder)).thenReturn(1);
        assertEquals(1,checkoutOrderService.save(checkoutOrder));
        verify(checkoutOrderDao,times(1)).save(checkoutOrder);
    }

    @Test
    public void testFailedSave() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setName_client("");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.save(checkoutOrder)).thenReturn(0);
        assertEquals(0,checkoutOrderService.save(checkoutOrder));
        verify(checkoutOrderDao,times(0)).save(checkoutOrder);
    }


    @Test
    public void testGetAll() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.getAll()).thenReturn(Stream.of(checkoutOrder).collect(Collectors.toList()));
        assertEquals(1,checkoutOrderService.getAll().size());
        verify(checkoutOrderDao,times(1)).getAll();
    }

    @Test
    public void testUpdate() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setId_c_or(1L);
        checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.update(checkoutOrder)).thenReturn(1);
        assertEquals(1,checkoutOrderService.update(checkoutOrder));
        verify(checkoutOrderDao,times(1)).update(checkoutOrder);
    }

    @Test
    public void testFailedUpdate() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
         checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.update(checkoutOrder)).thenReturn(0);
        assertEquals(0,checkoutOrderService.update(checkoutOrder));
        verify(checkoutOrderDao,times(0)).update(checkoutOrder);
    }

    @Test
    public void testDelete() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setId_c_or(1L);
        checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.delete(checkoutOrder)).thenReturn(1);
        assertEquals(1,checkoutOrderService.delete(checkoutOrder));
        verify(checkoutOrderDao,times(1)).delete(checkoutOrder);
    }

    @Test
    public void testFailedDelete() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
         checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.delete(checkoutOrder)).thenReturn(0);
        assertEquals(0,checkoutOrderService.delete(checkoutOrder));
        verify(checkoutOrderDao,times(0)).delete(checkoutOrder);
    }

    @Test
    public void testGetById() {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setId_c_or(1L);
        checkoutOrder.setName_client("Test");
        checkoutOrder.setPhone_client("Test");
        when(checkoutOrderDao.getById(1L)).thenReturn(checkoutOrder);
        assertEquals("Test",checkoutOrderService.getById(1L).getName_client());
        verify(checkoutOrderDao,times(1)).getById(1L);
    }
    @Test
    public void testGetByIdFailed() {
        when(checkoutOrderDao.getById(null)).thenReturn(null);
        assertNull(checkoutOrderService.getById(null));
        verify(checkoutOrderDao,times(0)).getById(1L);
    }


    @Test
    public void testTestSave() {
        User user = new User();
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        when(checkoutOrderDao.save(checkoutOrder,user)).thenReturn(1);
        assertEquals(1,checkoutOrderService.save(checkoutOrder,user));
        verify(checkoutOrderDao,times(1)).save(checkoutOrder,user);
    }

    @Test
    public void testTestSaveFailed() {
        when(checkoutOrderDao.save(new CheckoutOrder(),null)).thenReturn(0);
        assertEquals(0,checkoutOrderService.save(new CheckoutOrder(),null));
        verify(checkoutOrderDao,times(0)).save(new CheckoutOrder(),null);
    }
}