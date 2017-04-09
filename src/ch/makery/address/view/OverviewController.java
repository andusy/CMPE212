package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.Main;
import ch.makery.address.model.Item;

public class OverviewController {
    @FXML
    private TableView<Item> itemTable;
    @FXML
    private TableColumn<Item, String> itemColumn;

    @FXML
    private Label itemNameLabel;
    @FXML
    private Label rentalCostLabel;

    // Reference to the main application.
    private Main main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        itemColumn.setCellValueFactory(cellData -> cellData.getValue().Item_Name());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMain(Main main) {
        this.main = main;

        // Add observable list data to the table
        itemTable.setItems(main.getItemData());
    }
}