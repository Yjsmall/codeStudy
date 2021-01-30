package com.small.mine;

/**
 * @author small
 */
public class EnumTest {
    Spiciness spiciness;
    public EnumTest(Spiciness spiciness){
        this.spiciness = spiciness;
    }

    public EnumTest() {

    }

    void describe(){
        System.out.print("This burrito is ");
        switch (spiciness) {
            case NOT:
                System.out.println("not spicy at all");
                break;

            case MILD:
            case MEDIUM:
                System.out.println("a little hot.");
                break;

            case HOT:
            case FLAMING:
            default:
                System.out.println("maybe too hot");
        }
    }

    void showEnum(){
        for(Spiciness s : Spiciness.values()){
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }

    public static void main(String[] args) {
        EnumTest enumTest = new EnumTest();
        enumTest.showEnum();
        new EnumTest(Spiciness.NOT).describe();
    }
}

enum Spiciness {
    NOT,MILD,MEDIUM,HOT,FLAMING
}
