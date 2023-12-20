import java.util.Scanner;

public abstract class Player {
    String name;
    char boardIcon;

    public Player(String name, char boardIcon) {
        this.name = name;
        this.boardIcon = boardIcon;
    }

    public void turn(Board board) {
    }
}

class HumanPlayer extends Player {
    public HumanPlayer(String name, char boardIcon) {
        super(name, boardIcon);
    }
    public void turn(Board board) {
        Scanner in = new Scanner(System.in);
        boolean validPlay;
        int play;
        do {
            System.out.print("Player " + this.name + ", choose a column: ");
            play = in.nextInt();

            //validate play
            validPlay = board.validate(play);

        }while (!validPlay);

        //drop the checker
        board.dropChecker(play, this.boardIcon);
    }
}

class ComputerPlayer extends Player {
    public ComputerPlayer(String name, char boardIcon) {
        super(name, boardIcon);
    }

    public void turn(Board board) {
        boolean validPlay;
        int play;
        do {
            play = (int) Math.floor(Math.random() * 7);

            //validate play
            validPlay = board.validate(play);

        }while (!validPlay);

        //drop the checker
        board.dropChecker(play, this.boardIcon);
    }
}


