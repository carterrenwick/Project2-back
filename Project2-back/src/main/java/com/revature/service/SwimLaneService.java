package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.SwimLaneDao;

@Service
public class SwimLaneService implements SwimLaneServiceContract
{
	@Autowired
	SwimLaneDao dao;

	@Override
	public void deleteSwimLane(int swid) 
	{
		dao.delete(swid);
	}

}
