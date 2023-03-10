package com.sportradar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class GameTest {
    private static final String Mexico = "Mexico";
    private static final String Canada = "Canada";
    private static final String Spain = "Spain";
    private static final String Brazil = "Brazil";
    private static final String Germany = "Germany";
    private static final String France = "France";
    private static final String Uruguay = "Uruguay";
    private static final String Italy = "Italy";
    private static final String Argentina = "Argentina";
    private static final String Australia = "Australia";

    @Test
    public void testCreateUpdateAndFinish() {
        ScoreBoard sb = new ScoreBoard();
        sb.startGame(Mexico, Argentina);
        sb.updateScore(Mexico, 0, Argentina, 1);

        Iterator<Game> gamesIterator = sb.getGamesSummary().iterator();
        Game g = gamesIterator.next();

        Assert.assertTrue(Mexico.equals(g.hostTeam) && Argentina.equals(g.guestTeam)
                && g.hostTeamScore == 0 && g.guestTeamScore == 1);

        sb.finishGame(Mexico, Argentina);

        Assert.assertEquals(0, sb.getGamesSummary().size());
    }

    @Test (expected = NullPointerException.class)
    public void testNullHostName () {
        ScoreBoard sb = new ScoreBoard();
        sb.startGame(null, Argentina);
    }

    @Test (expected = NullPointerException.class)
    public void testNullGuestName () {
        ScoreBoard sb = new ScoreBoard();
        sb.startGame(Argentina, null);
    }

    @Test
    public void testInstructionScenario() {
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.startGame(Mexico, Canada);
        scoreBoard.startGame(Spain, Brazil);
        scoreBoard.startGame(Germany, France);
        scoreBoard.startGame(Uruguay, Italy);
        scoreBoard.startGame(Argentina, Australia);

        scoreBoard.updateScore(Mexico, 0, Canada, 5);
        scoreBoard.updateScore(Spain, 10, Brazil, 2);
        scoreBoard.updateScore(Germany, 2, France, 2);
        scoreBoard.updateScore(Uruguay, 6, Italy, 6);
        scoreBoard.updateScore(Argentina, 3, Australia, 1);

        Iterator<Game> gamesIterator = scoreBoard.getGamesSummary().iterator();

        Game g = gamesIterator.next();
        Assert.assertTrue(Uruguay.equals(g.hostTeam) && Italy.equals(g.guestTeam)
                && g.hostTeamScore == 6 && g.guestTeamScore == 6);

        g = gamesIterator.next();
        Assert.assertTrue(Spain.equals(g.hostTeam) && Brazil.equals(g.guestTeam)
                && g.hostTeamScore == 10 && g.guestTeamScore == 2);

        g = gamesIterator.next();
        Assert.assertTrue(Mexico.equals(g.hostTeam) && Canada.equals(g.guestTeam)
                && g.hostTeamScore == 0 && g.guestTeamScore == 5);

        g = gamesIterator.next();
        Assert.assertTrue(Argentina.equals(g.hostTeam) && Australia.equals(g.guestTeam)
                && g.hostTeamScore == 3 && g.guestTeamScore == 1);

        g = gamesIterator.next();
        Assert.assertTrue(Germany.equals(g.hostTeam) && France.equals(g.guestTeam)
                && g.hostTeamScore == 2 && g.guestTeamScore == 2);
    }
}
