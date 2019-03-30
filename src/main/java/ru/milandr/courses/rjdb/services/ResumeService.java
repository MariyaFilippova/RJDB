package ru.milandr.courses.rjdb.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.ResumeDao;
import ru.milandr.courses.rjdb.dtos.ResumeDto;
import ru.milandr.courses.rjdb.entities.Resume;



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

    public Resume createResume(ResumeDto resumeDto) {
        Resume resume = buildResumeFromResumeDto(resumeDto);
        resumeDao.save(resume);
        return resume;
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

    private ResumeDto buildResumeDtoFromResume(Resume resume) {
        return new ResumeDto(resume.getId(), resume.getName(), resume.getResume(), resume.getStatus().getValue(), resume.getAreaId(), resume.getUserId());
    }


}
