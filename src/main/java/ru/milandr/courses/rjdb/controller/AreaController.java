package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.AreaDto;
import ru.milandr.courses.rjdb.services.AreaService;
import java.util.List;


    @RestController
    @RequestMapping("areas")
    public class AreaController {

        private AreaService areaService;

        public AreaController(AreaService vacancyService) {
            this.areaService = vacancyService;
        }

        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<AreaDto>> getAll() {
            return ResponseEntity.ok(areaService.getAll());
        }

    }

