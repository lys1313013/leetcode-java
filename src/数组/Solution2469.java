package 数组;

class Solution2469 {
    public double[] convertTemperature(double celsius) {
        double kai = celsius + 273.15;
        double hua = celsius * 1.80 + 32.00;
        return new double[]{kai, hua};
    }
}