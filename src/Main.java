public class Main {
    public static void main(String[] args) {
        final int MAX_TURNS = 42;

        //initialize players
        HumanPlayer player1 = new HumanPlayer("Habibi", 'R');
        //HumanPlayer player2 = new HumanPlayer("Shawty", 'Y');
        ComputerPlayer player2 = new ComputerPlayer("Shawty", 'Y');

        //initialize board
        Board board = new Board();

        int turn = 1;
        Player currentPlayer = player2;
        boolean winner = false;

        //play a turn
        while (!winner && turn <= MAX_TURNS){
            board.display();

            //switch players
            currentPlayer = currentPlayer == player1 ? player2 : player1;

            //play a turn
            currentPlayer.turn(board);
            
            //determine if there is a winner
            winner = board.isWinner(currentPlayer.boardIcon,board.getGrid());
            if (winner){
                board.display();
                System.out.println(currentPlayer.name + " won");
            }

            turn++;
        }

        if (!winner){
            board.display();
            System.out.println("Tie game");
        }
    }
}