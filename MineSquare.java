//Julia Bair
//CS110
//Class MineSquare extends class Square and has methods for a mine's condition
public class MineSquare extends Square{
   /**
   Method MineSquare is default constructor and sets the element
   */
   public MineSquare()
   {
      setElement("*");
   }
   
   /**
   Method uncover uncovers a mine
   */
   public void uncover()
   {
      setUncovered();
   }
   
   /**
   Method isMine returns boolean if mine
   @return true or false
   */
   public boolean isMine()
   {
      return true;
   }
   
   /**
   Method toString returns default String
   @return toString String
   */
   public String toString()
   {
      if(isUncovered() == true)
      {
         return "*";
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