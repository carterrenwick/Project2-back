package com.revature.comparator;

import java.util.Comparator;

import com.revature.model.SwimLane;

public class SwimLaneComparator implements Comparator<SwimLane> {

	@Override
	public int compare(SwimLane o1, SwimLane o2) {
		//ascending order
		return o1.getOrder() - o2.getOrder();
	}

	
}
