package com.prernagaikwad.springboot.LeaveSystemdemo.Service;

import com.prernagaikwad.springboot.LeaveSystemdemo.DAO.LeaveRepository;
import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;


    @Override
    public Leave createLeave(Leave leave) {
        return leaveRepository.save(leave);
    }


    @Override
    public Leave updateLeave(Long id, Leave leave) {
        if (leaveRepository.existsById(id)) {
            leave.setId(id);
            return leaveRepository.save(leave);
        }
        return null;
    }

    @Override
    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    @Override
    public Optional<Leave> getLeaveById(Long id) {
        return leaveRepository.findById(id);
    }

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public List<Leave> getLeavesByUserId(Long userId) {
        return leaveRepository.findByUserId(userId);
    }
}