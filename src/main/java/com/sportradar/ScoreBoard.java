package com.sportradar;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A thread safe implementation of a basic scoreboard.
 */
public class ScoreBoard {
    private final SortedSet runningGames = Collections.synchronizedSortedSet(new TreeSet<Game>());

    public ScoreBoard() {}

    /**
     * Creates an entry on the ScoreBoard for a Game of the 2 named teams. The start of the game set to
     * @param hostTeam A name of a host team
     * @param guestTeam A name of the guestTeam
     */
    public void startGame(String hostTeam, String guestTeam) {

    }

    /**
     * Updates a score for a game
     * @param hostTeamScore the score of hosts
     * @param guestTeamScore the score of guests
     */
    public void updateScore (int hostTeamScore, int guestTeamScore) {

    }

    /**
     * Finishes the game of the 2 named teams and removes it from the ScoreBoard
     * @param hostTeam A name of a host team
     * @param guestTeam A name of the guestTeam
     */
    public void finishGame(String hostTeam, String guestTeam) {

    }

    /**
     *
     * @return A set of games sorted by their total score descending. Games with the same score are sorted by their starting time ascending.
     */
    public SortedSet<Game> getGamesSummary() {
        return runningGames;
    }
}
