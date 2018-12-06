package dataStructures.ListAndStackAndQueue;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 用单链表来实现栈，
 * 栈的特点：先进后出
 * @author 潇潇暮雨
 *
 */
public class LinkedStack<anyType> {
	private List<anyType> list = null;
	public LinkedStack() {
		list = new LinkedList<anyType>();
	}
	
	public void add(anyType at) {
		list.add(0, at);
	}
	public anyType get(int index) {
		return list.get(index);
	}
	public String toString() {
		return "LinkedStack [list=" + list + "]";
	}

	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		ls.add("2");
		ls.add("1");
		ls.add("6");
		System.out.println(ls.get(0));
	}
}
