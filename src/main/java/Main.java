import com.stack.arrayImplementation.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
//        boolean balanced = stack.isBalanced("({[1+2]})");
//        System.out.println(balanced);

        stack.push(5);
        stack.push(2);
        stack.push(10);
        stack.push(1);
        stack.pop();

        System.out.println(stack.minStack());

    }


}