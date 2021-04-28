import java.lang.annotation.Annotation;
import java.lang.reflect.Field;



public class Injector {

    /**
     * Ищет в объекте obj поля помеченные
     * аннотацией AutoInjectable и осуществляет
     * их инициализацию классом, который реализует
     * интерфейс описаный в это поле
     *
     * @param obj - Объект, который будет инициализирован
     * @param <T>
     * @return Инициализированный объект
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
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
