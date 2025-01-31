package equals;

import static java.lang.System.out;

import java.lang.reflect.Field;

public class Test {
    
    

    public static void main(String[] args)
        throws ReflectiveOperationException{ 

        var harry = new Employee("Harry Hacker", 50000, 2001, 10, 1);

        Class cl = harry.getClass();

        Field f = cl.getDeclaredField("name");
        f.setAccessible(true);
        
        out.println(f.get(harry));
        
        f.set(harry, "Alice");
        
        out.println(harry.getName());
        
    }
}
