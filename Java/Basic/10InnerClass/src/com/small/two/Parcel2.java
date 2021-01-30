package com.small.two;

/**
 * @author small
 */
public class Parcel2 {
    static class Contents {
        private final int i = 11;
        public int value() {
            return i;
        }
    }

    static class Destination {
        private final String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public Destination to(String s){
        return new Destination(s);
    }

    public Contents contents(){
        return new Contents();
    }

    public void ship(String dest){
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 parcel = new Parcel2();
        parcel.ship("BeiJing");
        Parcel2 parcel2 = new Parcel2();
        //使用内部类
        Parcel2.Contents c = parcel2.contents();
        Parcel2.Destination d = parcel2.to("Shanxi");


    }
}
