package com.prernagaikwad.springboot.LeaveSystemdemo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Teams")
public class UserTeams {

    @Id

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "team_id")
    private Long teamId;

    public UserTeams()
    {

    }

    public UserTeams(Long userId, Long teamId) {
        this.userId = userId;
        this.teamId = teamId;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "UserTeams{" +
                "userId=" + userId +
                ", teamId=" + teamId +
                '}';
    }
}