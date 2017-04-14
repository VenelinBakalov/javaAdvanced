package dependencyInversionSkeleton;

import dependencyInversionSkeleton.strategies.AdditionStrategy;
import dependencyInversionSkeleton.strategies.Strategy;

public class PrimitiveCalculator {
    private static final String STRATEGY_SUFFIX = "Strategy";

    private Strategy strategy;

    public PrimitiveCalculator(){
        this.strategy = new AdditionStrategy();
    }

    public void changeStrategy(char operator) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        for (Operation operation : Operation.values()) {
            if (operator == operation.getOperationType()) {
                this.strategy = this.getStrategy(operation);
                break;
            }
        }
    }

    private Strategy getStrategy(Operation operation) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String strategyFullName = Strategy.class.getName() + STRATEGY_SUFFIX;
        String abstractStrategyName = Strategy.class.getSimpleName();
        String implementationStrategyName = operation.toString();

        Strategy strategy = (Strategy) Class
                .forName(strategyFullName.replace("." + abstractStrategyName, "." + implementationStrategyName))
                .newInstance();
        return strategy;
    }

    public int performCalculation(int firstOperand,int secondOperand){
        return this.strategy.calculate(firstOperand, secondOperand);
    }
}
