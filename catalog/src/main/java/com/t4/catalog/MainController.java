package com.t4.catalog;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {







    @FXML protected Tab1Controller tab1Controller;
    @FXML protected Tab2Controller tab2Controller;


    @FXML private BorderPane mainBorder ;
    @FXML private TreeView<String> treeView ;

    public TreeView<String> getTreeView() {
        return treeView;
    }




    protected ArrayList<TreeItem<String>> folders =new ArrayList<>();


    public MainController(){
        this.tab1Controller = new Tab1Controller();
        this.tab2Controller = new Tab2Controller();
    }

    public BorderPane getMainBorder() {
        return mainBorder;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tab1Controller.init(this,tab2Controller);
        tab2Controller.init(this,tab1Controller);


        TreeItem<String> root = new TreeItem<>("root");
        treeView.setRoot(root);
        treeView.setShowRoot(false);


        treeView.setOnMouseClicked(event -> {
            if(event.getClickCount() == 2){
                if(treeView.getSelectionModel().getSelectedItem() != null && treeView.getSelectionModel().getSelectedItem().getClass() == Item.class){
                    Item<String> item = (Item<String>) treeView.getSelectionModel().getSelectedItem();
                    
                }


            }
        });




    }


}