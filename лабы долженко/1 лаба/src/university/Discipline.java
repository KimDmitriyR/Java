package university;

public class Discipline {
    private String name;       
    private String lessonType;  

    public Discipline(String name, String lessonType) {
        this.name = name;
        this.lessonType = lessonType;
    }

    public String getName() {
        return name;
    }

    public String getLessonType() {
        return lessonType;
    }

    @Override
    public String toString() {
        return "Дисциплина{" +
                "Название='" + name + '\'' +
                ", Вид занятия='" + lessonType + '\'' +
                '}';
    }
}


