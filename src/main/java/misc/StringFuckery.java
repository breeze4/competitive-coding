package misc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class StringFuckery {

    public static void main(String[] args) {

        try {

            String s = "test";
            char[] newval = new char[]{"t".charAt(0), "e".charAt(0), "s".charAt(0), "t".charAt(0)};
            Class<?> c = String.class;
            Field[] declaredFields = c.getDeclaredFields();
            System.out.println(Arrays.toString(declaredFields));
            for (Field f : s.getClass().getDeclaredFields()) {
                if ("value".equals(f.getName())) {
                    f.set(s, newval);
                    System.out.println(s);
//                    System.out.format("Name: %s%n", f.getName());
//                    System.out.format("Modifiers: %s%n", f.getModifiers());
//                    System.out.format("Type: %s%n", f.getType());
//                    System.out.format("GenericType: %s%n", f.getGenericType());

                }
            }

            Field f = c.getField("value");
            System.out.format("Name: %s%n", f.getName());
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
