package shinu;

import java.util.Iterator;
import java.util.List;

public class CourseManager
{
    public void processStudents(List<Student> students)
    {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext())
        {
            Student student = iterator.next();
            if (student.getAverageGrade() <3)
            {
                iterator.remove();
            }
            else student.course++;
        }
    }
}
