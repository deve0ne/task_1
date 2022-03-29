package deveone;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> t1 = new Stack<>(Integer.class);

        for (int i = 0; i < 11; i++) {
            t1.push(i);
        }

        t1.pop();
        t1.pop();

        System.out.println(t1);
        System.out.println(t1.peek());
        System.out.println(t1.search(3));
        System.out.println(t1.search(null));
    }
}
