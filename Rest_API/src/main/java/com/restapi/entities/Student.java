package com.restapi.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_Info")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String studentName;
	private String studentMail;
	private String collegeName;
	private String address;
	private int age;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMail() {
		return studentMail;
	}
	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(int studentId, String studentName, String studentMail, String collegeName, String address, int age) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMail = studentMail;
		this.collegeName = collegeName;
		this.address = address;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMail=" + studentMail
				+ ", collegeName=" + collegeName + ", address=" + address + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
	

	
	
	
}
