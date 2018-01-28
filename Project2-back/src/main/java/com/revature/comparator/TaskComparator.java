package com.revature.comparator;

import java.util.Comparator;

import com.revature.model.Task;

public class TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		//ascending order
		return o1.getOrder() - o2.getOrder();
	}

	
}
