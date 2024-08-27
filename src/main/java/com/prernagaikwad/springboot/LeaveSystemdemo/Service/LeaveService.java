package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Leave;
import java.util.List;
import java.util.Optional;

public interface LeaveService {

    Leave createLeave(Leave leave);

    Leave updateLeave(Long id, Leave leave);

    void deleteLeave(Long id);

    Optional<Leave> getLeaveById(Long id);

    List<Leave> getAllLeaves();

    List<Leave> getLeavesByUserId(Long id);
}
