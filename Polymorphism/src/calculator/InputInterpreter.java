package calculator;

import java.util.Stack;

public class InputInterpreter {
    private CalculationEngine engine;
    private Stack<Integer> memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new Stack<>();
    }

    public Stack<Integer> getMemory() {
        return memory;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("mr")) {
            return new MemorySaverOperation();
        } else if (operation.equals("ms")) {
            return new MemoryRecallOperation();
        }

        return null;
    }
}
