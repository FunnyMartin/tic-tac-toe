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
    public void draw(){
        String completeBoard="";
        for (int i = 0; i < boardSize; i++){
            String rowDrawer ="\n" + " " + "|" + " " + "|" +" ";
            completeBoard=completeBoard+rowDrawer+"\n"+"______";
        }
        System.out.println(completeBoard);
    }


    public void refresh(){
        String completeBoard="";
        for (int i = 0; i < boardSize; i++){
            completeBoard=completeBoard+"\n"+"---------------"+"\n"+" | ";
            for (int j = 0; j < boardSize; j++){
                completeBoard=completeBoard+board.get(j).getX()+" | ";
            }
        }
        System.out.println(completeBoard);
    }

    public void play(Scanner scan){
        int x, y;
        if(player1){
            while(true){
                refresh();
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
            while(true){
                refresh();
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
                if(board.get(i).getMark() == Mark.O || board.get(i).getMark() == Mark.X){
                    return false;
                } else{
                    return true;
                }
            }
        }
        return false;
    }

    //0 = null, 1 = X, 2 = O
    public boolean checkEnding(){
        boolean win = false;
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < boardSize*boardSize; i++){
            if(board.get(i).getMark()==(null)){
                array.add(0);
            } else if(board.get(i).getMark().equals(Mark.X)){
                array.add(1);
            } else if(board.get(i).getMark().equals(Mark.O)){
                array.add(2);
            }
        }

        if(array.get(0) == 1 && array.get(1) == 1 && array.get(2) == 1){
            win = true;
        } else if(array.get(3) == 1 && array.get(4) == 1 && array.get(5) == 1){
            win = true;
        } else if(array.get(6) == 1 && array.get(7) == 1 && array.get(8) == 1){
            win = true;
        } else if(array.get(0) == 1 && array.get(3) == 1 && array.get(6) == 1){
            win = true;
        } else if(array.get(1) == 1 && array.get(4) == 1 && array.get(7) == 1){
            win = true;
        } else if(array.get(2) == 1 && array.get(5) == 1 && array.get(8) == 1){
            win = true;
        } else if(array.get(0) == 1 && array.get(4) == 1 && array.get(8) == 1){
            win = true;
        } else if(array.get(2) == 1 && array.get(4) == 1 && array.get(6) == 1){
            win = true;
        } else if(array.get(0) == 2 && array.get(1) == 2 && array.get(2) == 2){
            win = true;
        } else if(array.get(3) == 2 && array.get(4) == 2 && array.get(5) == 2){
            win = true;
        } else if(array.get(6) == 2 && array.get(7) == 2 && array.get(8) == 2){
            win = true;
        } else if(array.get(0) == 2 && array.get(3) == 2 && array.get(6) == 2){
            win = true;
        } else if(array.get(1) == 2 && array.get(4) == 2 && array.get(7) == 2){
            win = true;
        } else if(array.get(2) == 2 && array.get(5) == 2 && array.get(8) == 2){
            win = true;
        } else if(array.get(0) == 2 && array.get(4) == 2 && array.get(8) == 2){
            win = true;
        } else if(array.get(2) == 2 && array.get(4) == 2 && array.get(6) == 2){
            win = true;
        }

        return win;
    }

}
