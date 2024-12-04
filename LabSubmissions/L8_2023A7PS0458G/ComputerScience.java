public class ComputerScience implements Degree {
    private final String degreeName = "Computer Science";

    @Override
    public double getCGPACalculation(int[] marks) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getCGPACalculation'");
        int ans = 0;
        for (int i = 0; i<marks.length-2; i++) {
            int a = marks[i] + marks[i+1] + marks[i+2];
            if (a > ans) ans = a;
        }
        return (double)ans/3;
    }

    @Override
    public String getDegreeName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getDegreeName'");
        return degreeName;
    }

    
}
