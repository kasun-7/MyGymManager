package sample;//display the interface include the inputs

import java.util.List;

public interface GymManager {
    public void Add_Member(DefaultMember member);
    public boolean Del_Member(String MembershipNo);
    public void PrintList_OfMembers();
    public void sort();
    public void save();
    public List<DefaultMember>getMemberList();
    public DefaultMember getMemberbyMembershipNo(String MembershipNo);
    public DefaultMember[] getMemberbyName(String name);
}

