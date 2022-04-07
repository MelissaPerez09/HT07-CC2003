/** 
 * Vista.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: 06/02/2022
    Clase vista que imprime en pantalla para los inputs
*/

//imported libraries
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista{
    private Scanner scan;

    /**
     * constructor
     */
    public Vista(){
        scan = new Scanner(System.in);
    }

    /**
     * prints welcome message
     */
    public void welcome(){
        System.out.println("\n~ ACADEMIA EUROPEA TRANSLATOR ~");
    }

    /**
     * function to print any text
     * @param text
     */
    public void message(String text){
        System.out.println(text);
    }
   
    /**
     * prints error message
     */
    public void error(){
        System.out.println("\n(!) An error has ocurred");
    }

    /**
     * prints bye message
     */
    public void bye(){
        System.out.println("\nThanks for using ~ ACADEMIA EUROPEA TRANSLATOR ~\n");
    }

    /**
     * method that manages the menu with error controls
     * @return option
     * @throws Exception
     * @throws InputMismatchException
     */
    public int menu() throws Exception, InputMismatchException{
        int option = -1;
        boolean bandera = false;

        try{
            //prints the options 
            System.out.println("\nWhat do you want to do?");
            System.out.println("(1) Use translator");
            System.out.println("(2) See the dictionary");
            System.out.println("(3) Add a word to the dictionary");
            System.out.println("(4) Delete a word from the dictionary");
            System.out.println("(5) Modify a word from the dictionary");
            System.out.println("(6) Exit");

            //evaluates the correct options
            while (!bandera){
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 6) 
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

    /**
     * method that manages the languages wih error controls
     * @return language
     */
    public int languages(){
        int option = -1;
        boolean bandera = false;

        try{
            //print the options  
            System.out.println("\nWhich language do you want to use?");
            System.out.println("(1) English");
            System.out.println("(2) Spanish");
            System.out.println("(3) French");
            System.out.println("(4) Exit");
            
            //evaluates the correct options
            while (!bandera){ 
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 4)
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

    /**
     * prints the warnings messages
     */
    public void warnings(){
        System.out.println("\n------------------------------------");
        System.out.println("Be sure you have the following files");
        System.out.println("'dictionary.txt' and 'translate.txt'");
        System.out.println("------------------------------------\n");
    }

    public String word(){
        String word = " ";
        try{
            System.out.println("\nWrite the words to add");
            System.out.println("-------------------------------------------");
            System.out.println("Follow this format 'English,Spanish,French'");
            System.out.println("-------------------------------------------\n");
            word = scan.nextLine();
            System.out.println();

        } catch (InputMismatchException e){
            String s = "(!) Conversion failed" + word + ": " + e.toString(); 
            throw new InputMismatchException(s); 
        }
        return word;
    }

    public String delete(){
        String del = " ";
        try{
            System.out.println("\nWrite the words you want to delete");
            System.out.println("-------------------------------------------");
            System.out.println("Follow this format 'English,Spanish,French'");
            System.out.println("-------------------------------------------\n");
            del = scan.nextLine();
            System.out.println();

        } catch (InputMismatchException e){
            String s = "(!) Conversion failed" + del + ": " + e.toString(); 
            throw new InputMismatchException(s); 
        }
        return del;
    }

    public String modify(){
        String mod = " ";
        try{
            System.out.println("\nWrite the words you want to modify");
            System.out.println("-------------------------------------------");
            System.out.println("Follow this format 'English,Spanish,French'");
            System.out.println("-------------------------------------------\n");
            mod = scan.nextLine();
            System.out.println();

        } catch (InputMismatchException e){
            String s = "(!) Conversion failed" + mod + ": " + e.toString(); 
            throw new InputMismatchException(s); 
        }
        return mod;
    }
}