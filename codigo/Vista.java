/** 
 * Vista.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: 05/02/2022
    Clase vista que imprime en pantalla para los inputs
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista{
    private Scanner scan;

    public Vista(){
        scan = new Scanner(System.in);
    }

    public void welcome(){
        System.out.println("\n~ ACADEMIA EUROPEA TRANSLATOR ~");
    }

    public void message(String text){
        System.out.println(text);
    }
   
    public void error(){
        System.out.println("\n(!) An error has ocurred");
    }

    public void bye(){
        System.out.println("\nThanks for using ~ ACADEMIA EUROPEA TRANSLATOR ~\n");
    }

    public int menu() throws Exception, InputMismatchException{
        int option = -1;
        boolean bandera = false;

        try{
            //prints the options 
            System.out.println("\nWhat do you want to do?");
            System.out.println("(1) Use translator");
            System.out.println("(2) Exit");

            //evaluates the correct options
            while (!bandera){
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 2) 
                    bandera = true;
                else{ 
                    System.out.println("(!) Choose a valid option"); 
                }
            }
        }catch (InputMismatchException e){
            String s = "(!) Conversion failed" + option + ": " + e.toString(); 
            throw new InputMismatchException(s);
        }
        return option;
    }

    public int languages(){
        int option = -1;
        boolean bandera = false;

        try{
            //print the options  
            System.out.println("\nWhich language do you want to use?");
            System.out.println("(1) English");
            System.out.println("(2) Spanish");
            System.out.println("(3) French");
            
            //evaluates the correct options
            while (!bandera){ 
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 3)
                    bandera = true;
                else{ 
                    System.out.println("(!) Choose a valid option"); 
                }
            }
        } catch (InputMismatchException e){
            String s = "(!) Conversion failed" + option + ": " + e.toString(); 
            throw new InputMismatchException(s); 
        }
        return option;
    }

    public void warnings(){
        System.out.println("Be sure you have the following files");
        System.out.println("'dictionary.txt' and 'translate.txt'\n");
    }
}