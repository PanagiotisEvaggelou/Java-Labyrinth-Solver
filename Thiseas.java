import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Thiseas{

    public static int numberRows, numberColumns, k;
    public static int EntranceRow, EntranceColumn;
    private static String[][] grid;
    public static boolean bo2, bo1, bo3 = false;

    private static final String OPEN = "0";
    private static final String TRIED = "*";
    private static final String WRONG = "X";

    public static void MarkPos2(int x,int y){
        grid[x][y] = TRIED;
    }

    public static void MarkPos3(int x,int y){
        grid[x][y] = WRONG;
    }

    public static int getRows()
    {
        return grid.length;
    }

    public static int getColumns()
    {
        return grid[0].length;
    }


    public static boolean Check0(Stack<Position> stack, String[][] grid, int k){
        Position pos1, pos2, pos3, pos4, pos;
        boolean x = false;

        pos1 = stack.pop();
        pos2 = stack.pop();
        pos3 = stack.pop();
        pos4 = stack.pop();

        

        if ((grid[pos1.getx()][pos1.gety()]).equals(OPEN)){
            stack.push(pos1); 
            MarkPos2(pos1.getx(),pos1.gety());  
            x = true;                  
        }
        else if ((grid[pos2.getx()][pos2.gety()]).equals(OPEN)){
            stack.push(pos2);
            MarkPos2(pos2.getx(),pos2.gety());  
            x = true;
        }
        else if ((grid[pos3.getx()][pos3.gety()]).equals(OPEN)){ 
            stack.push(pos3); 
            MarkPos2(pos3.getx(),pos3.gety()); 
            x = true;
        }
        else if ((k>=2) && ((grid[pos4.getx()][pos4.gety()]).equals(OPEN))){
            stack.push(pos4); 
            MarkPos2(pos4.getx(),pos4.gety());  
            x = true;
        }

        if (x == false){
            pos = stack.peek();
            MarkPos3(pos.getx(),pos.gety());
            stack.push(pos4);
            stack.push(pos3);
            stack.push(pos2);
            stack.push(pos1);

        }
        return x;
    }


    public static boolean Check2(Stack<Position> stack, String[][] grid, int k){
        Position pos1, pos2, pos3, pos4;
        boolean x = false;



        pos1 = stack.pop();
        pos2 = stack.pop();
        pos3 = stack.pop();
        pos4 = stack.pop();


        

        if ((grid[pos1.getx()][pos1.gety()]).equals(TRIED)){
            stack.push(pos1); 
            //MarkPos3(pos1.getx(),pos1.gety());  
            x = true;                  
        }
        else if ((grid[pos2.getx()][pos2.gety()]).equals(TRIED)){
            stack.push(pos2);
            //MarkPos3(pos2.getx(),pos2.gety());  
            x = true;
        }
        else if ((grid[pos3.getx()][pos3.gety()]).equals(TRIED)){ 
            stack.push(pos3); 
            //MarkPos3(pos3.getx(),pos3.gety()); 
            x = true;
        }
        else if ((k>=2) && ((grid[pos4.getx()][pos4.gety()]).equals(TRIED))){
            stack.push(pos4); 
            //MarkPos3(pos4.getx(),pos4.gety());  
            x = true;
        }


        if (x == false){
            stack.push(pos4);
            stack.push(pos3);
            stack.push(pos2);
            stack.push(pos1);
        }
        return x;
    }


    public static void main(String args[]){
     
        try {
            Scanner reader = new Scanner(new File(args[0]));

            System.out.println("\n");
            while (bo1 == false) {  
                numberRows = reader.nextInt();
                numberColumns = reader.nextInt();
                EntranceRow = reader.nextInt();
                EntranceColumn = reader.nextInt();
                
    
                grid = new String[numberRows][numberColumns];
                for(int i=0; i<numberRows; i++)
                {
                    for(int j=0; j<numberColumns; j++)
                    {
                        grid[i][j]= reader.next();
                        
                    }

                }
                
                bo1 = true;

                if (reader.hasNext()){
                    bo2 = true;
                }
            } 

        } catch (FileNotFoundException ex) {
            System.out.println("No File Found!");
            return;
        }

        if (bo2 == true){
            System.out.println("Error. The file contains more data than expected!");
            return;
        }

        for(int i=0; i<numberRows; i++)
        {
            for(int j=0; j<numberColumns; j++)
            {
                if (grid[i][j].equals("E")){
                    bo3 = true;
                }
            }
        }

        if (bo3 == false){
            System.out.println("Error. There is no entrance listed in the file!");
            return;
        }

        System.out.println("Labyrinth unsolved: ");
        for (int i = 0; i<numberColumns; i++){
            System.out.print("- ");
        }
        System.out.println("\n");

        for(int i=0; i<numberRows; i++)
        {
            for(int j=0; j<numberColumns; j++)
            {
                System.out.print(grid[i][j] + " ");
                if (j==numberColumns-1){
                    System.out.println("");
                }
            }
        }

        for (int i = 0; i<numberColumns; i++){
            System.out.print("- ");
        }

        boolean done = false;
        Position pos = new Position(EntranceRow,EntranceColumn);
        Stack<Position> stack = new Stack<>();
        stack.push(pos);
        //stack.printStack(System.out);
        k = 0;


        while((done != true))
        {
            if (k==0){
                pos = stack.peek();
                MarkPos2(pos.getx(),pos.gety());     //this cell has been tried
                if (pos.getx()==getRows()-1 && pos.gety()==getColumns()-1)
                {
                    done = true;
                }else
                {
                    stack.push(new Position(pos.getx()-1,pos.gety()));//going up
                    stack.push(new Position(pos.getx()+1,pos.gety()));//going down     
                    stack.push(new Position(pos.getx(),pos.gety()-1));//going left
                    stack.push(new Position(pos.getx(),pos.gety()+1));//going right  
                    
                }
                k++;
            }
            else{
                if (Check0(stack, grid, k)==true){
                    pos = stack.peek();
                    if (pos.getx()==getRows()-1 || pos.gety()==getColumns()-1)
                    {
                        done = true;
                    }else
                    {
                        stack.push(new Position(pos.getx()-1,pos.gety()));//going up
                        stack.push(new Position(pos.getx()+1,pos.gety()));//going down     
                        stack.push(new Position(pos.getx(),pos.gety()-1));//going left
                        stack.push(new Position(pos.getx(),pos.gety()+1));//going right    
                        
                    }
                }
                else if ((Check2(stack, grid, k)==true)){
                    pos = stack.peek();
                    if (pos.getx()==getRows()-1 || pos.gety()==getColumns()-1)
                    {
                        done = true;
                    }else
                    {
                        stack.push(new Position(pos.getx()-1,pos.gety()));//going up
                        stack.push(new Position(pos.getx()+1,pos.gety()));//going down     
                        stack.push(new Position(pos.getx(),pos.gety()-1));//going left
                        stack.push(new Position(pos.getx(),pos.gety()+1));//going right 
                        
                    }
                }
                k++;

            }


            if(k == 600){
                done = true;
            }
            
            
        }


        System.out.println("\n");
        System.out.println("Labyrinth solved: ");
        for (int i = 0; i<numberColumns; i++){
            System.out.print("- ");
        }
        System.out.println("\n");

        for(int i=0; i<numberRows; i++)
        {
            for(int j=0; j<numberColumns; j++)
            {
                System.out.print(grid[i][j] + " ");
                if (j==numberColumns-1){
                    System.out.println("");
                }
            }
        }

        for (int i = 0; i<numberColumns; i++){
            System.out.print("- ");
        }
        System.out.println("\n");

        if (k == 600){
            System.out.println("There is no exit!");
        }
        else if (done == true){
            System.out.println("You made it!");
            System.out.println("Coordinates of exit are: " + stack.peek());
        }

        
    }

}
    

