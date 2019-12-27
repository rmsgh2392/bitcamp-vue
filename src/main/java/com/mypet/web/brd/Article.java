package com.mypet.web.brd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.mypet.web.person.Person;

import lombok.Data;

@Data
@Entity
@Table(name ="ARTICLES")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ARTICLESEQ", nullable=false) private Long articleseq;
	@Column(name = "USERID",nullable=false) private String userid;
	@Column(name = "IMAGE",nullable=false) private String image;
	@Column(name = "COMMENTS",nullable=false) private String comments;
	@Column(name = "MSG",nullable=false) private String msg;
	@Column(name = "RATING",nullable=false) private String rating;
	@Column(name = "CATEGORY",nullable=false) private String category;
	@Column(name = "HASHTAG",nullable=false) private String hasgtag;
	@Column(name = "CONTENT",nullable=false) private String content;
}
