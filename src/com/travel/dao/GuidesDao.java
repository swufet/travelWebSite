package com.travel.dao;

import java.util.List;

import com.travel.entity.Guides;

public interface GuidesDao extends BaseDao{
	public List<Guides> getAllByName();
	public List<Guides> getByName(String name);
}
