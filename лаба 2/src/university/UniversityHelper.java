package university;

public class UniversityHelper {
    
    public static boolean isExperiencedTeacher(Teacher teacher) {
        return teacher.getExperienceYears() >= 10;
    }
    
    public static boolean isProfessor(Teacher teacher) {
        return teacher.getAcademicTitle().toLowerCase().contains("профессор");
    }
    
    public static boolean isLecture(Discipline discipline) {
        return discipline.getLessonType().toLowerCase().contains("лекция");
    }
    
    public static boolean isLongCourse(Discipline discipline) {
        return discipline.getHours() >= 100;
    }
    
    public static String formatTeacherInfo(Teacher teacher) {
        return String.format("Преподаватель: %s (%s)", 
                teacher.getFullName(), teacher.getPosition());
    }
    
    public static String formatDisciplineInfo(Discipline discipline) {
        return String.format("Курс: %s - %d часов", 
                discipline.getName(), discipline.getHours());
    }
    
    public boolean hasPhD(Teacher teacher) {
        return teacher.getAcademicDegree().toLowerCase().contains("доктор");
    }
    
    public boolean isSpringSemester(Discipline discipline) {
        return discipline.getSemester().toLowerCase().contains("весенний");
    }
}
