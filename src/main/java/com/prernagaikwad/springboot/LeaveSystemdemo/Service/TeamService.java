package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team createTeam(Team team);

    Team updateTeam(Long id, Team team);

    void deleteTeam(Long id);

    Optional<Team> getTeamById(Long id);

    List<Team> getAllTeams();
}