package com.homeward.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class Listing implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICING")
	private Integer pricing;

	@Column(name = "ADDRESS")
	private String address;

	@OneToOne
	@MapsId
	@JoinColumn(name = "ZIP")
	private ZipCode zipCode;

	@Column(name = "PHOTO_FOLDER")
	private String photoFolder;

	// TODO: Create amenitieis fk
	@Column(name = "AMENITIES_ID")
	private Integer amentiesId;

	// TODO: Create points of interest fk
	@Column(name = "POINTS_OF_INTEREST_ID")
	private Integer pointsOfInterestId;

	@Column(name = "LATITUDE")
	private Double latitude;

	@Column(name = "LONGITUDE")
	private Double longitude;

	@Column(name = "IS_AVAILABLE")
	private Boolean isAvailable;

	@Column(name = "HOUSE_RULES")
	private String houseRules;

	@Column(name = "LOOKING_FOR")
	private String lookingFor;

	@Column(name = "DATE_START")
	private Date dateStart;

	@Column(name = "DATE_END")
	private Date dateEnd;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPricing() {
		return pricing;
	}

	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ZipCode getZipCode() {
		return zipCode;
	}

	public void setZipCode(ZipCode zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhotoFolder() {
		return photoFolder;
	}

	public void setPhotoFolder(String photoFolder) {
		this.photoFolder = photoFolder;
	}

	public Integer getAmentiesId() {
		return amentiesId;
	}

	public void setAmentiesId(Integer amentiesId) {
		this.amentiesId = amentiesId;
	}

	public Integer getPointsOfInterestId() {
		return pointsOfInterestId;
	}

	public void setPointsOfInterestId(Integer pointsOfInterestId) {
		this.pointsOfInterestId = pointsOfInterestId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getHouseRules() {
		return houseRules;
	}

	public void setHouseRules(String houseRules) {
		this.houseRules = houseRules;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookingFor) {
		this.lookingFor = lookingFor;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
}
