package Lab_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Faculty {
	private String name;
	private String address;
	private List<Course> course;
	public Faculty(String name, String address, List<Course> course) {
		super();
		this.name = name;
		this.address = address;
		this.course = course;
	}
	
	public Course getMaxPracticalCourse() {
		Course re = null;
		for(Course c : course) {
			if(c.getType().equals("TH")) {
				if(re == null) {
					re =c;
					
				}else if(c.getStudent().size() > re.getStudent().size()) {
					re =c;
					
					
				}
			}
		}
		return re;
	
	}
	public Map<Integer, List<Student>> groupStudentsByYear(){
		Map<Integer, List<Student> > re = new HashMap<>();
		for(Course c : course) {
			for(Student st : c.getStudent()) {
				int key = st.getYear();
				List<Student> value = new ArrayList<>();
				if(!re.containsKey(key)) {
					value.add(st);
				}else {
					value = re.get(key);
					if(!value.contains(st)) {
						value.add(st);
					}
				}
				re.put(key, value);
				
			}
			
			
		}
		return re;
		
	}
	public Set<Course> filterCourses(String type) {
        Set<Course> filteredCourses = new HashSet<>();

      
        for (Course c : course) {
            if (c.getType().equals(type)) {
                filteredCourses.add(c);
            }
        }

       
        List<Course> sortedCourses = filteredCourses.stream()
                .sorted(Comparator.comparingInt(c -> ((Course) c).getStudent().size()).reversed())
                .collect(Collectors.toList());

        return new HashSet<>(sortedCourses);
    }

    
	
	

}

