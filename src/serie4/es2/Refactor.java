package serie4.es2;

import java.lang.reflect.*;

public class Refactor {
    public static void main(String[] args) {
        Target t = new Target();
        Field[] targets = t.getClass().getDeclaredFields();

        System.out.println("public class " +  t.getClass().getSimpleName()  + "{");

        System.out.println(getStringFields(t, targets));

        for (Field f : targets) {
            System.out.println(getStringGetter(f));
        }

        System.out.println(getStringFields(t, targets));
        for (Field f : targets) {
            System.out.println(getStringSetter(f));
        }

        System.out.println("}");
    }

    private static String getStringSetter(Field f) {
        String name = f.getName();
        String type = f.getType().getSimpleName();
        return "public void set" + name.substring(0, 1).toUpperCase() + name.substring(1) + "(" + type + " " + name + ") { this." + name + " = " + name + "; }";
    }

    private static String getStringGetter(Field f) {
        String name = f.getName();
        String type = f.getType().getSimpleName();
        String getter = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        return String.format("public %s %s() { return %s; }", type, getter, name);
    }

    private static String getStringFields(Target target, Field[] fields) {
        String stringa = "";

        try {
            for (Field f : fields) {
                stringa += "private " + f.getType().getSimpleName() + " " + f.getName() + "\n";
            }
        } catch (IllegalAccessError e) {
            e.printStackTrace();
        }
        return stringa;
    }

}
