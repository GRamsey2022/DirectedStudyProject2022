import java.io.*;
import java.util.*;

//Project
// Name: Gwynn Ramsey
// Email: gramsey@clarku.edu
// directed study under: Professor Barbara Capogrosso-Sansone; bcapogrosso@clarku.edu 
// To find out the number of states with an array filling in checker board pattern
// along with finding the energy at each state of the array when a particle is moved,
// then more than one and finding the energy and number of states that are associated with 
// the array
 
////////////////////////////////////
// Printing of the lattic for LxL //
////////////////////////////////////


public class Projectprt1 {
    public static void main(String[] args)  throws FileNotFoundException{
        Scanner input = new Scanner(new File("Project.txt"));
        PrintStream output = new PrintStream( new File("Project_StateEnergy.txt"));

        //size of array, for trial L=4 
        int length = returnValue(input);
        double E_tot = 0.0;


        System.out.println("Board 0: Original Board ");
        Board board = new Board(length);


        output.printf("Particle1= %10.2f \n", E_tot);

    }
       
    public static int returnValue(Scanner input){
        int dummy = input.nextInt();
        input.nextLine();
        return dummy;
    }

    
}