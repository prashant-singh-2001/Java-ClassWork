import java.util.*;
public class power {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter values : ");
        String s = scan.nextLine();
        String s_array[] = s.split("[ ,]+");
      List<String> setAsList = Arrays.asList(s_array);
      List<List<String>> powerSet = powerSetWithPrefix(new ArrayList(), setAsList);
      powerSet.sort( (List<String> l1, List<String> l2) -> l1.size() - l2.size());
      printPowerSet(powerSet);

    }
    static List<List<String>> powerSetWithPrefix(List<String> prefix, List<String> remaining){
        if (remaining.isEmpty()) {
            List<List<String>> ret = new ArrayList();
            ret.add(prefix);
            return ret;
        }
        List<String> tail = remaining.subList(1, remaining.size());
        String head = remaining.get(0);
        List<String> prefixWithout = new ArrayList(prefix);
        List<String> prefixWith = new ArrayList(prefix);
        prefixWith.add(head);
        List<List<String>> powerSet = powerSetWithPrefix(prefixWith, tail);
        powerSet.addAll(powerSetWithPrefix(prefixWithout, tail));
        return powerSet;
    }
    static void printPowerSet(List<List<String>> powerSet){
        System.out.println("Printing powerset:");
        for (List<String> set:  powerSet) {
            System.out.printf("[%s]\n", String.join(", ", set));
        }
    }
}