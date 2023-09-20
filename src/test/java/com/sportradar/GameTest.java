package com.sportradar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class GameTest {
    private static final String Mexico = "Mexico";
    private static final String Canada = "Canada";
    private static final String Spain = "Spain";

    @Test
    public void testGetters() {
        Date d = new Date();
        Game g = new Game(Mexico, Canada, d);

        Assert.assertEquals(g.getHostTeam(), Mexico);
        Assert.assertEquals(g.getGuestTeam(), Canada);
        Assert.assertEquals(g.getStart(), d);
        Assert.assertEquals(g.getGuestTeamScore(), 0);
        Assert.assertEquals(g.getHostTeamScore(), 0);
    }
    @Test
    public void testEquals() {
        Date d1 = new Date(10000);
        Game g1 = new Game(Mexico, Canada, d1);
        Game g2 = new Game(Mexico, Canada, d1);
        Assert.assertFalse(g1.equals(null));
        Assert.assertFalse(g1.equals(d1));
        Assert.assertTrue(g1.equals(g1));
        Assert.assertTrue(g1.equals(g2));

        Date d2 = new Date(20000);
        g2 = new Game(Mexico, Canada, d2);
        Assert.assertTrue(g1.equals(g2));

        g2 = new Game(Mexico, Spain, d1);
        Assert.assertFalse(g1.equals(g2));

        g2 = new Game(Spain, Canada, d1);
        Assert.assertFalse(g1.equals(g2));
    }
}
