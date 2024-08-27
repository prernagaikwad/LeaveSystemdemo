package com.prernagaikwad.springboot.LeaveSystemdemo.Rest;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.User;
import com.prernagaikwad.springboot.LeaveSystemdemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok("User created successfully with ID: " + createdUser.getId());
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while creating the user: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            if (updatedUser != null) {
                return ResponseEntity.ok("User updated successfully with ID: " + updatedUser.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while updating the user: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully with ID: " + id);
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while deleting the user: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        try {
            Optional<User> user = userService.getUserById(id);
            return user.isPresent() ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.status(500).body(Optional.empty());
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }

    @PostMapping("/{userId}/teams/{teamId}")
    public ResponseEntity<String> addUserToTeam(@PathVariable Long userId, @PathVariable Long teamId) {
        try {
            userService.addUserToTeam(userId, teamId);
            return ResponseEntity.ok("User added to team successfully.");
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while adding the user to the team: " + e.getMessage());
        }
    }

    @DeleteMapping("/{userId}/teams/{teamId}")
    public ResponseEntity<String> removeUserFromTeam(@PathVariable Long userId, @PathVariable Long teamId) {
        try {
            userService.removeUserFromTeam(userId, teamId);
            return ResponseEntity.ok("User removed from team successfully.");
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while removing the user from the team: " + e.getMessage());
        }
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<List<User>> getUsersByTeamId(@PathVariable Long teamId) {
        try {
            List<User> users = userService.getUsersByTeamId(teamId);
            return ResponseEntity.ok(users);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }

    @GetMapping("/{userId}/teams")
    public ResponseEntity<List<Team>> getTeamsByUserId(@PathVariable Long userId) {
        try {
            List<Team> teams = userService.getTeamsByUserId(userId);
            return ResponseEntity.ok(teams);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }
}
