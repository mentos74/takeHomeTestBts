package com.takehometest.todolist.repository;

import com.takehometest.todolist.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

}