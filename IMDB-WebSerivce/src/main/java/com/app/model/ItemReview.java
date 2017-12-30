package com.app.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the item_review database table.
 * 
 */
@Entity
@Table(name="item_review")
@NamedQuery(name="ItemReview.findAll", query="SELECT i FROM ItemReview i")
public class ItemReview implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long itemId;

	/** The action. */
	@Column(name="action")
	private String action;

	/** The adventure. */
	@Column(name="adventure")
	private String adventure;

	/** The animation. */
	@Column(name="animation")
	private String animation;

	/** The childrens. */
	@Column(name="childrens")
	private String childrens;

	/** The comedy. */
	@Column(name="comedy")
	private String comedy;

	/** The crime. */
	@Column(name="crime")
	private String crime;

	/** The documentary. */
	@Column(name="documentary")	
	private String documentary;

	/** The drama. */
	@Column(name="drama")
	private String drama;

	/** The fantasy. */
	@Column(name="fantasy")
	private String fantasy;

	/** The filmNoir. */
	@Column(name="film_noir")
	private String filmNoir;

	/** The horror. */
	@Column(name="horror")
	private String horror;

	/** The musical. */
	@Column(name="musical")
	private String musical;

	/** The mystery. */
	@Column(name="mystery")
	private String mystery;

	/** The romance. */
	@Column(name="romance")
	private String romance;

	/** The sciFi. */
	@Column(name="sci_fi")
	private String sciFi;

	/** The thriller. */
	@Column(name="thriller")
	private String thriller;

	/** The war. */
	@Column(name="war")
	private String war;

	/** The western. */
	@Column(name="western")
	private String western;

	/**
	 * @return the itemId
	 */
	public Long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the adventure
	 */
	public String getAdventure() {
		return adventure;
	}

	/**
	 * @param adventure the adventure to set
	 */
	public void setAdventure(String adventure) {
		this.adventure = adventure;
	}

	/**
	 * @return the animation
	 */
	public String getAnimation() {
		return animation;
	}

	/**
	 * @param animation the animation to set
	 */
	public void setAnimation(String animation) {
		this.animation = animation;
	}

	/**
	 * @return the childrens
	 */
	public String getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(String childrens) {
		this.childrens = childrens;
	}

	/**
	 * @return the comedy
	 */
	public String getComedy() {
		return comedy;
	}

	/**
	 * @param comedy the comedy to set
	 */
	public void setComedy(String comedy) {
		this.comedy = comedy;
	}

	/**
	 * @return the crime
	 */
	public String getCrime() {
		return crime;
	}

	/**
	 * @param crime the crime to set
	 */
	public void setCrime(String crime) {
		this.crime = crime;
	}

	/**
	 * @return the documentary
	 */
	public String getDocumentary() {
		return documentary;
	}

	/**
	 * @param documentary the documentary to set
	 */
	public void setDocumentary(String documentary) {
		this.documentary = documentary;
	}

	/**
	 * @return the drama
	 */
	public String getDrama() {
		return drama;
	}

	/**
	 * @param drama the drama to set
	 */
	public void setDrama(String drama) {
		this.drama = drama;
	}

	/**
	 * @return the fantasy
	 */
	public String getFantasy() {
		return fantasy;
	}

	/**
	 * @param fantasy the fantasy to set
	 */
	public void setFantasy(String fantasy) {
		this.fantasy = fantasy;
	}

	/**
	 * @return the filmNoir
	 */
	public String getFilmNoir() {
		return filmNoir;
	}

	/**
	 * @param filmNoir the filmNoir to set
	 */
	public void setFilmNoir(String filmNoir) {
		this.filmNoir = filmNoir;
	}

	/**
	 * @return the horror
	 */
	public String getHorror() {
		return horror;
	}

	/**
	 * @param horror the horror to set
	 */
	public void setHorror(String horror) {
		this.horror = horror;
	}

	/**
	 * @return the musical
	 */
	public String getMusical() {
		return musical;
	}

	/**
	 * @param musical the musical to set
	 */
	public void setMusical(String musical) {
		this.musical = musical;
	}

	/**
	 * @return the mystery
	 */
	public String getMystery() {
		return mystery;
	}

	/**
	 * @param mystery the mystery to set
	 */
	public void setMystery(String mystery) {
		this.mystery = mystery;
	}

	/**
	 * @return the romance
	 */
	public String getRomance() {
		return romance;
	}

	/**
	 * @param romance the romance to set
	 */
	public void setRomance(String romance) {
		this.romance = romance;
	}

	/**
	 * @return the sciFi
	 */
	public String getSciFi() {
		return sciFi;
	}

	/**
	 * @param sciFi the sciFi to set
	 */
	public void setSciFi(String sciFi) {
		this.sciFi = sciFi;
	}

	/**
	 * @return the thriller
	 */
	public String getThriller() {
		return thriller;
	}

	/**
	 * @param thriller the thriller to set
	 */
	public void setThriller(String thriller) {
		this.thriller = thriller;
	}

	/**
	 * @return the war
	 */
	public String getWar() {
		return war;
	}

	/**
	 * @param war the war to set
	 */
	public void setWar(String war) {
		this.war = war;
	}

	/**
	 * @return the western
	 */
	public String getWestern() {
		return western;
	}

	/**
	 * @param western the western to set
	 */
	public void setWestern(String western) {
		this.western = western;
	}
}