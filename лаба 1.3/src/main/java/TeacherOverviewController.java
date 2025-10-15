import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TeacherOverviewController {

    @FXML private TableView<Teacher> teacherTable;
    @FXML private TableColumn<Teacher, String> colName;
    @FXML private TableColumn<Teacher, String> colTitle;
    @FXML private TableColumn<Teacher, String> colDegree;
    @FXML private TableColumn<Teacher, String> colPosition;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        colName.setCellValueFactory(cell -> cell.getValue().fullNameProperty());
        colTitle.setCellValueFactory(cell -> cell.getValue().academicTitleProperty());
        colDegree.setCellValueFactory(cell -> cell.getValue().academicDegreeProperty());
        colPosition.setCellValueFactory(cell -> cell.getValue().positionProperty());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        teacherTable.setItems(mainApp.getTeacherData());
    }

    @FXML private void handleAdd() { mainApp.getTeacherData().add(new Teacher("Новый преподаватель", "", "", "")); }
    @FXML private void handleEdit() {
        Teacher selected = teacherTable.getSelectionModel().getSelectedItem();
        if (selected != null) { selected.setFullName(selected.getFullName() + " *"); }
    }
    @FXML private void handleDelete() {
        int idx = teacherTable.getSelectionModel().getSelectedIndex();
        if (idx >= 0) { teacherTable.getItems().remove(idx); }
    }
}


