package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MyGymManagr implements GymManager{
    private List<DefaultMember> memberList = new ArrayList<DefaultMember>();

    @Override
    /**this is the option that we add members to this gym management system. this included
     * style,structure,command and on action button.main part of the gym management system is this one  */

    //add  members to this process
    public void Add_Member(DefaultMember member) {
        System.out.println("No of occupied slots :" + memberList.size());
        System.out.println("No of free Slots :" + (100 - memberList.size()));

        if (memberList.size() < 100) {
            memberList.add(member);//connect to the member list

        } else {
            System.out.println("No Free Slots Are available for new members");//display free slots
        }

        Stage primary_Stage = new Stage();
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image image_primary_Stage = new Image("Rock.JPEG");
        ImageView primary_Stage_image = new ImageView(image_primary_Stage);
        primary_Stage_image.setImage(image_primary_Stage);
        pane.getChildren().add(primary_Stage_image);
        primary_Stage_image.setImage(image_primary_Stage);
        primary_Stage_image.setFitWidth(300);
        primary_Stage_image.setFitHeight(140);
        pane.setStyle("-fx-background-color:#404040");
        pane.setHgap(20);
        pane.setVgap(15);
        primary_Stage.setTitle("ROCK GYM MANAGEMENT SYSTEM _______ADD ");


        Menu menu = new Menu();
        menu.setText("MEMBER");
        menu.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        menu.setStyle("-fx-background-color:#ffff00");
        MenuItem Item_1 = new MenuItem(" 60>=MEMBER ");
        MenuItem Item_2 = new MenuItem(" STUDENT MEMBER ");
        MenuItem Item_3 = new MenuItem(" OTHER MEMBER ");

        menu.getItems().add(Item_1);
        menu.getItems().add(Item_2);
        menu.getItems().add(Item_3);

        MenuBar menu_Bar = new MenuBar();
        menu_Bar.setLayoutX(120);
        menu_Bar.setLayoutY(100);
        menu_Bar.getMenus().add(menu);

        pane.getChildren().add(menu_Bar);
        DatePicker date = new DatePicker();
        date.setLayoutY(140);
        date.setLayoutX(20);


        Label ID = new Label(" NIC ");
        ID.setLayoutY(140);
        ID.setLayoutX(70);
        ID.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold ");
        ID.setStyle("-fx-background-color:#ffff00");

        TextField ID_TF = new TextField();
        ID_TF.setLayoutY(140);
        ID_TF.setLayoutX(100);

        Button button = new Button("Read Date");

        button.setOnAction(action -> {
            System.out.println();
        });

        button.setOnAction(action -> {
            LocalDate value = date.getValue();
            System.out.println(value);
        });
        pane.getChildren().add(ID);
        pane.getChildren().add(ID_TF);
        pane.getChildren().add(date);

        menu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            // 60>=MEMBER
            public void handle(ActionEvent event) {
                Item_1.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_1.getText());
                    }

                });
                // STUDENT MEMBER
                Item_2.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_2.getText());
                    }

                });
                // OTHER MEMBER
                Item_3.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_3.getText());
                    }

                });
            }
        });


    }


    @Override
    /**connect to the DefaultMember java and use boolean object */
    public boolean Del_Member(String MembershipNo) {
        boolean cols = false;
        for (DefaultMember member : memberList) {
            if (member.getMembership_No().equals(MembershipNo)) {//boolean  main part
                cols = true;
                memberList.remove(member);
                System.out.println("Member with the membership No" + MembershipNo + "Succesfully Removed");
                System.out.println("No of occupied slots :" + memberList.size());
                System.out.println("No of free slots :" + (100 - memberList.size()));//used member list
                if (member instanceof StudentMember) {
                    System.out.println("membership type is :StudentMember");
                } else if (member instanceof Over60Member) {
                    System.out.println("membership type is :Over60Member");
                } else {
                    System.out.println("membership type is :DefaultMember");
                }
                break;//use the break condition

            }
        }
        if (!cols) {
            System.out.println("Not Found");
        }
        return cols;//use the return

    }

    @Override
    public void PrintList_OfMembers() {//print of the members that included this list
        for (DefaultMember member : memberList) {
            System.out.print("Membership_No :" + member.getMembership_No() + " ");
            if (member instanceof StudentMember) {
                System.out.print("membership_type is :StudentMember");
            } else if (member instanceof Over60Member) {
                System.out.print("membership_type is :Over60Member");
            } else {
                System.out.print("membership_type is :DefaultMember");
            }
            System.out.print("Name is :" + member.getMember_Name() + "");

        }
        if (memberList.size() == 0) {
            System.out.println("Empty ");
        }

    }

    @Override
    public void sort() {


    }

    @Override
    public void save() {
        if (memberList.size() != 0) {

        } else {
            System.out.println("Empty");
        }

    }

    @Override
    public List<DefaultMember> getMemberList() {//Memberlist
        return this.memberList;
    }

    @Override
    public DefaultMember getMemberbyMembershipNo(String MembershipNo) {//MemberbyMembershipNo
        return null;
    }

    @Override
    public DefaultMember[] getMemberbyName(String name) {//MemberbyName
        return new DefaultMember[0];
    }







    private void find_memberships() {

        Scanner f = new Scanner(System.in);
        System.out.print("Enter your SurName :");
        String find = f.nextLine();
    }

    private void remove_booked() {
        Scanner r = new Scanner(System.in);
        System.out.print("Type the Member SurName you want to delete :");
        String remove = r.nextLine();

    }

    private void add_memberships() {


        Stage primary_Stage = new Stage();
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image image_primary_Stage = new Image("Rock.JPEG");
        ImageView primary_Stage_image = new ImageView(image_primary_Stage);
        primary_Stage_image.setImage(image_primary_Stage);
        pane.getChildren().add(primary_Stage_image);
        primary_Stage_image.setImage(image_primary_Stage);
        primary_Stage_image.setFitWidth(300);
        primary_Stage_image.setFitHeight(140);
        pane.setStyle("-fx-background-color:#404040");
        pane.setHgap(20);
        pane.setVgap(15);
        primary_Stage.setTitle("ROCK GYM MANAGEMENT SYSTEM _______ADD ");


        Menu menu = new Menu();
        menu.setText("MEMBER");
        menu.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        menu.setStyle("-fx-background-color:#ffff00");
        MenuItem Item_1 = new MenuItem(" 60>=MEMBER ");
        MenuItem Item_2 = new MenuItem(" STUDENT MEMBER ");
        MenuItem Item_3 = new MenuItem(" OTHER MEMBER ");

        menu.getItems().add(Item_1);
        menu.getItems().add(Item_2);
        menu.getItems().add(Item_3);

        MenuBar menu_Bar = new MenuBar();
        menu_Bar.setLayoutX(120);
        menu_Bar.setLayoutY(100);
        menu_Bar.getMenus().add(menu);

        pane.getChildren().add(menu_Bar);
        DatePicker date = new DatePicker();
        date.setLayoutY(140);
        date.setLayoutX(20);


        Label ID = new Label(" NIC ");
        ID.setLayoutY(140);
        ID.setLayoutX(70);
        ID.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold ");
        ID.setStyle("-fx-background-color:#ffff00");

        TextField ID_TF = new TextField();
        ID_TF.setLayoutY(140);
        ID_TF.setLayoutX(100);

        Button button = new Button("Read Date");
        button.setOnAction(action -> {
            System.out.println();
        });

        button.setOnAction(action -> {
            LocalDate value = date.getValue();
            System.out.println(value);
        });
        pane.getChildren().add(ID);
        pane.getChildren().add(ID_TF);
        pane.getChildren().add(date);

        menu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            // 60>=MEMBER
            public void handle(ActionEvent event) {
                Item_1.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_1.getText());
                    }

                });
                // STUDENT MEMBER
                Item_2.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_2.getText());
                    }

                });
                // OTHER MEMBER
                Item_3.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        menu.setText(Item_3.getText());
                    }

                });
            }

            private void memberships_veiw() {

                Stage primaryStage1 = new Stage();
                FlowPane pane = new FlowPane();
                pane.setPadding(new Insets(5, 5, 5, 5));

                pane.setHgap(20);
                pane.setVgap(15);
                primaryStage1.setTitle("ROCK GYM ROCK GYM MANAGEMENT SYSTEM _______ View");

            }

            private void displayempty_memberships() {


                Stage primaryStage1 = new Stage();
                FlowPane pane = new FlowPane();
                pane.setPadding(new Insets(5, 5, 5, 5));
                pane.setHgap(20);
                pane.setVgap(15);
                primaryStage1.setTitle("ROCK GYM MANAGEMENT SYSTEM _______ View");

            }

            private void save_Changes() {
                File file = new File("text");
                BufferedWriter B_W = null;

            }

            public void loadSavedData() {
                BufferedReader B_R = null;
                try {
                    B_R = new BufferedReader(new FileReader("text"));
                    String data;

                    while ((data = B_R.readLine()) != null) {
                        System.out.println(data);
                    }
                } catch (IOException i_d) {
                    i_d.printStackTrace();

                }
                try {
                    B_R.close();
                } catch (IOException i_d) {
                    i_d.printStackTrace();
                }
            }
        });
    }
}