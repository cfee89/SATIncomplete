 
import java.util.*;


/**
 * Basic representation of a board, uses lists to hold positions of pieces.
 * Also generates pieces on the board. 
 * 
 * @author (Craig Fee, Adam Kennett) 
 * @version (3.22.2015)
 */
public class Board
{

    char[][] board;
    int size;
    Random rand = new Random();
    int qRow;
    int qCol;
    int heurFromStart;
    int heurFromGoal;
    int heurTotal;
    
    /**
     * Constructor Method, initializes instance with empty lists
     */
    public Board(int size)
    {
        this.size = size;
        board = randPiece(size);
        findQueen(this);
        heurTotal = distFromStart()+distFromGoal();
        

    }
     /**
     * Constructor method, accepts a Board object as parameter and passes 
     * it's queens list to the new board
     */
    public Board(Board b)
    {
        this.board = b.board;

    }

    /**
     * Generates random game board, puts kings,knights and pawns randomly throughout board
     * places queen in starting position
     * designates attack radiuses with an x
     */
    public char[][] randPiece(int size)
    {
           char[][] populatedBoard = new char[size][size];
           
         for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
               populatedBoard[i][j] = '.';
            }
            System.out.println();
        }
     
        //start queen on row 0, random column
        populatedBoard[0][rand.nextInt(size-1)] = 'Q'; 
        for(int i =0; i<size; i++)
        {
            int row = rand.nextInt(size-1); 
            int col = rand.nextInt(size-1);
            if(populatedBoard[row][col] != 'Q' && row>1)
          populatedBoard[row][col] = randType();
            
        }
        
        //kings attack radius  should check if killing queen here and delete king if so
          for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
                if(populatedBoard[i][j] == 'K')
                {
                    
                    //above
                if(i-1 != -1&& populatedBoard[i-1][j] == '.')     
               populatedBoard[i-1][j] = 'x';
               //below
               if(i+1<size&& populatedBoard[i+1][j] == '.')
               populatedBoard[i+1][j] = 'x';
               //right
                 if(j+1<size&& populatedBoard[i][j+1] == '.')
               populatedBoard[i][j+1] = 'x';
               //left
                   if(j-1!=-1&& populatedBoard[i][j-1] == '.')
               populatedBoard[i][j-1] = 'x';
               //lower left
                   if(i+1<size && j-1!=-1&& populatedBoard[i+1][j-1] == '.')
               populatedBoard[i+1][j-1] = 'x';
               //lower right
                   if(i+1<size && j+1<size&& populatedBoard[i+1][j+1] == '.')
               populatedBoard[i+1][j+1] = 'x';
               
               //upper right
                   if(i-1!=-1 && j+1<size&& populatedBoard[i-1][j+1] == '.')
               populatedBoard[i-1][j+1] = 'x';
               
               //upper left
               if(i-1!=-1 && j-1!=-1&& populatedBoard[i-1][j-1] == '.')
               populatedBoard[i-1][j-1] = 'x';
            }
            }
           
        }
        //knight radius
           for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
                if(populatedBoard[i][j] == 'N')
                {
                    
                    //up 2 left 1
                if(i-2 >=0 && j-1>=0&& populatedBoard[i-2][j-1] == '.')     
               populatedBoard[i-2][j-1] = 'x';
               
               //up 2 right 1
                  if(i-2 >=0 && j+1<size&& populatedBoard[i-2][j+1] == '.')     
               populatedBoard[i-2][j+1] = 'x';
               //down 2 right 1
                  if(i+2<size && j+1<size&& populatedBoard[i+2][j+1] == '.')     
               populatedBoard[i+2][j+1] = 'x';
               //down 2 left 1
                  if(i+2<size && j-1>=0&& populatedBoard[i+2][j-1] == '.')     
               populatedBoard[i+2][j-1] = 'x';
               
               
                //up 1 right 2
                  if(i-1 >=0 && j+2<size&& populatedBoard[i-1][j+2] == '.')     
               populatedBoard[i-1][j+2] = 'x';
               
                //up 1 left 2
                  if(i-1 >=0 && j-2>=0 && populatedBoard[i-1][j-2] == '.')     
               populatedBoard[i-1][j-2] = 'x';
               
                //down 1 left 2
                  if(i+1<size && j-2>=0&& populatedBoard[i+1][j-2] == '.')     
               populatedBoard[i+1][j-2] = 'x';
               
                //down 1 right 2
                  if(i+1<size && j+2<size&& populatedBoard[i+1][j+2] == '.')     
               populatedBoard[i+1][j+2] = 'x';
               
             
            }
            }
           
        }
        //pawn radius
           for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
                if(populatedBoard[i][j] == 'P')
                {
               //upper right
                   if(i-1!=-1 && j+1<size&& populatedBoard[i-1][j+1] == '.')
               populatedBoard[i-1][j+1] = 'x';
               
               //upper left
               if(i-1!=-1 && j-1!=-1&& populatedBoard[i-1][j-1] == '.')
               populatedBoard[i-1][j-1] = 'x';
            }
            }
           
        }
        

        return populatedBoard;
    }
    /**
     * Chooses a random type and returns that type
     */
    public char randType()
    {
        
        int choose = rand.nextInt(3);
        switch(choose) {
            case 0: return 'P'; //pawn
            case 1: return 'N'; //knight
            case 2: return 'K'; //king
            
            default: return '.';//empty
        }
    }
    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
       
    }
    //finds the queen on the board
    public void findQueen()
    {
        for(int i =0; i<size-1;i++)
        {
            for(int j=0;j<size-1;j++)
            {
                if(board[i][j]=='Q')
                    qRow = i;
                    qCol = j;
                    break;
            }
        }
    }
    public int distFromStart()
    {
        
        return heurFromStart = qRow;
    }
    public int distFromGoal()
    {
        
        return heurFromGoal = size - qRow;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }

    public int getqRow() {
        return qRow;
    }

    public int getqCol() {
        return qCol;
    }

    public int getHeurFromStart() {
        return heurFromStart;
    }

    public int getHeurFromGoal() {
        return heurFromGoal;
    }

    public int getHeurTotal() {
        return heurTotal;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setqRow(int qRow) {
        this.qRow = qRow;
    }

    public void setqCol(int qCol) {
        this.qCol = qCol;
    }

    public void setHeurFromStart(int heurFromStart) {
        this.heurFromStart = heurFromStart;
    }

    public void setHeurFromGoal(int heurFromGoal) {
        this.heurFromGoal = heurFromGoal;
    }

    public void setHeurTotal(int heurTotal) {
        this.heurTotal = heurTotal;
    }
    public int findTotalHeur()
    {
        return heurTotal = heurFromStart + heurFromGoal;
    }
}
