//Julia Bair
//CS110
//Class Grid creates and modifies the playing grid
import java.util.Random;
public class Grid{
   //declaring instance variables and constants
   private Square grid[][]; 
   private int width;
   private int height;
   private int numMines;
   private int numSquaresUncovered = 0;
   
   public final int OK = 1;
   public final int WIN = 2;
   public final int MINE = 3;
   
   /**
   Method Grid takes in 3 int variables and creates a grid array
   @param r int is width
   @param c int is height
   @param numMines is int
   */
   public Grid(int r, int c, int numMines)
   {
      width = c;
      height = r;
      this.numMines = numMines;
      grid = new Square[r][c];
      
      Random rand = new Random();
      int mineCount = 0;
      while(mineCount < numMines)
      {
         int m1 = rand.nextInt(r);
         int m2 = rand.nextInt(c);
         
         if(grid[m1][m2] == null)
         {
            grid[m1][m2] = new MineSquare();
            mineCount++;
         }
      }
      
      for (int i = 0; i < r; i++)
      {
         for (int j = 0; j < c; j++)
         {
            if (grid[i][j] == null) 
            {
               grid[i][j] = new NumberSquare(getNeighbors(i, j), i, j);
            }
         }
      }
      
   }
   
   /**
   Method getNeighbors takes in two int variables, locates how many neighbor mines
   @param r int is width
   @param c int is height
   @return count int is num neighbor mines
   */
   public int getNeighbors(int r, int c)
   {
      int count = 0;
      for(int row = r - 1; row <= r + 1; row++)
      {
         for(int col = c - 1; col <= c + 1; col++)
         {
            if(row >= 0 && row < height && col >= 0 && col < width)
            {
               if(grid[row][col] != null)
               {
                  if(grid[row][col].isMine())
                  {
                     count++;
                  }
               }
            }
         }
      }
      return count;
   }
   
   /**
   Method uncoverSquare takes in two ints and determines if a square should be uncovered
   and if the user has won
   @param r int is width
   @param c int is height
   @return if user has won, or continue
   */
   public int uncoverSquare(int r, int c)
   {
         if (grid[r][c].isMine())
         {
            return MINE;
         }
         else if (getNeighbors(r, c) == 0)
         {
            for(int row = r - 2; row <= r + 2; row++)
            {
               for(int col = c - 2; col <= c + 2; col++)
               {
                  if(row >= 0 && row < height && col >= 0 && col < width)
                  {
                     if(grid[row][col].isMine() == false && grid[row][col].isUncovered() == false)
                     {
                        grid[row][col].uncover();
                        numSquaresUncovered++;
                     }
                  }
               }
            }
         }
         else if (getNeighbors(r, c) == 1)
         {
            for(int row = r - 1; row <= r + 1; row++)
            {
               for(int col = c - 1; col <= c + 1; col++)
               {
                  if(row >= 0 && row < height && col >= 0 && col < width)
                  {
                     if(grid[row][col].isMine() == false && grid[row][col].isUncovered() == false)
                     {
                        grid[row][col].uncover();
                        numSquaresUncovered++;
                     }
                  }
               }
            }

         }
         else
         {
            if(grid[r][c].isUncovered() == false)
            {
               grid[r][c].uncover();
               numSquaresUncovered++;
            }
         }
         
         if(numSquaresUncovered == ((width * height) - numMines))
         {
            return WIN;
         }
         else
         {
            return OK;
         }
   }  
   
   /**
   Method exposeMines uncoveres all mines
   */
   public void exposeMines()
   {
      for (int i = 0; i < height; i++)
      {
         for (int j = 0; j < width; j++)
         {
            if (grid[i][j].isMine()) 
            {
               grid[i][j].uncover();
            }
         }
      }
   }
   
   /**
   Method flagSquare takes in two ints and flags a square
   @param r int is width
   @param c int is height
   */
   public void flagSquare(int r, int c)
   {
      if(grid[r][c].isUncovered() == false)
      {
         grid[r][c].flagSquare();
      }
   }
   
   /**
   Method toString returns default String
   @return toString String
   */
   public String toString()
   {
      String board = new String();
      board += " ";
      for (int i = 0; i < width; i++)
      {
         board += "  " + i;
      }
      board += "\n";
      for (int i = 0; i < height; i++)
      {
         board += i;
         for (int j = 0; j < width; j++)
         {
            if (j <= 9)
            {
               board += "  " + grid[i][j];
            }
            else
            {
               board += "   " + grid[i][j];
            }
            
         }
         board += "\n";
      }

      return board;
   }
   
}