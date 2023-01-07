//Julia Bair
//CS110
//Class MineSweeperDriver calls methods and creates user interface for game
import java.util.Scanner;
public class MineSweeperDriver{
   public void play()
   {
      Scanner input = new Scanner(System.in);
      int height = 0;
      int width = 0;
      int minect = 0;
      
      System.out.println("Select a level: ");
      System.out.println("(B)eginner 8 x 8 with 8 mines ");
      System.out.println("(I)ntermediate 10 x 12 with 10 mines ");
      System.out.println("(E)xpert 16 x 20 with 50 mines ");
      System.out.println("Enter choice: ");
      String lvl = input.nextLine();
      
      if(lvl.equals("B"))
      {
         height = 8;
         width = 8;
         minect = 8;
      }
      else if(lvl.equals("I"))
      {
         height = 10;
         width = 12;
         minect = 10;
      }
      else if(lvl.equals("E"))
      {
         height = 16;
         width = 20;
         minect = 50;
      }
      
      Grid grid = new Grid(height, width, minect);
      
      System.out.println(grid);
      
      while(true)
      {
         System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");
         System.out.println("What next? ");
         String[] options = input.nextLine().split(" ");
         
         if(options[0].equals("Q"))
         {
            System.exit(0);
         }
         else if(options[0].equals("U"))
         {
            int r = Integer.parseInt(options[1]);
            int c = Integer.parseInt(options[2]);
            int spot = grid.uncoverSquare(r, c);
            
            if(spot == 3)
            {
               grid.exposeMines();
               System.out.println(grid);
               System.out.println("Better luck next time!");
               System.exit(0);
            }
            else if(spot == 2)
            {
               System.out.println("You won!");
               System.exit(0);
            }
         }
         
         else if(options[0].equals("F"))
         {
            int r = Integer.parseInt(options[1]);
            int c = Integer.parseInt(options[2]);
            grid.flagSquare(r, c);

         }
         System.out.println(grid);
      }
   }
}