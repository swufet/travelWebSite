package com.travel.dao.impl;

import org.springframework.stereotype.Repository;

import com.travel.dao.TravelLinesDao;
import com.travel.entity.TravelLines;
@Repository
public class TravelLinesDaoImpl extends BaseDaoImpl implements TravelLinesDao{
	
	@Override
	public Class<?> classModel() {
		// TODO Auto-generated method stub
		return TravelLines.class;
	}

}
