/**
 * c&a
 */
public class c_a {
    public static void main(String[] args) {
        stu s1=new stu();
    stu s2=new stu(0,"abc");
    System.out.println(s1.getStu());
    System.out.println(s2.getStu());
    }
    
}
class stu
{
    int rn;
    String name;
    String branch;
    stu()
    {
        this(0,null);
        rn=0;
    }
    stu(int rn, String name)
    {
        this.rn=rn;
        this.name=name;
    }
    void setName(String name)
    {
        this.name=name;
    }
    void setBranch(String branch)
        {
            this.branch=branch;
        }
        void setRN(int rn)
        {
            this.rn=rn;
        }
    String getStu()
    {
        return "The student is " + name+" of branch " + branch+". Roll number is : "+rn;
    }
}