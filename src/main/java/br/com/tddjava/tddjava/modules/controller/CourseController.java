package br.com.tddjava.tddjava.modules.controller;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseRepository;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CreateCourseService createCourseService;

    public CourseController(CourseRepository repository) {
        this.createCourseService = new CreateCourseService(repository);
    }

    @PostMapping()
    public Course createCourse(@RequestBody Course course) {
        return createCourseService.execute(course);
    }
}
