package datastructures.ListAndStackAndQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleList {
	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		Iterator itr = list.iterator();
		long start = System.currentTimeMillis();
		while (itr.hasNext()) {
			if(itr.next().equals(10000)) {
				itr.remove();
			}
//			System.out.println(itr.next());
		}
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
	}
	
}
