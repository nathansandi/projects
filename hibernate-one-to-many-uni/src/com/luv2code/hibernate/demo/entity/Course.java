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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")

public class Course {
	//define fields and notations
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, 
    		CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
	public Instructor instructor;

    //unidirectional
    @OneToMany(fetch=FetchType.LAZY 
    		,cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    public List<Review> review;
    
    
    public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Course() {
		
	}
	
	public Course(String title) {
		
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	public void add(Review tempReview) {
		if(review == null) {
			review = new ArrayList<>();
		}
		review.add(tempReview);
		
	}
}
