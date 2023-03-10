package com.sportradar;

import java.util.Date;

/**
 * A class representing a game on the scoreboard.
 */
public class Game {
    final Date start = new Date();
    final String hostTeam;
    final String guestTeam;
    int hostTeamScore = 0;
    int guestTeamScore = 0;

    /**
     * Captures a time of creation and stores it.
     * @param hostTeam A name of the host team
     * @param guestTeam A name of the guest team
     * @throws NullPointerException when either of the names is null
     */
    public Game(String hostTeam, String guestTeam) {
        if (hostTeam == null || guestTeam == null)
            throw new NullPointerException("Name of the team cannot null!!");
        this.hostTeam = hostTeam;
        this.guestTeam = guestTeam;
    }
}
