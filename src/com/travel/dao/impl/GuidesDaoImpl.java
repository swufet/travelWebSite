package com.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.travel.dao.GuidesDao;
import com.travel.entity.Guides;

@Repository
public class GuidesDaoImpl extends BaseDaoImpl implements GuidesDao{

	@Override
	public Class<?> classModel() {
		return Guides.class;
	}

	@Override
	public List<Guides> getAllByName() {
		List list = this.createCriteria()
				.addOrder(Order.asc("trueName"))
				.list();
		return list.size() > 0 ? list : null;
	}

}
