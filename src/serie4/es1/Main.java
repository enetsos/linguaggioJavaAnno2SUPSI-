package serie4.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String startClassName = "serie4.es1.NascarCar";
        String endClassName = "serie4.es1.F1Car";

        System.out.println(getPathToObject(startClassName));
        System.out.println(getPathToClass(startClassName, endClassName));
        System.out.println(getCommonAncestor(startClassName, endClassName));
    }

    private static List<String> getPathToObject(String startClassName) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        Class<?> class_ = Class.forName(startClassName);

        while (class_ != null) {
            list.add(class_.getSimpleName());

            class_ = class_.getSuperclass();
        }
        return list;
    }

    private static List<String> getPathToClass(String startClassName, String endClassName) throws ClassNotFoundException {
        List<String> list = new ArrayList<>();
        Class<?> class_ = Class.forName(startClassName);
        Class<?> endClass_ = Class.forName(endClassName);

        while (!class_.getName().equals(endClass_.getName())) {
            list.add(class_.getSimpleName());

            class_ = class_.getSuperclass();

            if (class_ == null)
                return Collections.emptyList();
        }
        return list;
    }

    private static String getCommonAncestor(String className0, String className1) throws ClassNotFoundException {
        List<String> path0 = null;
        List<String> path1 = null;

        path0 = getPathToObject(className0);
        path1 = getPathToObject(className1);
        path0.retainAll(path1);

        return path0.get(0);
    }
}
