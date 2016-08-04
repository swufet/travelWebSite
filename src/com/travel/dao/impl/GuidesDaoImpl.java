package com.travel.dao.impl;

import org.springframework.stereotype.Repository;

import com.travel.dao.GuidesDao;
import com.travel.entity.Guides;

@Repository
public class GuidesDaoImpl extends BaseDaoImpl implements GuidesDao{

	@Override
	public Class<?> classModel() {
		return Guides.class;
	}

}
