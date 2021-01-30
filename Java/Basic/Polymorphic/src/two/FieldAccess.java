package two;

/**
 * @author small
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field=" + sup.field + "," +
                "sup.getField()=" + sup.getField());

        Sub sub = new Sub();
        System.out.println("sub.field=" + sub.field + "," +
                "sub.getField=" + sub.getField() + "," +
                "sub.getSuperField=" + sub.getSuperField());
    }

}

class Super {
    public int field = 0;
    public int getField() {
        return field;
    }

}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        //这里的super相当于this
        //super指代父类引用,this表示当前类的引用
        return super.field;
    }
}