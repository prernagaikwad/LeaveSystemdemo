package com.prernagaikwad.springboot.LeaveSystemdemo.Rest;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import com.prernagaikwad.springboot.LeaveSystemdemo.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<String> createTeam(@RequestBody Team team) {
        try {
            Team createdTeam = teamService.createTeam(team);
            return ResponseEntity.ok("Team created successfully with ID: " + createdTeam.getId());
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while creating the team: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        try {
            Team updatedTeam = teamService.updateTeam(id, team);
            if (updatedTeam != null) {
                return ResponseEntity.ok("Team updated successfully with ID: " + updatedTeam.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while updating the team: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.ok("Team deleted successfully with ID: " + id);
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while deleting the team: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Team>> getTeamById(@PathVariable Long id) {
        try {
            Optional<Team> team = teamService.getTeamById(id);
            return team.isPresent() ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.status(500).body(Optional.empty());
        }
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        try {
            List<Team> teams = teamService.getAllTeams();
            return ResponseEntity.ok(teams);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }
}
