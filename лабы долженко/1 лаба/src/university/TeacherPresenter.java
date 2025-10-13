package university;

public class TeacherPresenter implements Presenter {

    @Override
    public void greet() {
        System.out.println("Здравствуйте!");
    }

    @Override
    public void presentTeacher(Teacher teacher) {
        System.out.println("Информация о преподавателе: " + teacher);
    }

    @Override
    public void presentDiscipline(Discipline discipline) {
        System.out.println("Информация о дисциплине: " + discipline);
    }
}


