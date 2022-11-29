package testProva.es2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Anal {
    public static void main(String[] args) {
        Autorun autorun = new Autorun();

        Method[] methods = autorun.getClass().getDeclaredMethods();

        for(Method method : methods){
            method.setAccessible(true);
            if(method.getName().startsWith("autorun")){
                Parameter[] parameters = method.getParameters();
                for(Parameter parameter : parameters){
                    if(parameter.getType().equals(String.class)){
                        try{
                            method.invoke(autorun, method.getName());
                        }catch (InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    } else if (parameter.getType().equals(Integer.class)) {
                        try{
                            method.invoke(autorun, Math.random() % 21 + 10);
                        }catch (InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }else {
                        try{
                            method.invoke(autorun);
                        }catch (InvocationTargetException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
