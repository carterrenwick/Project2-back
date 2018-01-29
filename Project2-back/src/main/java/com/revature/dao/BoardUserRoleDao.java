package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.BoardUserRole;

public interface BoardUserRoleDao extends JpaRepository<BoardUserRole,Integer> {

	 BoardUserRole findByCreateCardAndEditCardAndDeleteCardAndInviteUserAndRemoveUserAndCreateSwimLaneAndDeleteSwimLaneAndCreateTaskAndDeleteTask(
			boolean createC, boolean editC, boolean deleteC, boolean inviteU, boolean removeU, boolean createSL, boolean deleteSL, boolean createT, boolean deleteT);
}
