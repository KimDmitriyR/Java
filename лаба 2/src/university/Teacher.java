package university;

public class Teacher {
    private String fullName;
    private String academicTitle;
    private String academicDegree;
    private String position;
    private int experienceYears;

    public Teacher(String fullName, String academicTitle, String academicDegree, String position, int experienceYears) {
        this.fullName = fullName;
        this.academicTitle = academicTitle;
        this.academicDegree = academicDegree;
        this.position = position;
        this.experienceYears = experienceYears;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public String getPosition() {
        return position;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Преподаватель{" +
                "ФИО='" + fullName + '\'' +
                ", Ученое звание='" + academicTitle + '\'' +
                ", Ученая степень='" + academicDegree + '\'' +
                ", Должность='" + position + '\'' +
                ", Стаж=" + experienceYears + " лет" +
                '}';
    }
}
