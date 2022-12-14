package serie4.es3;

import java.lang.reflect.*;
class Coordinate {
    private float lat;
    private float lon;

    public Coordinate() {
        this.lat = (float) (Math.random() * 180. -  90.); // between -90;+90
        this.lon = (float) (Math.random() * 360. - 180.);// between -180;+180
    }

    public Coordinate(float lat, float lon) {
        if (!isValidLat(lat))
            throw new IllegalArgumentException("Invalid latitude");
        if (!isValidLon(lat))
            throw new IllegalArgumentException("Invalid longitude");
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    private static boolean isValidLat(float lat) {
        return (lat <= 90 && lat >= -90);
    }

    private static boolean isValidLon(float lon) {
        return (lon <= 180 && lon >= -180);
    }

    public double distance(Coordinate other) {
        return Math.acos(Math.sin(lat)*Math.sin(other.lat)+Math.cos(lat)*Math.cos(other.lat)*Math.cos(other.lon-lon))*6371;
    }

    @Override
    public String toString() {
        return String.format("Coordinate@%s (lat=%.5f, lon=%.5f)", hashCode(), getLat(), getLon());
    }
}

public class DocumentationHelper {

    private static void toMarkdown(final Class<?> theClass) {
        // FIXME to implement
        System.out.println("#" + theClass.getName());

        System.out.println("\n##Constructor");
        for (Constructor<?> constructor : theClass.getDeclaredConstructors()) {
            System.out.println("###" + constructor);
        }

        System.out.println("\n##Methods");
        for (Method method : theClass.getDeclaredMethods()) {
            System.out.println("###" + method.toGenericString());
        }

        System.out.println("\n##Parameters");
        for (Field field : theClass.getDeclaredFields()) {
            System.out.println("###" + field);
        }

    }

    public static void main(String[] args) {
        toMarkdown(Coordinate.class);
    }
}
