package com.t4.catalog;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;



public class Tab1Controller {


    private MainController mainController;
    private Tab2Controller tab2Controller;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setTab2Controller(Tab2Controller tab2Controller) {
        this.tab2Controller = tab2Controller;
    }

    @FXML private TextField typeTF ;
    @FXML private TextField tagTF ;
    @FXML private TextField nameTF ;
    @FXML private TextArea description ;
    @FXML private AnchorPane tab1Anchor ;


    public TextField getTypeTF() {
        return typeTF;
    }

    public TextField getTagTF() {
        return tagTF;
    }

    public TextField getNameTF() {
        return nameTF;
    }

    public TextArea getDescription() {
        return description;
    }

    public AnchorPane getTab1Anchor() {
        return tab1Anchor;
    }

    public void init(MainController mainController, Tab2Controller tab2Controller) {
        this.mainController = mainController;
        this.tab2Controller = tab2Controller;

    }
    public void setTab1Anchor(AnchorPane tab1Anchor) {
        this.tab1Anchor = tab1Anchor;
    }


    @FXML
    public void nextButton(){



        String type = typeTF.getText();
        String name = nameTF.getText();
        String tag = tagTF.getText();
        String desc = description.getText();
        if(type.isBlank() || name.isBlank() || tag.isBlank() || desc.isBlank() )
            return;



        TreeItem<String> folder = new TreeItem<>(type);



        tab2Controller.item =new Item<>(name,type,tag,name,desc,folder);

        mainController.getMainBorder().setCenter(tab2Controller.getTab2Anchor());


    }


}
