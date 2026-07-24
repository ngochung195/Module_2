import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(getClass().getResource("/resources/fxml/Main.fxml"));

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/resources/fxml/Main.fxml"));

        Scene scene = new Scene(loader.load());

        stage.setTitle("Từ điển Anh - Việt");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}