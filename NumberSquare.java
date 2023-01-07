//Julia Bair
//CS110
//Class NumberSquare extends class Square and has methods for a number square's condition
public class NumberSquare extends Square{
   //declaring instance variables
   private int neighborMines;
   private int myRow;
   private int myCol;
   
   /**
   Method NumberSquare takes in three variables and sets their defaults
   @param nm int is neighborMines
   @param mr int is myRow
   @param mc int is myCol
   */
   public NumberSquare(int nm, int mr, int mc)
   {
      neighborMines = nm;
      myRow = mr;
      myCol = mc;
      setElement(Integer.toString(nm));
   }
   
   /**
   Method uncover calls method setUncovered
   */
   public void uncover()
   {
      setUncovered();
   }
   
   /**
   Method getNeighborMines returns an int
   @return neighborMines int is num of neighbor mines
   */
   public int getNeighborMines()
   {
      return neighborMines;
   }
   
   /**
   Method isMine returns boolean
   @return true or false if it is mine
   */
   public boolean isMine()
   {
      return false;
   }
   
   /**
   Method tosString returns default String
   @return toString type String
   */
   public String toString()
   {
      if(isUncovered() == true)
      {
         if(getNeighborMines() == 0)
         {
            return "_";
         }
         else
         {
            return Integer.toString(getNeighborMines());
         }
      }
      else if(isFlagged() == true)
      {
         return "f";
      }
      else
      {
         return "x";
      }
   }
}