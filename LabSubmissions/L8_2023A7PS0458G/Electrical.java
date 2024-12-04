public class Electrical implements Degree {

    private final String degreeName = "Electrical";

    @Override
    public double getCGPACalculation(int[] marks) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getCGPACalculation'");
        int sum = 0;
        // System.out.println("HIIIIIIIII");
        for(int i = 0; i<marks.length; i++) {
            sum += marks[i];
        }
        return (double)sum/marks.length;
    }

    @Override
    public String getDegreeName() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getDegreeName'");
        return degreeName;
    }

    
}
