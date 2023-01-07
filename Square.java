//Julia Bair
//CS110
//Class Square contains methods which define a square's condition
abstract class Square{
   //declaring instance variables and constants
   private String element;
   private boolean flagged = false;
   private boolean uncovered = false;
   
   /**
   Method Square is a default constructor
   */
   public Square()
   {
      
   }
   
   /**
   Method Square takes in three variables and sets them to a default
   @param e String is element
   @param fl boolean is flagged
   @param unc boolean is uncovered
   */
   public Square(String e, boolean fl, boolean unc)
   {
      element = e;
      flagged = fl;
      uncovered = unc;
   }
   
   /**
   Method isFlagged checks to see if a square is flagged
   @return boolean true or false
   */
   public boolean isFlagged()
   {
      return flagged;
   }
   
   /**
   Method isUncovered checks to see if a square is uncovered
   @return uncovered boolean
   */
   public boolean isUncovered()
   {
      return uncovered;
   }
   
   /**
   Method flagSquare sets a square to flagged
   */
   public void flagSquare()
   {
      flagged = true;
   }
   
   /**
   Method setUncovered sets a square to uncovered
   */
   public void setUncovered()
   {
      uncovered = true;
   }
   
   /**
   Method setElement takes in one parameter and sets a square element
   @param element String
   */
   public void setElement(String element)
   {
      this.element = element;
   }
   
   /**
   Method getElement returns a string element
   @return element is String
   */
   public String getElement()
   {
      return element;
   }
  
   /**
   Method uncover is abstract
   */ 
   abstract void uncover();
   
   /**
   Method toString sets default String
   @return String
   */
   public String toString()
   {
      return "";
   }
   
   /**
   Method isMine detects if square is a mine
   @return true of false
   */
   public boolean isMine()
   {
      return false;
   }
}