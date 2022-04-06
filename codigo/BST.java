/** 
 * BST.java
 * @author Emily ELvia Melissa Pérez Alarcón - 21385
 * Curso: Algoritmos y estructuras de datos
    @version: 
        - Creación: 04/04/2022
        - Ultima modificación: 06/02/2022
    Clase vista que implementa el Binary Search Tree
    Se usó como referencia el siguiente enlace: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/ 
*/

import java.util.ArrayList;

public class BST{

    //class that founds the left and right child of the key value
    class Node{
        ArrayList<String> key;
        Node left, right;
        
        public Node(ArrayList<String> item){ 
            key = item; 
            left = right = null;
        }
    }

    //root of BST
    Node root;

    //constructor
    BST(){
        root = null;
    }

    /**
     * Recursive method to insert a new key
     * @param root
     * @param key
     * @return
     */
    Node add(Node root, ArrayList<String> key){
        //if node is empty returns a new node
        if (root == null){
            root = new Node(key);
            return root; 
        }
 
        //if node exists recurs the tree
        if (key.get(0).compareTo(root.key.get(0))<0)
            root.left = add(root.left, key);
        else if (key.get(0).compareTo(root.key.get(0))>0)
            root.right = add(root.right, key);
 
        //returns the pointer
        return root;
    }

    /**
     * 
     * @param key
     */
    void insert(ArrayList<String> key){ 
        root = add( root, key ); 
    }

    /**
     * function to order the BST
     * @param root
     */
    void inOrderBST( Node root ){
        if ( root != null ){
            inOrderBST(root.left);
            System.out.println(root.key);
            inOrderBST(root.right);
        }
    }

    /**
     * function that calls the function
     */
    void inOrder(){ 
        inOrderBST(root); 
    }
}