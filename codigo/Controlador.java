/** 
 * Controlador.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: 06/02/2022
    Clase controlador que ejecuta el main
*/

//imported libraries
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class Controlador{
    /**
     * main method to execute the program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Vista vis = new Vista();
        BST bst = new BST();
        ArrayList<String>text = new ArrayList<>();
        ArrayList<ArrayList<String>>dictionary = new ArrayList<ArrayList<String>>();
        boolean flag = true;

        vis.welcome();
        vis.warnings();

        try {
            //starts reading the file 'dictionary.txt'
            File data = new File("dictionary.txt");
            Scanner reader = new Scanner(data); 
            while (reader.hasNextLine()){
                String LineasEnArchivo = reader.nextLine();
                String[] SeparacionPorComa = LineasEnArchivo.split(",");
                ArrayList<String> ArrayConInfoSeparada = new ArrayList<>();

                for(int i=0;i<SeparacionPorComa.length;i++){ 
                    ArrayConInfoSeparada.add(SeparacionPorComa[i]); 
                }
                dictionary.add(ArrayConInfoSeparada);   
            }
            //catches the error if file not found
        } catch (FileNotFoundException e) {
            vis.message("(!) An error has ocurred 'dictionary.txt' not found");
        }

        try {
            //starts reading the file 'translate.txt'
            File data = new File("translate.txt");
            Scanner reader = new Scanner(data); 
            while (reader.hasNextLine()){
                String LineasEnArchivo = reader.nextLine();
                String[] SeparacionPorEspacio = LineasEnArchivo.split(" ");

                for( int i=0;i<SeparacionPorEspacio.length;i++ ){ 
                    text.add(SeparacionPorEspacio[i]); 
                }
            }
            //catches the error if file not found
        } catch (FileNotFoundException e) {
            vis.message("(!) An error has ocurred 'translate.txt' not found");
        }

        //uses de binary search tree to search the words
        for(ArrayList<String> searchWord: dictionary){ 
            bst.insert(searchWord); 
        }

        try {
            //shows the dictionary in order
            vis.message("\n----------------------------------");
            vis.message("  Here's the dictionary in order");
            vis.message("----------------------------------\n");
            bst.inOrder();

            //starts the menu 
            int option = vis.menu();
            while(option != 3){

                //option of translator
                if(option == 1){
                    //choosing the language
                    int chooseLanguage = vis.languages();
                    switch(chooseLanguage){
                        
                        //English
                        case 1:
                            for(int i=0;i<dictionary.size();i++){    
                                for(int j=0;j<text.size();j++){
                                    if(dictionary.get(i).contains(text.get(j))){
                                        text.set(j, dictionary.get(i).get(0));
                                    }
                                }
                            }
                        break;

                        //Spanish
                        case 2:
                            for(int i=0;i<dictionary.size();i++){    
                                for(int j=0;j<text.size();j++){
                                    if(dictionary.get(i).contains(text.get(j))){
                                        text.set(j, dictionary.get(i).get(1));
                                    }
                                }
                            }
                        break;

                        //French
                        case 3:
                            for(int i=0;i<dictionary.size();i++){    
                                for(int j=0;j<text.size();j++){
                                    if(dictionary.get(i).contains(text.get(j))){
                                        text.set(j, dictionary.get(i).get(2));
                                    }
                                }
                            }
                        break;
                    }

                    //option for 'exit'
                    if(chooseLanguage == 4){
                        vis.bye();
                        break;
                    }

                    vis.message("\n-----------------------------------");
                    vis.message(" The following is your translation");
                    vis.message("-----------------------------------\n");
                
                    //string for the translation
                    String translation = "";
                    text.set(text.size()-1,(text.get(text.size()-1)));

                    //evaluates the words to translate
                    for(int i=0;i<text.size();i++){
                        translation += (text.get(i) + " ");
                    }

                    //prints the translation text in the language
                    vis.message(translation);
                }
                
                //'exit' option
                else{
                    vis.bye();
                    break;
                }
            }

            //catches the error if option in not an int
        } catch (Exception e) {
            vis.error();
        }
    }
}