public class LangBasics3 {
    public static void main(String[] args) {
        try {
            int int1 = Integer.parseInt(args[0].toString());
            int int2 = Integer.parseInt(args[1].toString());
            int res = int1 + int2;
            System.out.println("The sum of " + int1 + " and " + int2 + " is " + res);
        } catch (Exception e) {
            System.out.println("Invalid number of Inputs!");
        }
    }
}
