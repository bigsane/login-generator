package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {
    private LoginGenerator loginGenerator;
    @Before
    public void setUp() throws Exception {
        String debut[] = new String[]{"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"};
        loginGenerator = new LoginGenerator((new LoginService(debut)));
    }

    @Test
    public void generateLoginForNomAndPrenom() {
        String login = loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertEquals("PDUR",login);
    }
    public void generateLoginForJRAL2(){
        String login = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertEquals("JRAL2",login);
    }
    public void CT2() {
        String s = loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertEquals("JROL1",s);
    }

    @Test
    public void CT3() {
        String s = loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertEquals("PDUR",s);
    }
}