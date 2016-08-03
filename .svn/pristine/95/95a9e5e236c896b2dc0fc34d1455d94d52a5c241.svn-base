package com.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//公司活动页
@Entity
@Table
public class Guides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;	//guideId
	
	@Column(length=20)
	private String trueName;	//真实名字
	
	@Column(length=20)
	private String alias;	//艺名
	
	@Column(length=150)
	private String coverImgPath; //导游头像图片
	
	@Column(length=256)
	private String introduction; //导游介绍
}
