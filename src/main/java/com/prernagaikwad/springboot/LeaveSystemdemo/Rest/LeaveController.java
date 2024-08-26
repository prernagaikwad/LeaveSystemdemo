package com.prernagaikwad.springboot.LeaveSystemdemo.Rest;

import com.prernagaikwad.springboot.LeaveSystemdemo.Entity.Leave;
import com.prernagaikwad.springboot.LeaveSystemdemo.Service.LeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping
    public ResponseEntity<String> createLeave(@RequestBody Leave leave) {
        try {
            Leave createdLeave = leaveService.createLeave(leave);
            return ResponseEntity.ok("Leave created successfully with ID: " + createdLeave.getId());
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while creating the leave: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLeave(@PathVariable Long id, @RequestBody Leave leave) {
        try {
            Leave updatedLeave = leaveService.updateLeave(id, leave);
            if (updatedLeave != null) {
                return ResponseEntity.ok("Leave updated successfully with ID: " + updatedLeave.getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while updating the leave: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeave(@PathVariable Long id) {
        try {
            leaveService.deleteLeave(id);
            return ResponseEntity.ok("Leave deleted successfully with ID: " + id);
        } catch (Exception e) {

            return ResponseEntity.status(500).body("An error occurred while deleting the leave: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Leave>> getLeaveById(@PathVariable Long id) {
        try {
            Optional<Leave> leave = leaveService.getLeaveById(id);
            return leave.isPresent() ? ResponseEntity.ok(leave) : ResponseEntity.notFound().build();
        } catch (Exception e) {

            return ResponseEntity.status(500).body(Optional.empty());
        }
    }

    @GetMapping
    public ResponseEntity<List<Leave>> getAllLeaves() {
        try {
            List<Leave> leaves = leaveService.getAllLeaves();
            return ResponseEntity.ok(leaves);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Leave>> getLeavesByUserId(@PathVariable Long userId) {
        try {
            List<Leave> leaves = leaveService.getLeavesByUserId(userId);
            return ResponseEntity.ok(leaves);
        } catch (Exception e) {

            return ResponseEntity.status(500).body(List.of());
        }
    }
}
