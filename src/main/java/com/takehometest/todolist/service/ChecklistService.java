package com.takehometest.todolist.service;

import com.takehometest.todolist.model.Checklist;
import com.takehometest.todolist.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    public Checklist createChecklist(String title) {
        Checklist checklist = new Checklist();
        checklist.setTitle(title);
        checklist.setCompleted(false); // Default statusnya belum selesai
        return checklistRepository.save(checklist);
    }

    public boolean deleteChecklist(Long id) {
        Optional<Checklist> checklist = checklistRepository.findById(id);
        if (checklist.isPresent()) {
            checklistRepository.delete(checklist.get());
            return true;
        }
        return false;
    }

    public List<Checklist> getCompletedChecklists() {
        return checklistRepository.findAll().stream()
                .filter(Checklist::isCompleted)
                .toList();
    }

    public List<Checklist> getPendingChecklists() {
        return checklistRepository.findAll().stream()
                .filter(checklist -> !checklist.isCompleted())
                .toList();
    }
}
