import java.util.Scanner;

class Stack
{
    private char item[];
    private int top;
    private char name;
    Stack(char name)
    {
        this.item=new char[100];
        this.top=-1;
        this.name=name;
    }
    void push(char a)
    {
        this.item[++this.top]=a;
    }
    char pop()
    {
        return this.item[this.top--];
    }
    boolean isFull()
    {
        return this.top==100-1?true:false;
    }
    boolean isEmpty()
    {
        return this.top==-1?true:false;
    }
    void viewStack()
    {
        for (int i=0;i<=top;i++) {
        System.out.print(" >> "+item[i]);    
    }
    System.out.println("");
    }
    @Override
    public String toString() {
        return name+"";
    }
}
public class towerofHanoi {
    static Stack hanoi(int n,Stack a,Stack b,Stack c)
    {
        char d;
        if(n>0)
        {
            hanoi(n-1, a, c, b);
            d=a.pop();
            b.push(d);
            System.out.println("Move disk " + n + " from rod " +  a.toString() + " to rod " + b.toString());
            hanoi(n-1, c, b, a);
        }
        return b;
    }
    public static void main(String[] args) {
    Stack a=new Stack('A');
    Stack b=new Stack('B');
    Stack c=new Stack('C');
    char data;

    System.out.println("Enter the size of tower");
    int n=(new Scanner(System.in)).nextInt();
    data=(char)(64+n);
    while(data!=64)
    {
        a.push(data--);
    }
    a.viewStack();
    b=hanoi(n, a, b, c);
    b.viewStack();
}
}
