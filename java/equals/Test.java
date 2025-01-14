import static java.lang.System.out;
import java.util.Random;

public class Test {
    
    

    public static void main(String[] args){ 
        String className = "java.util.Random";
        Class cl;
        Object obj;
        try {
            cl = Class.forName(className);
            obj = cl.getConstructor().newInstance();
            out.println(obj);
        } catch (Exception e) {
            // TODO: handle exception
        }
        

        
    }
}
