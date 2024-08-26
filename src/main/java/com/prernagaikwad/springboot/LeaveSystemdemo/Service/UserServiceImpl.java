package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.DAO.TeamRepository;
import com.prernagaikwad.springboot.LeaveSystemdemo.DAO.UserRepository;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUserToTeam(Long userId, Long teamId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Team> teamOpt = teamRepository.findById(teamId);

        if (userOpt.isPresent() && teamOpt.isPresent()) {
            User user = userOpt.get();
            Team team = teamOpt.get();
            user.getTeams().add(team);
            userRepository.save(user);
        }
    }

    @Override
    public void removeUserFromTeam(Long userId, Long teamId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Team> teamOpt = teamRepository.findById(teamId);

        if (userOpt.isPresent() && teamOpt.isPresent()) {
            User user = userOpt.get();
            Team team = teamOpt.get();
            user.getTeams().remove(team);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getUsersByTeamId(Long teamId) {
        return userRepository.findUsersByTeamId(teamId);
    }

    @Override
    public List<Team> getTeamsByUserId(Long userId) {
        return teamRepository.findTeamsByUserId(userId);
    }
}
