package z.practice.object.ex5;

public class Run {
	public static void main(String[] args) {
		Student s1 = new Student(2, 4, "김철수", 178.2, 'F'); 
		Student s2 = new Student(1, 6, "박민지", 155.4, 'M'); 
		Student s3 = new Student(3, 1, "이민성", 188.2, 'F');
		
		s1.information();
		s2.information();
		s3.information();
	}
}
