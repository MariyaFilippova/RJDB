package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.common.ValidationException;
import ru.milandr.courses.rjdb.daos.ResumeDao;
import ru.milandr.courses.rjdb.dtos.ResumeDto;

import ru.milandr.courses.rjdb.entities.Resume;
import ru.milandr.courses.rjdb.entities.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

import static ru.milandr.courses.rjdb.common.ValidationUtils.validateIsNotNull;



@Service
public class ResumeService {
    private ResumeDao resumeDao;

    public ResumeService(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    public ResumeDto getResume(long resumeId) {
        Resume resume = resumeDao.findOne(resumeId);
        return buildResumeDtoFromResume(resume);
    }


    public void createResume(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setUserId(1L);
        resume.setAreaId(1L);
        resume.setStatus(Status.UNSENT);
        resume.setResume(resumeDto.getResume());
        resume.setName(resumeDto.getName());
        resumeDao.save(resume);
    }


    private Resume buildResumeFromResumeDto(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setStatus(resumeDto.getStatus());
        resume.setAreaId(resumeDto.getArea_id());
        resume.setResume(resumeDto.getResume());
        resume.setName(resumeDto.getName());
        resume.setUserId(resumeDto.getUser_id());
        return resume;
    }
    public List<ResumeDto> getUserResumes() throws ValidationException {
        Long userId = 1L;
        validateIsNotNull(userId, "No user id provided");

        List<Resume> resumes = resumeDao.findByUserId(userId);

        validateIsNotNull(userId, "No resumes for user " + userId);

        return resumes.stream()
                .map(this::buildResumeDtoFromResume)
                .collect(Collectors.toList());
    }

    private ResumeDto buildResumeDtoFromResume(Resume resume) {
        return new ResumeDto(resume.getId(), resume.getName(), resume.getResume(), resume.getStatus().getValue(), resume.getAreaId(), resume.getUserId());
    }


}
