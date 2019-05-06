package ru.milandr.courses.rjdb.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.ResumeDto;
import ru.milandr.courses.rjdb.services.ResumeService;
import ru.milandr.courses.rjdb.common.ValidationException;
import java.util.List;
@Transactional
@RestController
@RequestMapping("resumes")
public class ResumeController {

    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/{resumeId}")
    public ResumeDto getResume(@PathVariable Long resumeId) {
        return resumeService.getResume(resumeId);
    }

    @PostMapping(value = "create_resume")
    public void createResume(@RequestBody ResumeDto resumeDto) {
        resumeService.createResume(resumeDto);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResumeDto>> getResumes() throws ValidationException {
        return ResponseEntity.ok(resumeService.getUserResumes());
    }


}

