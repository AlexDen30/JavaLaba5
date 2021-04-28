import TestClasses.FirstInterface;
import TestClasses.SecondInterface;

public class TestClass {
    @AutoInjectable
    private FirstInterface field1;
    @AutoInjectable
    private SecondInterface field2;


    public void func() {
        field1.doSomething();
        field2.doSomethingOther();
    }
}
