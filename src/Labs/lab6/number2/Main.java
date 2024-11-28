package Labs.lab6.number2;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.toString());
    }
}
