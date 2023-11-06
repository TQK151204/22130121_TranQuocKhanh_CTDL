package Lab_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


import java.util.Iterator;

public class Clazz {
	private String name;
	private String year;
	private ArrayList<Student> students = new ArrayList<>();
	public Clazz(String name, String year, ArrayList<Student> students) {
		super();
		this.name = name;
		this.year = year;
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public ArrayList<Student> getStudents() {
		return students;
	}
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public void addStudent(Student student) {
		students.add(student);
		
	}
	public ArrayList<Student> getStudent(){
		return students;
		
	}
	
	public void loadStudents(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	         
	            String[] data = line.split(",");
	            
	            if (data.length >= 5) {
	                
	                String id = data[0].trim();
	                String firstName = data[1].trim();
	                String lastName = data[2].trim();
	                int birthYear = Integer.parseInt(data[3].trim());
	                double gpa = Double.parseDouble(data[4].trim());
	                
	               
	                Student student = new Student(id, firstName, lastName, birthYear, gpa);
	                students.add(student);
	            }
	        }
	    } catch (IOException e) {
	   
	        e.printStackTrace();
	    }
    
	}
	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		Collections.sort(students,c);		
	
	}
	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
	    if (n >= students.size()) {
	        return students;
	    }
	    
	    List<Student> sortedStudents = new ArrayList<>(students);

	    Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGPA).reversed();
	    sortedStudents.sort(gpaComparator);

	    List<Student> topNStudents = sortedStudents.subList(0, n);
	   
	    return new ArrayList<>(topNStudents);
	
	}
	// remove a student with a given id
	public boolean removeStudent(String id) {
		for (int i = 0; i < students.size(); i++) {
			if(students.get(i).getId().equals(id)) {
				students.remove(i);
				return true;
				
			}
		}
		return false;
	}
	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> studentsByBirthYear = new ArrayList<>();
	
		for(Student student : students) {
			if(student.getBirthYear() == birthYear) {
			studentsByBirthYear.add(student);
			
			}
		}
	
		return studentsByBirthYear;
	}
	
	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		if(n >= students.size()) {
			ArrayList<Student> shuffledStudents = new ArrayList<>(students);
			Collections.shuffle(shuffledStudents);
			return shuffledStudents;
			
		}else {
			ArrayList<Student> copyOfStudents = new ArrayList<>(students);
			
			ArrayList<Student> randomStudents = new ArrayList<>();
			
			Random random = new Random();
			while(randomStudents.size() < n) {
				int ramdomIndex = random.nextInt(copyOfStudents.size());
				randomStudents.add(copyOfStudents.remove(ramdomIndex));
				
			}
			
			return randomStudents;
		}
	
	}
	
	// similar as toString method, this method prints the
	//name, year, and all students of the class.
	//Note that, using iterator
	public void display() {
		System.out.println("Class Name: " + name);
	    System.out.println("Year: " + year);
	    
	    System.out.println("Students:");

	    Iterator<Student> studentIterator = students.iterator();
	    while (studentIterator.hasNext()) {
	        Student student = studentIterator.next();
	        System.out.println("ID: " + student.getId());
	        System.out.println("First Name: " + student.getFirstName());
	        System.out.println("Last Name: " + student.getLastName());
	        System.out.println("Birth Year: " + student.getBirthYear());
	        System.out.println("GPA: " + student.getGPA());
	        System.out.println();
	    }
		
	}



public static void main(String[] args) {
	    ArrayList<Student> students = new ArrayList<>(); 

	    Clazz myClass = new Clazz("ClassA", "2023", students);

	    myClass.loadStudents("student_data.txt"); 

	 
	    myClass.display();
	    
	    Comparator<Student> gpaComparator = Comparator.comparingDouble(Student::getGPA).reversed();

	  
	    myClass.sortStudents(gpaComparator);

	  
	    myClass.display();
	    
	    
	}
}
