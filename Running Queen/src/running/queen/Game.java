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
    PriorityQueue<Board> open = new PriorityQueue<Board>();
    ArrayList<Board> closed = new ArrayList<Board>();
    Board currentBoard;
    
  //  public static void main(String args[])
    //{
      //  play();
    //}
    public void play()
    {
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        System.out.println("how big will the board be?");
        int size = Integer.parseInt(input.nextLine());
        currentBoard = new Board(size);
        currentBoard.printBoard();
       
    }
    
       /**
     * Evaluates possible next moves for queen then advances to next state
     * @param Game
     * @return n/a
     */
    public void StateSearch()
    {
        closed.add(currentBoard);
        //search for major diagonal moves
        Board temp = new Board(currentBoard);
        for(int i = temp.qRow;i<temp.size;i++)
            for(int j=temp.qCol;j<temp.size;j++)
            {
                if(temp.board[temp.qCol][temp.qRow] == '.')
                {
                temp.board[temp.qCol+1][temp.qRow+1] = 'Q';
                temp.board[temp.qCol][temp.qRow] = '.';
                temp.findQueen();
                temp.findTotalHeur();
                open.add(temp);
                }
                if((temp.board[temp.qRow][temp.qCol]=='P')
                        || (temp.board[temp.qRow][temp.qCol]=='K')
                                || (temp.board[temp.qRow][temp.qCol]=='N'))
                                {
                                    break;
                                }
                else
                {
                }
            }
    }
        
        
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
