// package equals;
import static java.lang.System.out;

import java.util.Random;

import equals.Employee;
import equals.Manager;

public class EqualsTest {
    
    public static void main(String[] args) 
        throws ReflectiveOperationException {
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        // out.println("alice1 == alice2:" + (alice1 == alice2));
        // out.println("alice1 == alice3:" + (alice1 == alice3));
        // out.println("alice1.equals(alice3)" + alice1.equals(alice3));
        // out.println("alice1.equals(bob)" + alice1.equals(bob));
        // out.println("bob.toString():" + bob);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        // out.println("boss.toString():" + boss);
        // out.println("carl.equals(boss):" + carl.equals(boss));
        // out.println("alice1.hashCode():" + alice1.hashCode());
        // out.println("alice3.hashCode():" + alice3.hashCode());
        // out.println("bob.hashCode():" + bob.hashCode());
        // out.println("carl.hashCode():" + carl.hashCode());

        // Employee ee = boss;
        // out.println("ee.getSlary:" + ee.getSalary());

        // alice1.test(carl);
        carl.test();
        out.println("" + alice1);
        out.println("" + carl);
        out.println(out);
        out.println(carl.getClass().getName() + " " + carl.getName());

        String className = "java.util.Random";
    
        Class cl = Class.forName(className);
        Object obj = cl.getConstructor().newInstance();
        
        out.println(((Random) obj).nextInt(0, 100));
       
        // if (carl instanceof Employee) {
        //     out.println("carl instanceof Employee");
        // }
    }
}
