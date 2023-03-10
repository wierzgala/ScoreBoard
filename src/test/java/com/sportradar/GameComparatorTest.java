package com.sportradar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class GameComparatorTest {

    @Test
    public void testCompare() {
        GameComparator comp = new GameComparator();
        Game g1 = new Game("a", "b", new Date(1000));
        Game g2 = new Game ("c", "d", new Date(2000));

        Assert.assertTrue(comp.compare(g1, g2) < 0);
        Assert.assertTrue(comp.compare(g1, g2) == -comp.reversed().compare(g1, g2));

        g1.guestTeamScore = 5;
        g1.hostTeamScore = 3;
        g2.guestTeamScore = 2;
        g2.hostTeamScore = 1;

        Assert.assertTrue(comp.compare(g1, g2) > 0);
        Assert.assertTrue(comp.compare(g1, g2) == -comp.reversed().compare(g1, g2));

        g2 = new Game ("c", "d", new Date(1000));

        Assert.assertTrue(comp.compare(g1, g2) > 0);
        Assert.assertTrue(comp.compare(g1, g2) == -comp.reversed().compare(g1, g2));

        g2.guestTeamScore = 5;
        g2.hostTeamScore = 3;
        Assert.assertTrue(comp.compare(g1, g2) == 0);


    }
}
