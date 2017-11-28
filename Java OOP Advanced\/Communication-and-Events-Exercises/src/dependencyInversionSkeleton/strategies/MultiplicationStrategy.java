package dependencyInversionSkeleton.strategies;

/**
 * Created by Venelin on 14.4.2017 г..
 */
public class MultiplicationStrategy implements Strategy {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
