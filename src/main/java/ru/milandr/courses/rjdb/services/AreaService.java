package ru.milandr.courses.rjdb.services;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.AreaDao;
import ru.milandr.courses.rjdb.daos.VacancyDao;
import ru.milandr.courses.rjdb.dtos.AreaDto;

import ru.milandr.courses.rjdb.entities.Area;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService {
    private AreaDao areaDao;

    public AreaService(AreaDao areaDao) {
        this.areaDao = areaDao;
    }
    public List<AreaDto> getAll() {
        return areaDao.findAllBy().stream()
                .map(this::buildAreaDtoFromArea)
                .collect(Collectors.toList());
    }


    public AreaDto getArea(long areaId) {
        Area area = areaDao.findOne(areaId);
        return buildAreaDtoFromArea(area);
    }
    private Area buildAreaFromAreaDto(AreaDto areaDto) {
        Area area = new Area();
        area.setId(areaDto.getArea_id());
        area.setArea(areaDto.getArea());
        return area;

    }

    private AreaDto buildAreaDtoFromArea(Area area) {
        AreaDto areaDto = new AreaDto();
        areaDto.setArea_id(area.getId());
        areaDto.setArea(area.getArea());
        return areaDto;


    }
}
