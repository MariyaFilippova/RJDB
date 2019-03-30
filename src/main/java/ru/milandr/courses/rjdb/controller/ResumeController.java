package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.ResumeDto;
import ru.milandr.courses.rjdb.services.ResumeService;
import javax.validation.ValidationException;

@RestController
@RequestMapping("resume")
public class ResumeController {

    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/{resumeId}")
    public ResumeDto getResume(@PathVariable Long resumeId) {
        return resumeService.getResume(resumeId);
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createResume(@RequestBody ResumeDto resumeDto) throws ValidationException {
        resumeService.createResume(resumeDto);
    }

}

