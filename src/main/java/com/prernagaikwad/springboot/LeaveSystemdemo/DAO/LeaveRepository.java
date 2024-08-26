package com.prernagaikwad.springboot.LeaveSystemdemo.DAO;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long>
{
    List<Leave> findByUserId(Long userId);

}