package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.DAO.TeamRepository;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Long id, Team team) {
        if (teamRepository.existsById(id)) {
            team.setId(id);
            return teamRepository.save(team);
        }
        return null;
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}