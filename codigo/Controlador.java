/** 
 * Controlador.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: --/02/2022
    Clase controlador que ejecuta el main
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class Controlador{

    public static void main(String[] args) throws Exception{
        Vista vis = new Vista();
        BST bst = new BST();
        ArrayList<String>text = new ArrayList<>();
        ArrayList<ArrayList<String>>dictionary = new ArrayList<ArrayList<String>>();
        boolean flag = true;

        vis.welcome();
        vis.warnings();

        try {
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
        } catch (FileNotFoundException e) {
            vis.message("(!) An error has ocurred 'dictionary.txt' not found");
        }

        try {
            File data = new File("translate.txt");
            Scanner reader = new Scanner(data); 
            while (reader.hasNextLine()){
                String LineasEnArchivo = reader.nextLine();
                String[] SeparacionPorEspacio = LineasEnArchivo.split(" ");

                for( int i=0;i<SeparacionPorEspacio.length;i++ ){ 
                    text.add(SeparacionPorEspacio[i]); 
                }
            }
        } catch (FileNotFoundException e) {
            vis.message("(!) An error has ocurred 'translate.txt' not found");
        }

        for(ArrayList<String> searchWord: dictionary){ 
            bst.insertar(searchWord); 
        }

        try {
            vis.message("\n----------------------------------");
            vis.message("  Here's the dictionary in order");
            vis.message("----------------------------------\n");
            bst.Ordenado();

            int option = vis.menu();
            while(option != 3){
                if(option == 1){
                    int chooseLanguage = vis.languages();

                    switch(chooseLanguage){
                        case 1:
                            for(int i=0;i<dictionary.size();i++){    
                                for(int j=0;j<text.size();j++){
                                    if(dictionary.get(i).contains(text.get(j))){
                                        text.set(j, dictionary.get(i).get(0));
                                    }
                                }
                            }
                        break;

                        case 2:
                            for(int i=0;i<dictionary.size();i++){    
                                for(int j=0;j<text.size();j++){
                                    if(dictionary.get(i).contains(text.get(j))){
                                        text.set(j, dictionary.get(i).get(1));
                                    }
                                }
                            }
                        break;

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

                    vis.message("\n-----------------------------------");
                    vis.message(" The following is your translation");
                    vis.message("-----------------------------------\n");
                
                    String translation = "";
                    text.set(text.size()-1,(text.get(text.size()-1)));

                    // Ciclo for para las palabras traducidas.
                    for(int i=0;i<text.size();i++){
                        translation += (text.get(i) + " ");
                    }
                    vis.message(translation);
                }
                
                else{
                    vis.bye();
                    break;
                }
            }
        } catch (Exception e) {
            vis.error();
        }
    }
}