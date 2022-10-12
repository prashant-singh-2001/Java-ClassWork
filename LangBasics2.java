public class LangBasics2 {
    public static void main(String[] args) {
        try {
            String str1=args[0].toString();
        System.out.println("Welcome "+str1);
        } catch (Exception e) {
            System.out.println("Invalid number of Inputs!");
        }
    }
}
