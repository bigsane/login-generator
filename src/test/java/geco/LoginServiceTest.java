package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {
    String  loginList[]={"test","a","b"};
    String emptyLoginList[]={};
    String login = "test";
    String login2 = "test2";
    LoginService loginService,emptyloginService ;

    @Before
    public void setUp() throws Exception {
        loginService= new LoginService(loginList);
        emptyloginService= new LoginService(emptyLoginList);
    }

    @Test
    public void loginExists() {
        assertTrue(loginService.loginExists(login));
        assertFalse(loginService.loginExists(login2));
    }

    @Test
    public void addLogin() {
        emptyloginService.addLogin("testlogin2");
        assertTrue(emptyloginService.findAllLogins().size()==1);
        assertTrue(emptyloginService.loginExists("testlogin2"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        String pref = "te";
        assertTrue(loginService.findAllLoginsStartingWith(pref).size()==1);
        assertTrue(emptyloginService.findAllLoginsStartingWith(pref).size()==0);

    }

    @Test
    public void findAllLogins() {
        assertEquals(loginService.findAllLogins().size(),loginList.length);
    }
}