package P03_DependencyInversion;


public class PrimitiveCalculator {

    private boolean isAddition;
    private AdditionStrategy additionStrategy;
    private SubtractionStrategy subtractionStrategy;

    public PrimitiveCalculator(){
        this.additionStrategy = new AdditionStrategy();
        this.subtractionStrategy = new SubtractionStrategy();
        this.isAddition = true;
    }

    public void changeStrategy(char operator){
        switch (operator){
            case '+': this.isAddition = true;
                break;
            case '-':this.isAddition = false;
                break;
        }
    }

    public int performCalculation(int firstOperand,int secondOperand){
        if(this.isAddition){
            return additionStrategy.Calculate(firstOperand,secondOperand);
        }
        else{
            return subtractionStrategy.Calculate(firstOperand,secondOperand);
        }
    }
}
