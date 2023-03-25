package br.com.tddjava.tddjava.services;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseInMemoryRepository;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateCourseServiceTest {
    @Test
    public void should_be_able_to_create_a_new_course() {
        Course course = new Course();
        course.setDescription("Curso_Description_Test");
        course.setName("Curso_Name");
        course.setWorkload(100);

        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(repository);
        Course createdCourse = createCourseService.execute(course);

        assertNotNull(createdCourse.getId());
    }

    @Test(expected = Error.class)
    public void should_not_be_able_to_create_a_new_course_if_exists() {
        Course course = new Course();
        course.setDescription("Curso_Description_Test");
        course.setName("Curso_Name");
        course.setWorkload(100);

        CourseInMemoryRepository repository = new CourseInMemoryRepository();

        CreateCourseService createCourseService = new CreateCourseService(repository);
        createCourseService.execute(course);
        createCourseService.execute(course);
    }
}
