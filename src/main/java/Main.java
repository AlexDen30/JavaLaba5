

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        TestClass testClass = (new Injector()).inject(new TestClass());
        testClass.func();
    }
}
