import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teacher {
    private final StringProperty fullName = new SimpleStringProperty("");
    private final StringProperty academicTitle = new SimpleStringProperty("");
    private final StringProperty academicDegree = new SimpleStringProperty("");
    private final StringProperty position = new SimpleStringProperty("");

    public Teacher() {}

    public Teacher(String fullName, String academicTitle, String academicDegree, String position) {
        setFullName(fullName);
        setAcademicTitle(academicTitle);
        setAcademicDegree(academicDegree);
        setPosition(position);
    }

    public String getFullName() { return fullName.get(); }
    public void setFullName(String value) { fullName.set(value); }
    public StringProperty fullNameProperty() { return fullName; }

    public String getAcademicTitle() { return academicTitle.get(); }
    public void setAcademicTitle(String value) { academicTitle.set(value); }
    public StringProperty academicTitleProperty() { return academicTitle; }

    public String getAcademicDegree() { return academicDegree.get(); }
    public void setAcademicDegree(String value) { academicDegree.set(value); }
    public StringProperty academicDegreeProperty() { return academicDegree; }

    public String getPosition() { return position.get(); }
    public void setPosition(String value) { position.set(value); }
    public StringProperty positionProperty() { return position; }
}


