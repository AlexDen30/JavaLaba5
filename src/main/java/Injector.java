import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Injector {

    public <T extends Object> T inject (T obj) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Class cl = obj.getClass();
        Field [] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            Annotation an = field.getAnnotation(AutoInjectable.class);
            if (an == null) {
                continue;
            }

            field.setAccessible(true);
            String name = (new ReadPropertiesUtil()).getRealizationValue(field.getType().getName());
            Class c = Class.forName(name);
            field.set(obj, c.newInstance());
            field.setAccessible(false);
        }
        return obj;
    }
}
