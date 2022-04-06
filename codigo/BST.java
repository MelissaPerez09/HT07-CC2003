/** 
 * BST.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: 05/02/2022
    Clase vista que implementa el Binary Search Tree
    Se usó como referencia el siguiente enlace: 
*/

import java.util.ArrayList;

public class BST{

    class Node{
        ArrayList<String> key;
        Node left, right;
        
        public Node(ArrayList<String> item){ 
            key = item; left = right = null;
        }
    }

    Node root;

    BST(){
        root = null;
    }

    Node AgregarR(Node root, ArrayList<String> key){
        if (root == null) // En caso lo encuentre vacio, crea un nuevo nodo
        { root = new Node(key) ;return root; }
 
        if (key.get(0).compareTo(root.key.get(0))<0) // En caso si exista, realiza procesos
            root.left = AgregarR(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0))>0)
            root.right = AgregarR(root.right, key);
 
        /* Devuelve el pointer del nodo */
        return root;
    }

    void insertar(ArrayList<String> key){ 
        root = AgregarR( root, key ); 
    }

    void MostrarBSTOrdenado( Node root ){
        if ( root != null ){
            MostrarBSTOrdenado(root.left);
            System.out.println(root.key);
            MostrarBSTOrdenado(root.right);
        }
    }

    void Ordenado(){ 
        MostrarBSTOrdenado(root); 
    }
}