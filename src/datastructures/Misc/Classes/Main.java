package datastructures.Misc.Classes;

public class Main {
    public static void main(String[] args) {

        Cookie cookieOne = new Cookie("Green");
        Cookie cookieTwo = new Cookie("Blue");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());

        cookieTwo.setColor("Yellow");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());
    }

}
