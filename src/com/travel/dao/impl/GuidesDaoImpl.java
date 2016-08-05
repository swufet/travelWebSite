package com.travel.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.sun.javafx.fxml.expression.Expression;
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

	@Override
	public List<Guides> getByName(String name) {
		List<Guides> list = this.createCriteria()
				.add(Property.forName("trueName").like("%"+name+"%"))
				.addOrder(Order.asc("trueName"))
				.list();
		return list.size() > 0 ? list : null;
	}

}
