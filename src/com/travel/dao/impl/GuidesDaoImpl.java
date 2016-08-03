package com.travel.dao.impl;

import org.springframework.stereotype.Repository;
import com.travel.entity.Guides;

@Repository
public class GuidesDaoImpl extends BaseDaoImpl {

	@Override
	public Class<?> classModel() {
		return Guides.class;
	}

}
