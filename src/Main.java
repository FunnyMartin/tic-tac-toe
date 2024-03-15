import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        ArrayList<Field> fields = new ArrayList<>();
        Board board =new Board(fields);
        while(!board.checkEnding()){
            board.play(scanner);
        }
    }
}