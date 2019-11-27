package datastructures.ListAndStackAndQueue;

import java.util.HashMap;
import java.util.Map;

class Student {
	private String name;

	Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}

public class AboutSet {
	public static void main(String[] args) {
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("haha"),"1");
		System.out.println(map);	
		System.out.println(map.get(new Student("haha")));
	}
}
