package com.prernagaikwad.springboot.LeaveSystemdemo.DAO;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u JOIN UserTeams ut ON u.id = ut.userId where ut.teamId = :teamId")
    List<User> findUsersByTeamId(@Param("teamId") Long teamId);
}
