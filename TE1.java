import java.io.*;

class XYZ implements Serializable
{
	double d1;
	double d2;
	static double d3;
	void m1(){
		System.out.println("Value of D1: " +d1);
		System.out.println("Value of D2: " +d2);
		System.out.println("Value of D3: " +d3);
		}
}

class TE1{
	public static void main(String s[]) throws IOException
	{
		XYZ x=new XYZ();
		x.d1=10.3;
		x.d2=11.56;
		x.d3=12.17;
		x.m1();
		FileOutputStream fc= new FileOutputStream("A1.xyz");
		ObjectOutputStream oc=new ObjectOutputStream(fc);
		oc.writeObject(x);
		oc.flush();		
	}
}