package university;

public class Teacher {
    private String fullName;
    private String academicTitle;  
    private String academicDegree; 
    private String position;  

    public Teacher(String fullName, String academicTitle, String academicDegree, String position) {
        this.fullName = fullName;
        this.academicTitle = academicTitle;
        this.academicDegree = academicDegree;
        this.position = position;
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

    @Override
    public String toString() {
        return "Преподаватель{" +
                "ФИО='" + fullName + '\'' +
                ", Ученое звание='" + academicTitle + '\'' +
                ", Ученая степень='" + academicDegree + '\'' +
                ", Должность='" + position + '\'' +
                '}';
    }
}


