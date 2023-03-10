package com.sportradar;

import java.util.Comparator;

/**
 * Comparator used for sorting games in the ScoreBoard summary
 */
public class GameComparator implements Comparator<Game> {
    @Override
    public int compare(Game o1, Game o2) {
        int score = o1.hostTeamScore + o1.guestTeamScore - o2.guestTeamScore - o2.hostTeamScore;
        if (score == 0) {
            return o1.start.compareTo(o2.start);
        } else
            return score;
    }
}
