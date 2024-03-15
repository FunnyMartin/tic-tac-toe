import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private ArrayList<Field> board;
    private int boardSize = 3;
    private boolean player1;

    public Board(ArrayList<Field> board) {
        this.board = board;
        player1 = true;
        initialize();
    }

    public void initialize(){
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                board.add(new Field(i, j));
            }
        }
    }

    public void play(Scanner scan){
        //check na konec hry
        int x, y;
        if(player1){
            while(true){
                //grafika zobrazi pole
                System.out.println("Choose field: x");
                x = scan.nextInt();
                System.out.println("Choose field: y");
                y = scan.nextInt();
                if(checkValidity(x,y)){
                    break;
                } else{
                    System.out.println("Wrong inputs");
                }
            }
            for(int i = 0; i < board.size(); i++){
                if(board.get(i).getX() == x && board.get(i).getY() == y){
                    board.get(i).setX(x);
                    board.get(i).setY(y);
                    board.get(i).setMark(Mark.X);
                    break;
                }
            }
            player1 = false;
        } else{
            //grafika zobrazi pole
            while(true){
                //grafika zobrazi pole
                System.out.println("Choose field: x");
                x = scan.nextInt();
                System.out.println("Choose field: y");
                y = scan.nextInt();
                if(checkValidity(x,y)){
                    break;
                } else{
                    System.out.println("Wrong inputs");
                }
            }
            for(int i = 0; i < board.size(); i++){
                if(board.get(i).getX() == x && board.get(i).getY() == y){
                    board.get(i).setX(x);
                    board.get(i).setY(y);
                    board.get(i).setMark(Mark.O);
                    break;
                }
            }
            player1 = true;
        }
    }

    private boolean checkValidity(int x, int y){
        int numberX = 0, numberY = 0;
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(i == x && j == y){
                    numberX = i;
                    numberY = j;
                }
            }
        }

        for(int i = 0; i < board.size(); i++){
            if (board.get(i).getX() == numberX && board.get(i).getY() == numberY){
                if(board.get(i).getMark().equals(Mark.O) || board.get(i).getMark().equals(Mark.X)){
                    return false;
                } else{
                    return true;
                }
            }
        }
        return false;
    }

}
