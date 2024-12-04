import java.util.*;

class FigureManager {
    Figure[] figures;

    FigureManager(Figure[] figures) {
        this.figures = figures;
    }

    // Count Figures by Type
    void countFigures() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Figure figure : this.figures) {
            if (!map.containsKey(figure.name)) {
                map.put(figure.name, 1);
                continue;
            }
            int prevValue = map.get(figure.name);
            map.put(figure.name, prevValue + 1);
        }

        if (!map.containsKey("Triangle")) { map.put("Triangle", 0); }
        if (!map.containsKey("Rectangle")) { map.put("Rectangle", 0); }
        if (!map.containsKey("Rhombus")) { map.put("Rhombus", 0); }

        System.out.println("Figure counts:");
        System.out.println("Triangles: " + map.get("Triangle"));
        System.out.println("Rectangles: " + map.get("Rectangle"));
        System.out.println("Rhombuses: " + map.get("Rhombus"));
    }

    // Find Largest Areas
    void findLargestAreas() {
        Map<String, Double> map = new HashMap<String, Double>();

        for (Figure figure : this.figures) {
            if (!map.containsKey(figure.name)) {
                map.put(figure.name, figure.getArea());
                continue;
            }

            double prevValue = map.get(figure.name);
            map.put(figure.name, Math.max(prevValue, figure.getArea()));
        }

        if (!map.containsKey("Triangle")) { map.put("Triangle", -1.0); }
        if (!map.containsKey("Rectangle")) { map.put("Rectangle", -1.0); }
        if (!map.containsKey("Rhombus")) { map.put("Rhombus", -1.0); }

        System.out.println("Largest areas:");
        System.out.println("Triangle: " + map.get("Triangle"));
        System.out.println("Rectangle: " + map.get("Rectangle"));
        System.out.println("Rhombus: " + map.get("Rhombus"));
    }

    // Count Figures by Area
    void countFiguresByArea() {
        Map<Double, Integer> map = new HashMap<Double, Integer>();

        for (Figure figure : this.figures) {
            if (!map.containsKey(figure.getArea())) {
                map.put(figure.getArea(), 1);
                continue;
            }
            int prevValue = map.get(figure.getArea());
            map.put(figure.getArea(), prevValue + 1);
        }

        if (!map.containsKey(20.0)) { map.put(20.0, 0); }
        if (!map.containsKey(30.0)) { map.put(30.0, 0); }

        System.out.println("Figures with area 20.0: " + map.get(20.0));
        System.out.println("Figures with area 30.0: " + map.get(30.0));
    }

    // Replace Figures Based on Precedence
    void replaceFigures() {

        Map<Double, Figure> map = new HashMap<Double, Figure>();

        for (Figure figure : this.figures) {
            if (!map.containsKey(figure.getArea())) {
                map.put(figure.getArea(), figure);
                continue;
            }

            if (map.get(figure.getArea()).name.equals("Triangle")) {
                map.put(figure.getArea(), figure);
                continue;
            }
            if (map.get(figure.getArea()).name.equals("Rectangle") && !figure.name.equals("Triangle")) {
                map.put(figure.getArea(), figure);
                continue;
            }
            if (map.get(figure.getArea()).name.equals("Rhombus") && figure.name.equals("Rhombus")) {
                map.put(figure.getArea(), figure);
                continue;
            }
        }

        if (map.containsKey(20.0)) {
            System.out.println("Figure with area 20.0: " + map.get(20.0).name);
        } else {
            System.out.println("Figure with area 20.0: Key not present.");
        }

        if (map.containsKey(30.0)) {
            System.out.println("Figure with area 30.0: " + map.get(30.0).name);
        } else {
            System.out.println("Figure with area 30.0: Key not present.");
        }
    }

    // Calculate Average Areas by Figure Type
    void calculateAverageAreas() {
        Map<String, Double> areaMap = new HashMap<String, Double>();
        Map<String, Integer> countMap = new HashMap<String, Integer>();

        for (Figure figure : this.figures) {
            if (!areaMap.containsKey(figure.name)) {
                areaMap.put(figure.name, figure.getArea());
                countMap.put(figure.name, 1);
                continue;
            }

            double prevValue = areaMap.get(figure.name);
            areaMap.put(figure.name, prevValue + figure.getArea());
            int prevCount = countMap.get(figure.name);
            countMap.put(figure.name, prevCount + 1);
        }

        System.out.println("Average areas:");

        if (countMap.containsKey("Triangle")) {
            System.out.println("Triangle: " + areaMap.get("Triangle") / countMap.get("Triangle"));
        }
        if (countMap.containsKey("Rectangle")) {
            System.out.println("Rectangle: " + areaMap.get("Rectangle") / countMap.get("Rectangle"));
        }
        if (countMap.containsKey("Rhombus")) {
            System.out.println("Rhombus: " + areaMap.get("Rhombus") / countMap.get("Rhombus"));
        }
    }
}

