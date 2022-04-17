package com.t4.catalog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader loader = new FXMLLoader(Main.class.getResource("mainScene.fxml"));
        Scene scene = new Scene(loader.load());

        FXMLLoader tab1Loader = new FXMLLoader(getClass().getResource("tab1.fxml"));
        AnchorPane tab1 = tab1Loader.load();

        FXMLLoader tab2Loader =new FXMLLoader(getClass().getResource("tab2.fxml"));
        AnchorPane tab2 = tab2Loader.load();

        Tab2Controller tab2Controller =tab2Loader.getController();
        Tab1Controller tab1Controller =tab1Loader.getController();

        MainController mainController  = loader.getController();

        tab2Controller.setMainController(mainController);
        tab1Controller.setMainController(mainController);

        tab2Controller.setTab1Controller(tab1Controller);
        tab1Controller.setTab2Controller(tab2Controller);

        mainController.tab1Controller.setTab1Anchor(tab1);
        mainController.tab2Controller.setTab2Anchor(tab2);

        mainController.getMainBorder().setCenter(tab1);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}