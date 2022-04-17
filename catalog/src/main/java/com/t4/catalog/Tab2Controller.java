package com.t4.catalog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Tab2Controller implements Initializable {

    private MainController mainController;
    private Tab1Controller tab1Controller;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setTab1Controller(Tab1Controller tab1Controller) {
        this.tab1Controller = tab1Controller;
    }

    protected Item<String> item ;



    @FXML private TextField attTF ;
    @FXML private TextField valTF ;
    @FXML private TableView<Attribute> tableView;
    @FXML private TableColumn<Attribute,String> attributeColumn;
    @FXML private TableColumn<Attribute,String> valueColumn ;
    @FXML private AnchorPane tab2Anchor ;




    ObservableList<Attribute> list = FXCollections.observableArrayList();


    public AnchorPane getTab2Anchor() {
        return tab2Anchor;
    }

    public void setTab2Anchor(AnchorPane tab2Anchor) {
        this.tab2Anchor = tab2Anchor;
    }

    @FXML
    public void addButton() {

        String attributeName = attTF.getText();
        String attributeValue =valTF.getText();


        Attribute attribute = new Attribute(attributeName, attributeValue);
        tableView.getItems().add(attribute);

        list.add(attribute);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        attributeColumn.setCellValueFactory(new PropertyValueFactory<>("attributeName"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("attributeValue"));


    }

    @FXML
    public void saveButton(){
        if(list.size() == 0)
            return;
        item.getAttributes().addAll(list);
        list.clear();
        tableView.getItems().clear();
        attTF.clear();
        valTF.clear();
        tab1Controller.getDescription().clear();
        tab1Controller.getNameTF().clear();
        tab1Controller.getTagTF().clear();
        tab1Controller.getTypeTF().clear();

        TreeView<String> treeView = mainController.getTreeView();
        TreeItem<String> root = treeView.getRoot();

        for (int i = 0; i <root.getChildren().toArray().length; i++) {
            TreeItem<String> folder = (TreeItem<String>)root.getChildren().toArray()[i];
            if(folder.getValue().equals(item.getFolder().getValue())){
                folder.getChildren().add(item);
            }
            else{
                root.getChildren().add(item.getFolder());
            }

        }
        if(mainController.getTreeView().getRoot().getChildren().toArray().length == 0){
            root.getChildren().add(item.getFolder());
            TreeItem<String> folder = (TreeItem<String>) root.getChildren().toArray()[0];
            folder.getChildren().add(item);

        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Item added to "+item.getFolder().getValue());
        alert.show();

        item = null;

        prevButton();

    }

    public void init(MainController mainController ,Tab1Controller tab1Controller) {
        this.mainController = mainController;
        this.tab1Controller = tab1Controller ;
    }

    @FXML
    public void deleteButton(){

       int index =tableView.getSelectionModel().getSelectedIndex();
       tableView.getItems().remove(index);

    }

    @FXML
    public void clearButton(){
        list.clear();
        tableView.getItems().clear();
        attTF.clear();
        valTF.clear();


    }
    @FXML
    public void editButton(){

        int index =tableView.getSelectionModel().getSelectedIndex();
        Attribute attr =tableView.getItems().get(index);
        attr.setAttributeName(attTF.getText());
        attr.setAttributeValue(valTF.getText());
        tableView.refresh();


    }
    @FXML
    public void prevButton(){
        mainController.getMainBorder().setCenter(tab1Controller.getTab1Anchor());

    }



}
