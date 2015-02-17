package com.homeward.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "FB_USER_ID")
	private Long fbUserId;

	@Column(name = "AGE")
	private Integer age;

	@OneToOne
	@MapsId
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;

	@Column(name = "LINKEDIN_URL")
	private String linkedInUrl;

	private Boolean emailIsVerfied;

	private String photoProfileUrl;
/*
	@OneToOne
	@MapsId
	@JoinColumn(name = "UNIVERSITY_ID")
	private University university;
*/
	@OneToOne
	@MapsId
	@JoinColumn(name = "HOMETOWN_ZIP")
	private ZipCode hometownZip;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@Column(name = "LIFESTYLE")
	private String lifestyle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Long getFbUserId() {
		return fbUserId;
	}

	public void setFbUserId(Long fbUserId) {
		this.fbUserId = fbUserId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public Boolean getEmailIsVerfied() {
		return emailIsVerfied;
	}

	public void setEmailIsVerfied(Boolean emailIsVerfied) {
		this.emailIsVerfied = emailIsVerfied;
	}

	public String getPhotoProfileUrl() {
		return photoProfileUrl;
	}

	public void setPhotoProfileUrl(String photoProfileUrl) {
		this.photoProfileUrl = photoProfileUrl;
	}
/*
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
*/
	public ZipCode getHometownZip() {
		return hometownZip;
	}

	public void setHometownZip(ZipCode hometownZip) {
		this.hometownZip = hometownZip;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getLifestyle() {
		return lifestyle;
	}

	public void setLifestyle(String lifestyle) {
		this.lifestyle = lifestyle;
	}
}
