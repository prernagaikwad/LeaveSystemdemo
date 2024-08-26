package com.prernagaikwad.springboot.LeaveSystemdemo.DAO;


import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT t FROM Team t JOIN UserTeams ut ON t.id = ut.teamId WHERE ut.userId = :userId")
    List<Team> findTeamsByUserId(@Param("userId") Long userId);
}