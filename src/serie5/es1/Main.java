

import java.lang.reflect.Field;
import java.util.HashSet;

public class Main {
    private final static HashSet<String> fieldNames = new HashSet<String>();
    
    // class name, implementation
    private static final String classTemplate = "public class %s {\n%s}"; 

    // type, field name, field value
    private static final String fieldTemplate = "\tprivate %s %s = %s;\n"; 

    // type, field name, field value
    private static final String fieldStringTemplate = "\tprivate %s %s = \"%s\";\n"; 
    
    // return type, method name, field name
    private static final String getterTemplate = "\tpublic %s get%s(){\n\t\treturn %s;\n\t}\n"; 
    
    // method name, parameter type, parameter, field name, parameter
    private static final String setterTemplate = "\tpublic void set%s(%s %s){\n\t\tthis.%s = %s;\n\t}\n"; 

    public static String generate(String className) throws Exception {
        Class<?> targetClass = null;
        String generatedCode = "";
        try {
            targetClass = Class.forName(className);
            generatedCode = String.format(classTemplate, targetClass.getSimpleName(),
                    generateImplementation(targetClass));
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return generatedCode;
    }

    private static String generateImplementation(Class<?> clazz) throws Exception {
        // FIXME to implement
        return "";
    }

    static private Field[] extractFields(Class<?> clazz) {
        return clazz.getDeclaredFields();
    }

    public static void main(String[] args) {
        try {
            System.out.println(generate("Target"));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}
