package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Book;
import ch.makery.address.model.Device;
import ch.makery.address.model.Item;
import ch.makery.address.model.LibrarySystem;
import ch.makery.address.view.OverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    
    private LibrarySystem sys = new LibrarySystem();
    private ObservableList<Item> itemData = FXCollections.observableArrayList();
    
    public Main(){
    	Item a = new Device();
    	Item b = new Book();
    }
    
    public ObservableList<Item> getItemData() {
        return itemData;
    }

	@Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Queen's Library System");

        initRootLayout();
        showOverview();
        primaryStage.setResizable(false);
    }
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void showOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Overview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            OverviewController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
