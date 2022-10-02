public class st {
    private static int a = 0;
    private int b;

    void set(int i, int j) {
        a = i;
        b = j;
    }

    void show() {
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        st x = new st();
        st y = new st();
        x.set(1, 2);
        x.show();
        y.set(2, 3);
        y.show();
        x.show();
    }
}
