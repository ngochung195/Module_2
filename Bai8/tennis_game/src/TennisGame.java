public class TennisGame {

    private static final int LOVE = 0;
    private static final int FIFTEEN = 1;
    private static final int THIRTY = 2;
    private static final int FORTY = 3;

    public static String getScore(int player1Score, int player2Score) {

        if (isEqualScore(player1Score, player2Score)) {
            return getEqualScore(player1Score);
        }

        if (isEndGame(player1Score, player2Score)) {
            return getEndGameScore(player1Score, player2Score);
        }

        return getNormalScore(player1Score, player2Score);
    }

    private static boolean isEqualScore(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

    private static boolean isEndGame(int player1Score, int player2Score) {
        return player1Score >= FORTY + 1 || player2Score >= FORTY + 1;
    }

    private static String getEqualScore(int score) {
        switch (score) {
            case LOVE:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private static String getEndGameScore(int player1Score, int player2Score) {

        int scoreDifference = player1Score - player2Score;

        if (scoreDifference == 1) {
            return "Advantage player1";
        }

        if (scoreDifference == -1) {
            return "Advantage player2";
        }

        if (scoreDifference >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

    private static String getNormalScore(int player1Score, int player2Score) {
        return convertScore(player1Score) + "-" + convertScore(player2Score);
    }

    private static String convertScore(int score) {
        switch (score) {
            case LOVE:
                return "Love";
            case FIFTEEN:
                return "Fifteen";
            case THIRTY:
                return "Thirty";
            case FORTY:
                return "Forty";
            default:
                return "";
        }
    }
}