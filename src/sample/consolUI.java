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
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class consolUI {
    //console part
    private final static MyGymManagr manager = new MyGymManagr();
    private static int count = 0;

    public static void main(String[] args) {//use string args and use wild condition
        while (true) {

            Scanner input = new Scanner(System.in);


            System.out.println("ROCK GYM ENTRY");
            System.out.println("GYM APPLICATION");

            System.out.println(" ");
            System.out.println("select a option");
            System.out.println("1 for insert member");
            System.out.println("2 for Delete");
            System.out.println("3 for print");
            System.out.println("4 for Interface");

            int choice = input.nextInt();
            switch (choice) {//connect to command action,it helps to switch, break
                case 1:
                    insertMember();
                    break;
                case 2:
                    DelMember();
                    break;
                case 3:
                    manager.PrintList_OfMembers();
                    break;
                case 4:
                    Main.main(args);
                    break;

                default:
                    System.out.println(" Wrong Entry.....***try again ");
            }
            System.out.println("Type 'V' to View all MEMBERSHIP");
            System.out.println("Type 'A' to ADD MEMBERSHIP");
            System.out.println("Type 'D' to Display empty MEMBERSHIP");
            System.out.println("Type 'R' to Remove a ENTRY MEMBERSHIP");
            System.out.println("Type 'F' to Find your MEMBERSHIP");
            System.out.println("Type 'O' to View members names in alphabetical Order ");
            System.out.println("type 'S' to Save file");
            System.out.println("Type 'Q' to Quit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Your option : ");
        }
    }
//membership number data
    private static void DelMember(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Membership No: ");
        String MembershipNo= input.next();
        boolean result =manager.Del_Member(MembershipNo);
        if (result) {
            count--;
        }

    }
    private static void find_memberships() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Name :");
        String find = input.nextLine();
        boolean result = manager.Del_Member(find);
        if (result) {
            count--;
        }
    }

    //use scanner insert member
    private static void insertMember() {
        Scanner input =new Scanner(System.in);
        if (count < 100){
            System.out.println("Enter the membership Type (O- 60>=MEMBER /S-STUDENT MEMBER / D-DEFAULT MEMBER) :");
            String type=input.next();
            System.out.println("Enter the Membership No: ");
            String MembershipNo= input.next();
            System.out.println("Enter the name :");
            String MemberName=input.next();
            System.out.println("Enter the date in the following format DD/MM/YYYY:");
            String StartMembershipDate =input.next();
            MyGymManagr myGymManagr=new MyGymManagr();
            if(type.equals("S")){
                System.out.println("Enter the School :");
                String School=input.next();
                StudentMember member= new StudentMember( MembershipNo,  MemberName,  StartMembershipDate,  School);

                myGymManagr.Add_Member(member);

            }else if(type.equals("D")){
                DefaultMember defaultMember=new DefaultMember(MembershipNo,  MemberName,  StartMembershipDate);
                myGymManagr.Add_Member(defaultMember);


            }else if(type.equals("O")){
                System.out.println("Enter your age :");
                int age=input.nextInt();
                Over60Member over60Member=new Over60Member(MembershipNo,  MemberName,  StartMembershipDate,  age);
                myGymManagr.Add_Member(over60Member);

            }
            count++;


        }else {
            System.out.println("No Free slots");
        }
    }

}
