package com.sportradar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

/**
 * A thread safe implementation of a basic scoreboard.
 */
public class ScoreBoard {
    private final Set<Game> runningGames = Collections.synchronizedSet(new HashSet<>());

    public ScoreBoard() {}

    /**
     * Creates an entry on the ScoreBoard for a Game of the 2 named teams. The start of the game set to
     * @param hostTeam A name of a host team
     * @param guestTeam A name of the guestTeam
     * @throws NullPointerException when either of the names is null
     * @return true if game was successfully added to ScoreBoard. False otherwise (e.g. such game already exists)
     */
    public boolean startGame(String hostTeam, String guestTeam) {
        return runningGames.add(new Game(hostTeam, guestTeam, null));
    }

    /**
     * Updates a score for a game
     * @param hostTeam A name of a host team
     * @param hostTeamScore the score of hostT
     * @param guestTeam A name of the guestTeam
     * @param guestTeamScore the score of guests
     * @return true if the game was successfully updated
     *         false if the game wasn't found
     */
    public boolean updateScore (String hostTeam, int hostTeamScore,
                             String guestTeam, int guestTeamScore) {
        Iterator<Game> it = runningGames.stream().
                filter(g -> g.hostTeam.equals(hostTeam)).
                filter(g -> g.guestTeam.equals(guestTeam)).
                iterator();
        if (it.hasNext()) {
            Game g = it.next();
            synchronized (g) {
                g.hostTeamScore = hostTeamScore;
                g.guestTeamScore = guestTeamScore;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finishes the game of the 2 named teams and removes it from the ScoreBoard
     * @param hostTeam A name of a host team
     * @param guestTeam A name of the guestTeam
     * @return true if the game was present on the ScoreBoard
     */
    public boolean finishGame(String hostTeam, String guestTeam) {
        return runningGames.remove(new Game(hostTeam, guestTeam, null));
    }

    /**
     *
     * @return A set of games sorted by their total score descending.
     * Games with the same score are sorted by their starting time descending (newest first).
     */
    public List<Game> getGamesSummary() {
        return runningGames.stream().sorted(new GameComparator().reversed()).toList();
    }
}
