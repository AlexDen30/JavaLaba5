package TestClasses;
import TestClasses.FirstInterface;

public class Impl1 implements FirstInterface {
    @Override
    public void doSomething() {
        System.out.println("implements first interface");
    }
}
