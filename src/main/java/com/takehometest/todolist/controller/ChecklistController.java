package com.takehometest.todolist.controller;

import com.takehometest.todolist.model.Checklist;
import com.takehometest.todolist.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/checklist")
    public ResponseEntity<List<Checklist>> getAllChecklists() {
        List<Checklist> checklists = checklistService.getAllChecklists();
        return new ResponseEntity<>(checklists, HttpStatus.OK);
    }

    @DeleteMapping("/checklist/{id}")
    public ResponseEntity<String> deleteChecklist(@PathVariable Long id) {
        boolean isDeleted = checklistService.deleteChecklist(id);
        if (isDeleted) {
            return new ResponseEntity<>("Checklist berhasil dihapus", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Checklist tidak ditemukan", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/checklist")
    public ResponseEntity<Checklist> createChecklist(@RequestParam String title) {
        Checklist newChecklist = checklistService.createChecklist(title);
        return new ResponseEntity<>(newChecklist, HttpStatus.CREATED);
    }


}
