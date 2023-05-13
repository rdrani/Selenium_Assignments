package assignments.week3.day1.org.student;

import assignments.week3.day1.org.department.Department;

public class Student extends Department{
	public void studentName() {
		System.out.println("Inside Student -> Student Name: John");
	}
	public void studentDept() {
		System.out.println("Inside Student -> Student dept: IT");
	}
	public void studentId() {
		System.out.println("Inside Student -> Student Id: 25446");
	}
	public static void main(String[] args) {
		
		Student stud = new Student();
		stud.studentName();
		stud.studentDept();
		stud.studentId();
		stud.deptName();
		stud.collegeCode();
		stud.collegeName();
		stud.collegeRank();
	}

}
