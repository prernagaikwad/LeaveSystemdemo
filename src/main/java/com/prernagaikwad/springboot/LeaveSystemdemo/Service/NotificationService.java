package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Leave;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Team;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService implements NotificationServiceI{

    @Autowired
    private UserService userService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private LeaveService leaveService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sendDailyNotifications() {
        List<Team> teams = teamService.getAllTeams();

        for (Team team : teams) {
            List<User> users = userService.getUsersByTeamId(team.getId());
            for (User user : users) {
                List<Leave> leaves = leaveService.getLeavesByUserId(user.getId());
                StringBuilder notificationMessage = new StringBuilder();

                notificationMessage.append("Today's status for team ").append(team.getTeamName()).append(":\n");
                notificationMessage.append("User: ").append(user.getFirstName()).append(" ").append(user.getLastName()).append("\n");

                boolean isAvailable = true;
                for (Leave leave : leaves) {
                    if (leave.getStartDate().isBefore(LocalDate.now().plusDays(1)) && leave.getEndDate().isAfter(LocalDate.now().minusDays(1))) {
                        notificationMessage.append("On leave: ").append(leave.getLeaveType()).append(" from ").append(leave.getStartDate()).append(" to ").append(leave.getEndDate()).append("\n");
                        isAvailable = false;
                    }
                }
                if (isAvailable) {
                    notificationMessage.append("Available today.\n");
                }


                System.out.println(notificationMessage.toString());
            }
        }
    }
}
