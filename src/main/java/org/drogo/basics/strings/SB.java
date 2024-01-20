package org.drogo.basics.strings;

public class SB {
    public static void main(String[] args) {
        StringBuilder builder= new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch= (char)('a'+i);
            builder.append(ch);
        }
        System.out.println(builder);



        StringBuffer buffer= new StringBuffer();
        buffer.append("WeMakeDevs");
        System.out.println(buffer);
        String str= buffer.toString();
        System.out.println(str);

        //constructor 1
        StringBuffer sb= new StringBuffer();
        sb.append("WeMakeDevs");
       // sb.append(" is nice!");

       // sb.insert(2," Kunal ");

        System.out.println(sb);

        sb.replace(2,6,"don't make");

        System.out.println(sb);

        System.out.println(sb.reverse());



        //constructor 2
        StringBuffer sb1= new StringBuffer("Suraj Biradar");

        //constructor 3
        StringBuffer sb2= new StringBuffer(30);
        System.out.println(sb2.capacity());



    }
}
