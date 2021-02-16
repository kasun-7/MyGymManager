package sample;
//this one is the over 60 class connect to the default member
public class Over60Member extends DefaultMember {
    private int age;
//connect to the strings that we named
    public Over60Member(String MembershipNo, String MemberName, String StartMembershipDate, int age) {
        super(MembershipNo, MemberName, StartMembershipDate);
        setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >=60) {
            this.age = age;
        }else {
            throw new IllegalArgumentException("Invalid Age For a Over 60 member");
        }

    }
}
