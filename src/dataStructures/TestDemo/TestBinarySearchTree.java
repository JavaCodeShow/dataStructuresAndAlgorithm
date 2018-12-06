package dataStructures.TestDemo;

import ListAndStackAndQueue.BinarySearchTree;

public class TestBinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
//		int [] arr = {1,4,1};
//		for (int i : arr) {
//			System.out.println(i);
//		}
		bst.insert(5);
		bst.insert(3);
		bst.insert(2);
		bst.insert(4);
		bst.insert(9);
		bst.insert(10);
		bst.insert(8);
//		System.out.println(bst.isEmpty());
		System.out.println(bst.contains(5));
		int min = bst.findMin();
		System.out.println("min = " + min);
		bst.remove(2);
		
		
		
	}
}
