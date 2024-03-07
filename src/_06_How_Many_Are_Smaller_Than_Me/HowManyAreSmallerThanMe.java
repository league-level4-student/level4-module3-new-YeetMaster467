package _06_How_Many_Are_Smaller_Than_Me;

import java.util.ArrayList;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {
    	int howMany = 0;
    	System.out.println(me);
    	ArrayList<AVLNode<Integer>> list = new ArrayList<AVLNode<Integer>>();
    	AVLNode<Integer> root = avlTree.getRoot();
    	list.add(root);
    	
    	while (!list.isEmpty()) {
    		AVLNode<Integer> n = list.remove(0);
    		list.add(n.getLeft());
    		if (list.get(list.size()).getValue() < me) {
    			howMany ++;
    		}
    		list.add(n.getRight());
    		if (list.get(list.size()).getValue() < me) {
    			howMany++;
    		}
    	}
    	
        return howMany;

    }
    
   
}
