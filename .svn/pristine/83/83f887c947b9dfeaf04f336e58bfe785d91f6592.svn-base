package com.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//旅游路线
@Entity
@Table
public class TravelLines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;	//lineId
	
	@Column(length=256)
	private String lineContent; //主要内容
	
	@Column(length=150)
	private String coverImgPath; //列表那里的图片
	
	@Column(length=50)
	private String Title; //标题	
	
}
