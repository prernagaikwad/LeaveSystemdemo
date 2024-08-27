package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.User;
import java.util.List;
import java.util.Optional;


public interface UserService
{
    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    void addUserToTeam(Long userId, Long teamId);

    void removeUserFromTeam(Long userId, Long teamId);

    List<User> getUsersByTeamId(Long teamId);

    List<Team> getTeamsByUserId(Long userId);
}
