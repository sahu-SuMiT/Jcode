class Student{
	int rno;
	String name;
	float marks = 90;
	
	//we need another way to add the above values
	//properties object by object
	//one word access to every object is needed
	
	void greeting(){
	System.out.println("Hello world! this is "+name);
	}
	
	void changeName(String name){
		this.name=name;
	}
	
	Student(){  //constructor for the student class
		this.rno = 13;
		this.name ="Kunal Kushwaha";
		this.marks = 88.5f;
	}
	
	Student(int rno, String name, float marks){
		this.rno= rno;
		this.name= name;
		this.marks = marks;
	}
	
	Student(){//this is how you call a constructor from another constructor
		  //internally new student(13,"default person",59);
		this(13,"default person",59);
	}
	
	Student(Student other){
		this.name = other.name;
		this.rno = other.rno;
		this.marks = other.marks;
	}
	
	
}

public class oopConstructor{
	public static void main(String[] args){
	
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student(3,"Pratigya",89.4f);
		
		System.out.println("this holds for s1");
		System.out.println(s1.rno);
		System.out.println(s1.name);
		System.out.println(s1.marks);
		
		System.out.println("this holds for s2");
		System.out.println(s2.rno);
		s2.changeName("Anuj");
		System.out.println(s2.name);
		System.out.println(s2.marks);
		
		System.out.println("this is greeting frome s2: ");
		s2.greeting();
		System.out.println("this is greeting frome s1: ");
		s1.greeting();
		
		System.out.println();
		System.out.println("this holds for s3");
		System.out.println(s3.rno);
		System.out.println(s3.name);
		System.out.println(s3.marks);
		
		Student s4 = new Student(s3);
		
		System.out.println();
		System.out.println("this holds for s4");
		System.out.println(s4.rno);
		System.out.println(s4.name);
		System.out.println(s4.marks);
		
		
		
	}
}
//melissa@melissa:~$ java test
// this holds for s1
// 13
// default person
// 59.0
// this holds for s2
// 13
// Anuj
// 59.0
// this is greeting frome s2: 
// Hello world! this is Anuj
// this is greeting frome s1: 
// Hello world! this is default person

// this holds for s3
// 3
// Pratigya
// 89.4

// this holds for s4
// 3
// Pratigya
// 89.4
