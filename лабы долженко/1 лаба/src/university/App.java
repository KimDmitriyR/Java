package university;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.demoAnonymousClasses();
    }

    public void demoAnonymousClasses() {
        Teacher teacher = new Teacher(
                "Иванов Иван Иванович",
                "доцент",
                "кандидат наук",
                "преподаватель"
        );

        Discipline discipline = new Discipline(
                "Программирование на Java",
                "лекция"
        );

        Presenter russianPresenter = new TeacherPresenter();

        Presenter englishPresenter = new Presenter() {
            @Override
            public void greet() {
                presentTeacher(new Teacher("John Doe", "Associate Professor", "PhD", "Lecturer"));
            }

            @Override
            public void presentTeacher(Teacher t) {
                System.out.println("Teacher: " + t.getFullName() +
                        ", Title: " + t.getAcademicTitle() +
                        ", Degree: " + t.getAcademicDegree() +
                        ", Position: " + t.getPosition());
            }

            @Override
            public void presentDiscipline(Discipline d) {
                System.out.println("Discipline: " + d.getName() +
                        ", Type: " + d.getLessonType());
            }
        };

        Presenter spanishPresenter = new Presenter() {
            String saludo = "Hola";

            @Override
            public void greet() {
                System.out.println(saludo + ", estudiantes!");
            }

            @Override
            public void presentTeacher(Teacher t) {
                System.out.println("Profesor: " + t.getFullName());
            }

            @Override
            public void presentDiscipline(Discipline d) {
                System.out.println("Curso: " + d.getName() + " (" + d.getLessonType() + ")");
            }
        };

        russianPresenter.greet();
        russianPresenter.presentTeacher(teacher);
        russianPresenter.presentDiscipline(discipline);

        englishPresenter.greet();
        englishPresenter.presentDiscipline(new Discipline("Algorithms", "practice"));

        spanishPresenter.greet();
        spanishPresenter.presentTeacher(new Teacher("Miguel de la Cruz", "Profesor Asociado", "PhD", "Docente"));
        spanishPresenter.presentDiscipline(new Discipline("Estructuras de Datos", "laboratorio"));
    }
}


