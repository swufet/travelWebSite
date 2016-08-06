package com.travel.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.travel.dao.PwdDao;
import com.travel.entity.Pwd;
@Repository
public class PwdDaoImpl extends BaseDaoImpl implements PwdDao {

	@Override
	public Class<?> classModel() {
		return Pwd.class;
	}
}
