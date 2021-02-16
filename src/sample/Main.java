package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
    Stage window;
    TableView<DefaultMember>table;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    /**
     *This method is used for the initialization of the String args and launch args.
     *custDetails is a Table which view the member name,no and date.
     *dates is a main class which stores the customer details.
     *thisPath is the file Name which is used in the methods saveInfo and loadInfo.
     */

    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;//get primarystage and used window
        window.setTitle("ROCK GYM ROCK GYM MANAGEMENT SYSTEM ____________________________________________________________________________________________________________________ View");

        //this is the column for days
        TableColumn<DefaultMember,String>memship_date = new TableColumn<>("Date");
        memship_date.setMinWidth(100);
        memship_date.setCellValueFactory(new PropertyValueFactory<>("StartMembership_Date"));

        //this is the column for numbers
        TableColumn<DefaultMember,String>num_coloumn = new TableColumn<>("NO");
        num_coloumn.setMinWidth(100);
        num_coloumn.setCellValueFactory(new PropertyValueFactory<>("Membership_No"));

        //this is the column for names
        TableColumn<DefaultMember,String>name_coloumn = new TableColumn<>("Memberships Name");
        name_coloumn.setMinWidth(200);
        name_coloumn.setCellValueFactory(new PropertyValueFactory<>("Member_Name"));

        //this is the column for members type
        TableColumn<DefaultMember,String>name_Type = new TableColumn<>("(O)- 60>=MEMBER /(S)-STUDENT MEMBER / (D)-DEFAULT MEMBER");
        name_Type.setMinWidth(400);
        name_Type.setCellValueFactory(new PropertyValueFactory<>("StartMembership_Type"));


        //this is the column for working place
        TableColumn<DefaultMember,String>memship_Job = new TableColumn<>("SCHOOL / WORK PLACE");
        memship_Job.setMinWidth(200);
        memship_Job.setCellValueFactory(new PropertyValueFactory<>("JOB"));

        //this is the column for national identity card numbers
        TableColumn<DefaultMember,String>memship_ID = new TableColumn<>("NIC");
        memship_ID.setMinWidth(100);
        memship_Job.setCellValueFactory(new PropertyValueFactory<>("NIC"));

       //get a new table , connect to the number name, date and other input


        table = new TableView<>();
        table.setItems(getDefault());
        table.getColumns().addAll(memship_date,num_coloumn,name_coloumn);

        VBox vBox = new VBox();//get a VBox and add a table inputs
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);//get a new scene and set a window
        window.setScene(scene);
        window.show();

    }

    /**connect to the default member class ObservableList and used get default option and saved to the data
     and it will be auto manage **/

    public ObservableList<DefaultMember>getDefault(){
        ObservableList<DefaultMember>Default= FXCollections.observableArrayList();
        Default.add(new DefaultMember("1","kasun","3/8/2020"));
        Default.add(new DefaultMember("2","Menaka","1/8/2020"));
        Default.add(new DefaultMember("3","Kumara","30/7/2020"));
        Default.add(new DefaultMember("4","senumi","14/2/2020"));
        Default.add(new DefaultMember("5","Lihansa","30/3/2020"));
        return Default;
//used include a return function
    }



}
