 import java.util.*;
import java.io.*;


/**
 * Main method, creates a board then places queen and enemies
 * executes state space search 
 * 
 * @author (Craig Fee, Adam Kennett) 
 * @version (3.22.2015)
 */

public class Game
{
    public static final int SIZE = 8;
      Scanner input = new Scanner(System.in);
    public static void main()
    {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        System.out.println("how big will the board be?");
int size = Integer.parseInt(input.nextLine());
        Board b = new Board(size);
       b.printBoard();
       main();
    }
    
       /**
     * Evaluates possible next moves for queen then advances to next state
     * @param Game
     * @return n/a
     */
    public void StateSearch(Game g)
    {
//        List visited = b.queenPos;
//        List unVisited b.;
        
    }
//     
//     /**
//      * Attempts to add a queen to each tile on the board, if queen is attacked it returns null
//      * this is used to check for valid tiles
//      * @param int, Board
//      * @return Board
//      */
//     private Board placeQueens(int col, Board b)
//     {
//         Board result;
//         for(int row =0;row<SIZE;row++)
//         {
//             result = new Board(b);
//             result.queenPos.add(new Position(row,col));
//             if(!(result.check()))
//                 return result;
//             result = placeQueens(col+1,result);
//             if(result!=null)
//                 return result;
//             
//         }
//         return null;
//     }
    
}
