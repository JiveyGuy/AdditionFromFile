import java.util.Scanner;
import java.io.*;
// Name of the exersize, is the name of the class
public class Remedial2
{
  
  public static void main(String[] args) throws IOException// tester main
  { 
    
    //We declare our first keyboard.
    Scanner keyboard = new Scanner(System.in); 
    
    String maybeFileName; //declaring our default/user defined file name.
    FileWriter fileWrite; //declaring the file writer
    System.out.println("What is the name of the file you want to output? \n"
                         +"if you want to use the default output file press enter.");
    maybeFileName = keyboard.nextLine();
    if (maybeFileName.trim().length() == 0)
    {
      maybeFileName = "output.txt";
    }
    //Opens the file
    File file = new File(maybeFileName);
    //checking for the file
    if(file.exists()){
      fileWrite = new FileWriter(maybeFileName,true);
    }
    else{
      fileWrite = new FileWriter(maybeFileName,false);
    }
    
    PrintWriter printWrite = new PrintWriter(fileWrite);
    
    
    Scanner input = new Scanner(new File( "numbers.txt"));
    int firstVal = input.nextInt();
    int[] values = new int[firstVal];
    printWrite.println("There are "+ firstVal +" digits. ");
    System.out.print("The digits are: " );
    for (int x = 0; x < firstVal; x++)
    {
      values[x] = input.nextInt();
      System.out.print( values[x] +  "  ");
    }
    System.out.println(" ");
    
    int sum = findSum(values);
    System.out.println( " The sum of the digits is " + sum);
    
    double avg = findAVG(values);
    System.out.println( " The average of the digits is " + avg);
    
    for (int x = 0; x < firstVal; x++)
    {
      if (x < firstVal - 1)
        printWrite.print(values[x] + " + ");
      else
      {
        printWrite.print(values[x]);
        printWrite.println( " = " + sum);
        printWrite.println( "\n The average is: \n" + avg ); 
      }
    }
    fileWrite.close();
    keyboard.close();
  }
  
  public static int findSum(int[] toSum)
  {
    int result = 0;
    for ( int x = 0; x < toSum.length; x++)
      result += toSum[x];
    
    return result;
  }
  
  public static double findAVG (int[] toAvg)
  {
    double sum = findSum(toAvg);
    return sum / toAvg.length;
  }
}