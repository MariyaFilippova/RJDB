package ru.milandr.courses.rjdb.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.common.ValidationException;
import ru.milandr.courses.rjdb.daos.ResumeDao;
import ru.milandr.courses.rjdb.dtos.ResumeDto;
import ru.milandr.courses.rjdb.entities.Resume;
import ru.milandr.courses.rjdb.entities.enums.Status;

import java.util.List;
import java.util.stream.Collectors;

import static ru.milandr.courses.rjdb.common.ValidationUtils.validateIsNotNull;


@RequiredArgsConstructor
@Service
public class ResumeService {
    private final ResumeDao resumeDao;
    private final UserService userService;


    public ResumeDto getResume(long resumeId) {
        Resume resume = resumeDao.findOne(resumeId);
        return buildResumeDtoFromResume(resume);
    }


    public void createResume(ResumeDto resumeDto) throws ValidationException {
        Long userId = userService.getCurrentAuthenticatedUserIdSafely();
        Resume resume = new Resume();
        resume.setUserId(userId);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(userId);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        resume.setAreaId(resumeDto.getArea_id());
        resume.setStatus(Status.UNSENT);
        resume.setResume(resumeDto.getResume());
        resume.setName(resumeDto.getName());
        resumeDao.save(resume);
    }


    public Resume buildResumeFromResumeDto(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setStatus(resumeDto.getStatus());
        resume.setAreaId(resumeDto.getArea_id());
        resume.setResume(resumeDto.getResume());
        resume.setName(resumeDto.getName());
        resume.setUserId(resumeDto.getUser_id());
        return resume;
    }
    public List<ResumeDto> getUserResumes() throws ValidationException {
        Long userId = userService.getCurrentAuthenticatedUserIdSafely();

        List<Resume> resumes = resumeDao.findByUserId(userId);

        validateIsNotNull(userId, "No resumes for user " + userId);

        return resumes.stream()
                .map(this::buildResumeDtoFromResume)
                .collect(Collectors.toList());
    }

    private ResumeDto buildResumeDtoFromResume(Resume resume) {
        return new ResumeDto(resume.getId(), resume.getName(), resume.getResume(), resume.getStatus(), resume.getAreaId(), resume.getUserId());
    }


}
