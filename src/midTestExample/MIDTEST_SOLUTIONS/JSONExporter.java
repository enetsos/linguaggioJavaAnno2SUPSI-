package a2021_2022.test_1.solutions;

import java.lang.reflect.Field;

interface IGeometryElement { /* empty implementation */ }

interface IFlatGeometry extends IGeometryElement { 
    double getArea();
}

class Point implements IGeometryElement {
    final int x = (int) (Math.random() * 10. - 5.);
    final int y = (int) (Math.random() * 10. - 5.);
    
    @Override
    public String toString() {
        return String.format("Point(x=%d, y=%d)", x, y);
    }
}

class Line implements IGeometryElement {
    final Point p0 = new Point();
    final Point p1 = new Point();
    
    @Override
    public String toString() {
        return String.format("Line(p0=%s, p1=%s)", p0, p1);
    }
}

class Circle implements IFlatGeometry {
    final Point center = new Point();
    final int radius = (int) (Math.random() * 10. + 1);
    
    @Override
    public double getArea() {
        return Math.pow(radius, 2.0) * Math.PI;
    }
    
    @Override
    public String toString() {
        return String.format("Circle(center=%s, radius=%d, area=%f)", center, radius, getArea());
    }
}


class Square implements IFlatGeometry {
    final Point center = new Point();
    final int side = (int) (Math.random() * 10. + 1);

    @Override
    public double getArea() {
        return Math.pow(side, 2.0);
    }
    
    @Override
    public String toString() {
        return String.format("Square(center=%s, side=%d, area=%f)", center, side, getArea());
    }
}

class Rectangle implements IFlatGeometry {
    final Point center = new Point();
    final int width = (int) (Math.random() * 10. + 1);
    final int heigth = (int) (Math.random() * 10. + 1);
    
    @Override
    public double getArea() {
        return width * heigth;
    }
    
    @Override
    public String toString() {
        return String.format("Rectangle(center=%s, width=%d, heigth=%d, area=%f)", center, width, heigth, getArea());
    }
}

public class JSONExporter {
    
    public static void main(String[] args) {
        
        final Point point = new Point();
        System.out.println("Point     : " + point);
        System.out.println("          : " + JSONExporter.toJSON(point));
        
        final Line line = new Line();
        System.out.println("Line      : " + line);
        System.out.println("          : " + JSONExporter.toJSON(line));
        
        final Circle circle = new Circle();
        System.out.println("Circle    : " + circle);
        System.out.println("          : " + JSONExporter.toJSON(circle));
        
        final Square square = new Square();
        System.out.println("Square    : " + square);
        System.out.println("          : " + JSONExporter.toJSON(square));

        final Rectangle rectangle = new Rectangle();
        System.out.println("Rectangle : " + rectangle);
        System.out.println("          : " + JSONExporter.toJSON(rectangle));
    }
    
    
    public static String toJSON(final IGeometryElement instance) {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        // FIXME to implement
        final Class<?> clazz = instance.getClass();
        sb.append(String.format("\"type\":\"%s\"", clazz.getSimpleName()));
       
        // Loop through declared fields
        for (final Field curField : clazz.getDeclaredFields()) {
            sb.append(toJSON(instance, curField));
        }
        sb.append("}");
        return sb.toString();
    }

    private static String toJSON(final Object instance, final Field field) {
        try {
            // Get field value
            final Object fieldValue = field.get(instance);
            final Class<?> fieldType = field.getType();

            // Handle primitive types
            if (fieldType.isPrimitive()) {
                return String.format(",\"%s\":%s", field.getName(), fieldValue);

            }
            // Handle IGeometryElement instances
            else if (IGeometryElement.class.isAssignableFrom(fieldType)) {
                // Recursive call to toJSON
                final String jsonValue = toJSON((IGeometryElement) fieldValue);
                return String.format(",\"%s\":%s", field.getName(), jsonValue);
            }
            // Default return empty string
            return "";

        } catch (IllegalArgumentException | IllegalAccessException e) {
            return "";
        }
    }    
}
