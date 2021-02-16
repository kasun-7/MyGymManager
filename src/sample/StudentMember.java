package sample;
//this is the StudentMember class connect to the DefaultMember
public class StudentMember extends DefaultMember{
    private String SchoolName;
//connect the string
    public StudentMember(String MembershipNo, String MemberName, String StartMembershipDate, String schoolName) {
        super(MembershipNo, MemberName, StartMembershipDate);
        this.setSchoolName(schoolName);
    }
//use return
    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        this.SchoolName = schoolName;
    }
}
