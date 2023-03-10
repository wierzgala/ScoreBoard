package com.sportradar;

import java.util.Date;
import java.util.Objects;

/**
 * A class representing a game on the ScoreBoard.
 */
public class Game {
    final Date start;
    final String hostTeam;
    final String guestTeam;
    int hostTeamScore = 0;
    int guestTeamScore = 0;

    /**
     * Captures a time of creation and stores it.
     * @param hostTeam A name of the host team
     * @param guestTeam A name of the guest team
     * @param start A start time of the game. Set to new Date() if null.
     * @throws NullPointerException when either of the names is null
     */
    public Game(String hostTeam, String guestTeam, Date start) {
        if (hostTeam == null || guestTeam == null)
            throw new NullPointerException("Name of the team cannot null!!");
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
        this.start = Objects.requireNonNullElseGet(start, Date::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return hostTeam.equals(game.hostTeam) &&
                guestTeam.equals(game.guestTeam);
    }
    @Override
    public int hashCode() {
        return Objects.hash(hostTeam, guestTeam);
    }
}
