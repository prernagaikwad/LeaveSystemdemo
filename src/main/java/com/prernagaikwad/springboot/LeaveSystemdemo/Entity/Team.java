package com.prernagaikwad.springboot.LeaveSystemdemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "team_name", unique = true, nullable = false)
    private String teamName;

    @Column(name = "team_lead")
    private String teamLead;

    @ManyToMany(mappedBy = "teams")

    @JsonIgnore
    private Set<User> users;


    // constructor
    public  Team()
    {

    }

    public Team(String teamName, String teamLead, Set<User> users) {
        this.teamName = teamName;
        this.teamLead = teamLead;
        this.users = users;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(String teamLead) {
        this.teamLead = teamLead;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // to string method


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", teamLead='" + teamLead + '\'' +
                ", users=" + users +
                '}';
    }
}