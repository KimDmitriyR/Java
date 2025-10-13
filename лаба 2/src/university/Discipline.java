package university;

public class Discipline {
    private String name;
    private String lessonType;
    private int hours;
    private String semester;

    public Discipline(String name, String lessonType, int hours, String semester) {
        this.name = name;
        this.lessonType = lessonType;
        this.hours = hours;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public String getLessonType() {
        return lessonType;
    }

    public int getHours() {
        return hours;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "Дисциплина{" +
                "Название='" + name + '\'' +
                ", Вид занятия='" + lessonType + '\'' +
                ", Часы=" + hours +
                ", Семестр='" + semester + '\'' +
                '}';
    }
}
