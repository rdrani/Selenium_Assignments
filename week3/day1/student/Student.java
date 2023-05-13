package assignments.week3.day1.student;

public class Student {

	public static void main(String[] args) {
		Student stud = new Student();
		stud.getStudentInfo(1001);
		stud.getStudentInfo(1001, "John");
		stud.getStudentInfo("john@google.com", 9876543210l);
	}
	public void getStudentInfo(int id) {
		System.out.println("Id: "+id);
	}
	public void getStudentInfo(int id, String name) {
		System.out.println("Id: "+id+", Name: "+name);
	}
	public void getStudentInfo(String email, long phoneNo) {
		System.out.println("Email: "+email+", Phone no: "+phoneNo);
	}
}
