package com.istg.service.implementations;


import com.istg.config.AppConfig;
import com.istg.dao.Interface.UserDao;
import com.istg.domain.User;
import com.istg.domain.enums.UserRole;
import com.istg.service.interfaces.UserService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void SaveUserTest_withGoodData_True() {
        User temp = new User("Name","name","Soname","Email","123", UserRole.USER);
        temp.setId_user(1L);
        when(userDao.save(temp)).thenReturn(1);
        Assert.assertEquals(1,userService.save(temp));
    }
    @Test
    public void SaveUserTest_withBadData_False() {
        User temp = new User("Name","name","Soname","Email","123", UserRole.USER);
        temp.setId_user(1L);
        when(userDao.save(temp)).thenReturn(0);
        Assert.assertEquals(0,userService.save(new User("Name","name","Soname","Email","123", UserRole.USER)));
    }
    @Test
    public void GetAllUserTest() {
        when(userDao.getAll()).thenReturn(Stream.of(new User("Name","name","Soname","Email","123", UserRole.USER),new User("Name","name","Soname","Email","123", UserRole.USER)).collect(Collectors.toList()));
        Assert.assertEquals(2,userService.getAll().size());
    }

    @Test
    public void UpdateUserTest_withGoodData_True() {
        User update = new User("","name","Soname","Email","123", UserRole.USER);
        update.setId_user(1L);
        when(userDao.update(update)).thenReturn(1);
        Assert.assertEquals(1,userService.update(update));
    }
    @Test
    public void UpdateUserTest_EmptyId_False() {
        when(userDao.update(new User("Name","name","Soname","Email","123", UserRole.USER))).thenReturn(0);
        Assert.assertEquals(0,userService.update(new User("Name","name","Soname","Email","123", UserRole.USER)));
    }
    @Test
    public void DeleteUserTest_WithId1_True() {
        User temp = new User("Name","name","Soname","Email","123", UserRole.USER);
        temp.setId_user(1L);
        when(userDao.delete(temp)).thenReturn(1);
        Assert.assertEquals(1,userService.delete(temp));
    }
    @Test
    public void DeleteUserTest_WithIdNull_False() {
        User temp = new User("Name","name","Soname","Email","123", UserRole.USER);
        when(userDao.delete(temp)).thenReturn(0);
        Assert.assertEquals(0,userService.delete(new User("Name","name","Soname","Email","123", UserRole.USER)));
    }
    @Test
    public void GetUserByidTest_WithId1_True() {
        when(userDao.getById(1L)).thenReturn(new User("Name","name","Soname","Email","123", UserRole.USER));
        Assert.assertEquals("Name",userService.getById(1L).getUsername());
    }
    @Test
    public void GetUserByidTest_WithIdNull_False() {
        when(userDao.getById(null)).thenReturn(null);
        Assert.assertNull(userService.getById(-1L));
    }
    @Test
    public void LoadUserByUsernameTest_WithName_True() {
        when(userDao.getUserByUsername("Name")).thenReturn(new User("Name","name","Soname","Email","123", UserRole.USER));
        Assert.assertEquals("Name",userService.loadUserByUsername("Name").getUsername());
    }
}