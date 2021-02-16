package sample;
//this class is vey important class to programme and connect to the all main classes

//used implement and add the strings
public  class DefaultMember implements Comparable<DefaultMember>{
    private String Membership_No;
    private String Member_Name;
    private String StartMembership_Date;
    private String StartMembership_Type;
    private String StartMembership_NIC;

//set as the string
    public DefaultMember(String Membership_No,String Member_Name,String StartMembership_Date){
        super();
        this.setMembership_No(Membership_No);
        this.setMember_Name(Member_Name);
        this.setStartMembership_Date(StartMembership_Date);
        this.setMembership_Type(StartMembership_Type);

    }

    public String getMembership_No() {
        return Membership_No;
    }//this one display the membership number in the table
    public void setMembership_No(String membership_No) {
        this.Membership_No = membership_No;
    }

    public String getMember_Name() {
        return Member_Name;
    }//this one display the membership name in the table

    public void setMember_Name(String member_Name) {
        this.Member_Name = member_Name;
    }

    public String getStartMembership_Date() {
        return StartMembership_Date;
    }

    public void setStartMembership_Date(String startMembership_Date) {
        this.StartMembership_Date = startMembership_Date;//this one display the present dates of the membership holders
    }
    public String getMembership_Type(){
        return StartMembership_Type;
    }
    public void setMembership_Type(String startMembership_Type) {
        this.StartMembership_Type = startMembership_Type;//this one display the occupation of the membership holders
    }



    @Override
    public int compareTo(DefaultMember o) {
        return this.Member_Name.compareTo(o.getMember_Name());
    }
}
