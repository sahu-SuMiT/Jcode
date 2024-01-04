class Student{
	int rno;
	String name;
	float marks = 90;
	
	//we need another way to add the above values
	//properties object by object
	//one word access to every object is needed
	
	Student(){  //constructor for the student class
		this.rno = 13;
		this.name ="Kunal Kushwaha";
		this.marks = 88.5f;
	}
}

public class Constructor{
	public static void main(String[] args){
	
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println("this holds for s1");
		System.out.println(s1.rno);
		System.out.println(s1.name);
		System.out.println(s1.marks);
		
		System.out.println("this holds for s2");
		System.out.println(s2.rno);
		System.out.println(s2.name);
		System.out.println(s2.marks);
	}
}

//melissa@melissa:~$ java test
//this holds for s1
//13
//Kunal Kushwaha
//88.5
//this holds for s2
//13
//Kunal Kushwaha
//8.5
