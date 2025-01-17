package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
		//define the fields
		//annotate the fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		@Column(name="first_name")
		private String first_name;
		@Column(name="last_name")
		private String last_name;		
		
		@Column(name="email")
		private String email;
		
		@OneToMany(fetch=FetchType.LAZY ,
				mappedBy="instructor",cascade = {CascadeType.PERSIST,CascadeType.MERGE, 
	    		CascadeType.DETACH, CascadeType.REFRESH})
		private List<Course> courses;
		//setup the relation between the instructordetail entity 
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="instructor_detail_id")
		private InstructorDetail instructorDetail;
		//create constructor
		public Instructor() {

		}
		
		public Instructor(String first_name, String last_name, String email) {
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
		}

		//get and set
		
		public String getFirst_name() {
			return first_name;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public InstructorDetail getInstructorDetail() {
			return instructorDetail;
		}

		public void setInstructorDetail(InstructorDetail instructorDetail) {
			this.instructorDetail = instructorDetail;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}

		@Override
		public String toString() {
			return "Instructor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
					+ email + ", instructorDetail=" + instructorDetail + "]";
		}
		
		//add convenience method for bidirectional
		
		public void add(Course tempCourse) {
			if(courses == null) {
				courses = new ArrayList<>();
			}
			courses.add(tempCourse);
			tempCourse.setInstructor(this);
		}

}
