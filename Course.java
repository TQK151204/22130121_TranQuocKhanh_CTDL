package Lab_9;

import java.util.List;
import java.util.Objects;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> student;
	private String lecturer;

	public Course(String id, String title, String type, List<Student> student, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.student = student;
		this.lecturer = lecturer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lecturer, student, title, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(lecturer, other.lecturer)
				&& Objects.equals(student, other.student) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

}
