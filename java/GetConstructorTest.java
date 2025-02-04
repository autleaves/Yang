
import java.lang.reflect.Constructor;
import static java.lang.System.out;

public class GetConstructorTest {


    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> clazz = Example.class;

            // Get the public constructor that takes a String argument
            Constructor<?> constructor = clazz.getConstructor(String.class);

            // Create an instance using the constructor
            Object obj = constructor.newInstance("Hello, Reflection!");

        } catch (Exception e) {
            e.printStackTrace();
        }  

        String[] strs = new String[10];
        Integer i = new Integer(12);
        out.println(i);
    }
}

class Example {
    public Example(){
        out.println("Constructor called with no parameter.");
    }
    public Example(String message) {
        System.out.println("Constructor called with: " + message);
    }
}