package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Steven L.", Developer.getName());
    }


    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("stevenliu2002", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-07", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Annika D."),"Team should contain Annika D.");
        assertTrue(t.getMembers().contains("Forrest Z."),"Team should contain Forrest Z.");
        assertTrue(t.getMembers().contains("Steven L."),"Team should contain Steven L.");
        assertTrue(t.getMembers().contains("Hannya Y."),"Team should contain Hannya Y.");
        assertTrue(t.getMembers().contains("Hannah Z."),"Team should contain Hannah Z.");
        assertTrue(t.getMembers().contains("Shelly Z."),"Team should contain Shelly Z.");
    }

}
