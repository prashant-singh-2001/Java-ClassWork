public class LangBasics1 {
    public static void main(String[] args) {
        try {
            String str1=args[0].toString();
        String str2=args[1].toString();
        System.out.println(str1+" Technologies "+str2);
        } catch (Exception e) { System.out.println("Invalid number of Inputs!");
        }
    }
}
