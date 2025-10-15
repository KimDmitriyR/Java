import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private final ObservableList<Teacher> teacherData = FXCollections.observableArrayList();

    public MainApp() {
        teacherData.addAll(
                new Teacher("Иванов Иван Иванович", "доцент", "к.т.н.", "преподаватель"),
                new Teacher("Петров Пётр Петрович", "профессор", "д.ф.-м.н.", "зав. кафедрой")
        );
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Лаба 3 — Преподаватели и Дисциплины");

        initRootLayout();
        showTeacherOverview();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showTeacherOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/TeacherOverview.fxml"));
            AnchorPane view = (AnchorPane) loader.load();
            rootLayout.setCenter(view);

            TeacherOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() { return primaryStage; }
    public ObservableList<Teacher> getTeacherData() { return teacherData; }

    public static void main(String[] args) { launch(args); }
}


