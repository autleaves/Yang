import java.time.LocalDate;

class Pa {
    void get(Object obj) {
        System.out.println("Parent method with Object parameter");
    }
}

class Ch extends Pa {
    void get(LocalDate date) {
        System.out.println("Child method with LocalDate parameter");
    }
}

public class Test {
    public static void main(String[] args) {
        Pa p = new Ch(); // 父类引用指向子类对象
        p.get(LocalDate.now()); // 传入 LocalDate 类型实参
    }
}