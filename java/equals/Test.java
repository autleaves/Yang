// package equals;

import static java.lang.System.out;

public class Test {
    
    public static void main(String[] args){
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);
       
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] emploees = {alice1,alice2,alice3,bob,carl,boss};
        Manager aa;

        if(emploees[4] instanceof Manager){
            aa = (Manager) emploees[4];
            out.println("emplees[4] is a instance of Manager");
        } else {
            out.println("emplees[4] is not a instance of Manager");
        }
        aa = (Manager) emploees[0];
        aa.setBonus(4000);
        if(emploees[0] instanceof Manager){
            aa = (Manager) emploees[0];
            out.println("emplees[0] is a instance of Manager");
        } else {
            out.println("emplees[0] is not a instance of Manager");
        }

    }
}
