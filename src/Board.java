import java.util.ArrayList;

public class Board {
    private ArrayList<Field> board;
    private int boardSize = 3;

    public Board(ArrayList<Field> board) {
        this.board = board;
        initialize();
    }

    public void initialize(){
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board.add(new Field(i, j));
            }
        }
    }


}
