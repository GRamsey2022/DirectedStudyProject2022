// Takes the lattice from the first code and 
// moves one of the filled spots to a different one
// and takes into account the number of states and energy

// Tasks:
// if one particle in a filled spot is moved then
// energy that occurs when one is moved.
// Have the number of states accounted for if certain ones that 
// are filled, are moved to different places.  

import java.io.*;
import java.util.*;

public class Board {

    Scanner scanner = new Scanner(System.in);

    static private int length;
    static private double grid[][];
    static private double Energy;
    static private double tempArray[][];
    static private double tempArray2[][];

    
    public Board(int inLength){
        length = inLength;
        // volume = length * length;
        grid = new double [length][length];
        fillBoard();
        Neighbors();
    }

    public void fillBoard(){
             // checker board patterned: Used Stackoverflow for example code,
        // (rewritten for easier reading).
        // for: checkered patterned array in java
        // y is the row, while x is the column
        for (int row = 0; row < length; row++){
            for (int col = 0; col < length; col++){
                // sees if the row and col added are divisable by 2 have it set to 0 else 1
                    if((row+col)%2 == 0){
                        grid[row][col] = 0;
                    }
                    else{
                        grid[row][col] = 1;
                    }
            }
        }
        // prints the grid  that's made from first two for loops   
        //#prep#
        System.out.print("Original grid " +"\n"); 
        
        for (int row = 0; row < length; row++){
            for (int col = 0; col < length; col++){              
                System.out.print(grid[row][col] + " ");               
            }
            // prints each row on different line to form the LxL lattic
            System.out.println();  
        }

        
        tempArray2 = grid;
        // allows a person to type values into terminal
        System.out.println("Direction of particle moving= ");
        System.out.println("1 is North(Up); 2 is East(Right); 3 is South(Down); 4 is West(Left): ");
        int dir = scanner.nextInt();
        
        
        // int starting_row = 0;
        // int starting_col = 1;
        int starting_row = scanner.nextInt();
        int starting_col = scanner.nextInt();

        // moves the starting row and column upward or North by 1
        if (dir == 1){

            // Cache the target and current cells contents, ie. their values 
            double target_Cell_val = tempArray2[starting_row - 1][starting_col];
            double current_cell_val = tempArray2[starting_row][starting_col];
            // Placing the currrent cells value into the target cell
            tempArray2[starting_row - 1][starting_col] = current_cell_val;
            // Placing the target cells value into the current cell
            tempArray2[starting_row][starting_col] = target_Cell_val;
            
            // System.out.println("target_Cell_val= " + target_Cell_val+ "  current_cell_val= " + current_cell_val);
        }
        scanner.close();

        System.out.print("Modified grid " + "\n");

        for (int row = 0; row < length; row++)
        {
            for (int col = 0; col < length; col++)
            {              
                System.out.print(tempArray2[row][col] + " ");             
            }
            // prints each row on different line to form the LxL lattic
            System.out.println();  
        }

        // the starting row and column are moved to the right or west by 1
        if (dir == 2){
  
            // Cache the target and current cells contents, ie. their values 
            double target_Cell_val = tempArray2[starting_row][starting_col + 1];
            double current_cell_val = tempArray2[starting_row][starting_col];
            // Placing the currrent cells value into the target cell
            tempArray2[starting_row][starting_col+1] = current_cell_val;
            // Placing the target cells value into the current cell
            tempArray2[starting_row][starting_col] = target_Cell_val;
            
            // System.out.println("target_Cell_val= " + target_Cell_val+ "  current_cell_val= " + current_cell_val);
        }

        // moves the starting row and column downward or south by 1
        if (dir == 3){
  
            // Cache the target and current cells contents, ie. their values 
            double target_Cell_val = tempArray2[starting_row + 1][starting_col];
            double current_cell_val = tempArray2[starting_row][starting_col];
            // Placing the currrent cells value into the target cell
            tempArray2[starting_row + 1][starting_col] = current_cell_val;
            // Placing the target cells value into the current cell
            tempArray2[starting_row][starting_col] = target_Cell_val;
            
            // System.out.println("target_Cell_val= " + target_Cell_val+ "  current_cell_val= " + current_cell_val);
        }

        // moves the starting row and column to the left or west by 1
        if (dir == 4){
  
            // Cache the target and current cells contents, ie. their values 
            double target_Cell_val = tempArray2[starting_row][starting_col - 1];
            double current_cell_val = tempArray2[starting_row][starting_col];
            // Placing the currrent cells value into the target cell
            tempArray2[starting_row][starting_col - 1] = current_cell_val;
            // Placing the target cells value into the current cell
            tempArray2[starting_row][starting_col] = target_Cell_val;
            
            // System.out.println("target_Cell_val= " + target_Cell_val+ "  current_cell_val= " + current_cell_val);
        }
        
        
        System.out.print("Modified grid " + "\n");
        
        for (int row = 0; row < length; row++)
        {
            for (int col = 0; col < length; col++)
            {              
                System.out.print(tempArray2[row][col] + " ");             
            }
            // prints each row on different line to form the LxL lattic
            System.out.println();  
        }

    }
    
    public void Neighbors(){
         //Look at the MC simiulation
        // energy of the array
        // double E = 0.0;

        int i_p = 0; // the neighbor if at the end of row or col
        int j_p = 0; //the neighbor if at the end of row or col


        // for if there's naighbors near the particle
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                //if the point is at the end of row or col then go back to beginnig
                i_p =i+1;
                if (i_p >length-1){ 
                    i_p = 0;
                }
                j_p = j+1;
                if(j_p > length-1){
                    j_p = 0;
                }
                //Finding the energy of system using the neighbors
                Energy = Energy + grid[i][j]*grid[i_p][j] + grid[i][j]*grid[i][j_p];                
            }            
        }
            System.out.println("Energy= " + Energy);
    }

    
}
