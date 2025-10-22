package lab4;

import java.util.*;

/**Creates a MyBinaryTree object that stores unsorted nodes in a binary tree.
 * @param <E> the data type of the elements in the tree
 * @author Abby Pitcairn
 * @version October 18, 2025
 */
public class MyBinaryTree<E extends Comparable<E>> {
    
    /**Root Node of the tree*/
    protected Node<E> root;
    
    /**Nested class for a Node object
     * @param <E> the data type of the element in the node
     */
    protected static class Node<E>{
        E data;
        Node<E> left;
        Node<E> right;
        
        Node(E data){
            this.data = data;
        }
    }
    
    /**Recursively searches for the next available insertion spot
     * and inserts a new node with the given value to that space
     * in the tree.
     * @param value - the value to insert into the tree.
     */
    public void insert(E value) {
        root = insertRecursively(root, value);
    }

    /** Recursive helper for insertion.
     * @param current - the current Node being evaluated.
     * @param value - the value to insert into the tree.
     */
    private Node<E> insertRecursively(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }
        if (value.compareTo(current.data) < 0) {
            current.left = insertRecursively(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = insertRecursively(current.right, value);
        }
        return current;
    }
    
    /** Helper function to quickly build a tree from a List of elements.
     * @param elements - a List of data type E to be added to the tree.
     */
    public void buildTree(List<E> elements) {
        for (E element : elements) {
            insert(element);
        }
    }

    /** executes a breadth first search and then prints each value when its accessed
     */
    public void bfsPrintSearch() {
    	if (root == null) {
    		return;
    	}
    	Queue<Node<E>> q = new ArrayDeque<Node<E>>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		Node<E> node = q.remove();
    		System.out.print(node.data + " ");
    		if (node.left != null) {
    			q.add(node.left);
    		}
    		if (node.right != null) {
    			q.add(node.right);
    		}
    	}
    	System.out.println();
    }
    
    /** finds a target value in the binary tree
     * @param x - the value we are searching for
     * @return boolean of if the value is found.
     */
    public boolean search(E x) {
    	return searchHelper(root, x);
    }
    
    /** Recursive helper for search.
     * @param node - the current node we are checking
     * @param x - the value we are searching for
     * @return boolean of if the value is found.
     */
    private boolean searchHelper(Node<E> node, E x) {
    	if (node == null) {
    		return false;
    	} if (node.data.compareTo(x) == 0) {
    		return true;
    	} else if (node.data.compareTo(x) > 0) {
    		return searchHelper(node.left, x);
    	} else {
    		return searchHelper(node.right, x);
    	}
    }
}
