package university;

import java.util.ArrayList;
import java.util.List;

public class LambdaApp {
    
    public static void main(String[] args) {
        LambdaApp app = new LambdaApp();
        app.demonstrateLambdaExpressions();
    }
    
    public void demonstrateLambdaExpressions() {
        System.out.println("=== ДЕМОНСТРАЦИЯ ЛЯМБДА-ВЫРАЖЕНИЙ ===\n");
        
        List<Teacher> teachers = createTeachers();
        List<Discipline> disciplines = createDisciplines();
        
        demonstrateSimpleLambdas();
        
        demonstrateLambdaParameters(teachers, disciplines);
        
        demonstrateMethodReferences(teachers, disciplines);
        
        demonstrateLambdaReturns();
        
        demonstrateBlockLambdas(teachers);
        
        demonstrateGenericLambdas();
    }
    
    private void demonstrateSimpleLambdas() {
        System.out.println("1. ПРОСТЫЕ ЛЯМБДА-ВЫРАЖЕНИЯ:");
        
        TeacherOperation isExperienced = teacher -> teacher.getExperienceYears() >= 5;
        TeacherOperation isProfessor = teacher -> teacher.getAcademicTitle().contains("профессор");
        
        Teacher teacher = new Teacher("Иванов И.И.", "доцент", "кандидат наук", "преподаватель", 8);
        
        System.out.println("Преподаватель опытный: " + isExperienced.test(teacher));
        System.out.println("Преподаватель профессор: " + isProfessor.test(teacher));
        
        DisciplineOperation isLecture = discipline -> discipline.getLessonType().equals("лекция");
        DisciplineOperation isLongCourse = discipline -> discipline.getHours() > 50;
        
        Discipline discipline = new Discipline("Java Programming", "лекция", 80, "осенний");
        
        System.out.println("Это лекция: " + isLecture.test(discipline));
        System.out.println("Длинный курс: " + isLongCourse.test(discipline));
        System.out.println();
    }
    
    private void demonstrateLambdaParameters(List<Teacher> teachers, List<Discipline> disciplines) {
        System.out.println("2. ЛЯМБДА-ВЫРАЖЕНИЯ КАК ПАРАМЕТРЫ МЕТОДОВ:");
        
        int experiencedCount = countTeachers(teachers, t -> t.getExperienceYears() >= 10);
        int professorCount = countTeachers(teachers, t -> t.getAcademicTitle().contains("профессор"));
        
        System.out.println("Опытных преподавателей (≥10 лет): " + experiencedCount);
        System.out.println("Профессоров: " + professorCount);
        
        int lectureCount = countDisciplines(disciplines, d -> d.getLessonType().equals("лекция"));
        int longCourseCount = countDisciplines(disciplines, d -> d.getHours() >= 100);
        
        System.out.println("Лекций: " + lectureCount);
        System.out.println("Длинных курсов (≥100 часов): " + longCourseCount);
        
        System.out.println("\nИнформация о преподавателях:");
        processTeachers(teachers, t -> "• " + t.getFullName() + " - " + t.getPosition());
        
        System.out.println("\nИнформация о дисциплинах:");
        processDisciplines(disciplines, d -> "• " + d.getName() + " (" + d.getHours() + " ч.)");
        System.out.println();
    }
    
    private void demonstrateMethodReferences(List<Teacher> teachers, List<Discipline> disciplines) {
        System.out.println("3. ССЫЛКИ НА МЕТОДЫ:");
        
        int experiencedCount = countTeachers(teachers, UniversityHelper::isExperiencedTeacher);
        int professorCount = countTeachers(teachers, UniversityHelper::isProfessor);
        
        System.out.println("Опытных преподавателей (через ссылку на метод): " + experiencedCount);
        System.out.println("Профессоров (через ссылку на метод): " + professorCount);
        
        UniversityHelper helper = new UniversityHelper();
        int phdCount = countTeachers(teachers, helper::hasPhD);
        
        System.out.println("Преподавателей с докторской степенью: " + phdCount);
        
        System.out.println("\nФорматированная информация:");
        processTeachers(teachers, UniversityHelper::formatTeacherInfo);
        processDisciplines(disciplines, UniversityHelper::formatDisciplineInfo);
        System.out.println();
    }
    
    private void demonstrateLambdaReturns() {
        System.out.println("4. ЛЯМБДА-ВЫРАЖЕНИЯ КАК РЕЗУЛЬТАТ МЕТОДОВ:");
        
        TeacherProcessor processor1 = getTeacherProcessor(1);
        TeacherProcessor processor2 = getTeacherProcessor(2);
        
        Teacher teacher = new Teacher("Петров П.П.", "профессор", "доктор наук", "заведующий кафедрой", 15);
        
        System.out.println("Процессор 1: " + processor1.process(teacher));
        System.out.println("Процессор 2: " + processor2.process(teacher));
        
        System.out.println("Прямое использование: " + getTeacherProcessor(3).process(teacher));
        System.out.println();
    }
    
    private void demonstrateBlockLambdas(List<Teacher> teachers) {
        System.out.println("5. БЛОЧНЫЕ ЛЯМБДА-ВЫРАЖЕНИЯ:");
        
        TeacherProcessor complexProcessor = teacher -> {
            StringBuilder result = new StringBuilder();
            result.append("=== ДЕТАЛЬНАЯ ИНФОРМАЦИЯ ===\n");
            result.append("ФИО: ").append(teacher.getFullName()).append("\n");
            result.append("Должность: ").append(teacher.getPosition()).append("\n");
            result.append("Стаж: ").append(teacher.getExperienceYears()).append(" лет\n");
            
            if (teacher.getExperienceYears() >= 10) {
                result.append("Статус: ОПЫТНЫЙ ПРЕПОДАВАТЕЛЬ\n");
            } else {
                result.append("Статус: МОЛОДОЙ ПРЕПОДАВАТЕЛЬ\n");
            }
            
            return result.toString();
        };
        
        System.out.println(complexProcessor.process(teachers.get(0)));
    }
    
    private void demonstrateGenericLambdas() {
        System.out.println("6. ФУНКЦИОНАЛЬНЫЕ ИНТЕРФЕЙСЫ:");
        
        TeacherComparator byExperience = (t1, t2) -> Integer.compare(t1.getExperienceYears(), t2.getExperienceYears());
        TeacherComparator byName = (t1, t2) -> t1.getFullName().compareTo(t2.getFullName());
        
        Teacher teacher1 = new Teacher("Алексеев А.А.", "доцент", "кандидат наук", "преподаватель", 5);
        Teacher teacher2 = new Teacher("Борисов Б.Б.", "профессор", "доктор наук", "заведующий кафедрой", 20);
        
        System.out.println("Сравнение по стажу: " + byExperience.compare(teacher1, teacher2));
        System.out.println("Сравнение по имени: " + byName.compare(teacher1, teacher2));
        System.out.println();
    }
    
    private int countTeachers(List<Teacher> teachers, TeacherOperation operation) {
        int count = 0;
        for (Teacher teacher : teachers) {
            if (operation.test(teacher)) {
                count++;
            }
        }
        return count;
    }
    
    private int countDisciplines(List<Discipline> disciplines, DisciplineOperation operation) {
        int count = 0;
        for (Discipline discipline : disciplines) {
            if (operation.test(discipline)) {
                count++;
            }
        }
        return count;
    }
    
    private void processTeachers(List<Teacher> teachers, TeacherProcessor processor) {
        for (Teacher teacher : teachers) {
            System.out.println(processor.process(teacher));
        }
    }
    
    private void processDisciplines(List<Discipline> disciplines, DisciplineProcessor processor) {
        for (Discipline discipline : disciplines) {
            System.out.println(processor.process(discipline));
        }
    }
    
    private TeacherProcessor getTeacherProcessor(int type) {
        switch (type) {
            case 1: return teacher -> "Краткая информация: " + teacher.getFullName();
            case 2: return teacher -> "Подробная информация: " + teacher.toString();
            case 3: return teacher -> "Статус: " + (teacher.getExperienceYears() >= 10 ? "Опытный" : "Начинающий");
            default: return teacher -> "Неизвестный тип обработки";
        }
    }
    
    private List<Teacher> createTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Иванов Иван Иванович", "доцент", "кандидат наук", "преподаватель", 8));
        teachers.add(new Teacher("Петров Петр Петрович", "профессор", "доктор наук", "заведующий кафедрой", 20));
        teachers.add(new Teacher("Сидоров Сидор Сидорович", "старший преподаватель", "кандидат наук", "преподаватель", 3));
        teachers.add(new Teacher("Козлова Анна Сергеевна", "профессор", "доктор наук", "декан факультета", 25));
        return teachers;
    }
    
    private List<Discipline> createDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(new Discipline("Программирование на Java", "лекция", 80, "осенний"));
        disciplines.add(new Discipline("Алгоритмы и структуры данных", "практика", 60, "весенний"));
        disciplines.add(new Discipline("Базы данных", "лабораторная", 40, "осенний"));
        disciplines.add(new Discipline("Веб-разработка", "лекция", 120, "весенний"));
        return disciplines;
    }
}
