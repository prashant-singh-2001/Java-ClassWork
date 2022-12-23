import java.io.*;

class TE2{
	public static void main(String s[]){
	try{
FileInputStream fx=new FileInputStream("A1.xyz");
ObjectInputStream ox=new ObjectInputStream(fx);
XYZ x=(XYZ) ox.readObject();
x.m1();}
catch(Exception e){}
	
}
}