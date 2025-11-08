package bean;

public class NumberProcessor {
private int[] numbers;
    
    public NumberProcessor(int[] numbers) {
        this.numbers = numbers.clone(); 
    }
    
    private boolean isDivisibleByBoth(int num) {
        return num % 5 == 0 && num % 7 == 0;
    }
    
    private boolean isDivisibleBySeven(int num) {
        return num % 7 == 0;
    }
    
    private boolean isDivisibleByFive(int num) {
        return num % 5 == 0;
    }
    
    public String processArray() {
        StringBuilder result = new StringBuilder();
        
        StringBuilder divisibleByBoth = new StringBuilder();
        StringBuilder divisibleBySeven = new StringBuilder();
        StringBuilder divisibleByFive = new StringBuilder();
        StringBuilder others = new StringBuilder();
        
        for (int num : numbers) {
            if (isDivisibleByBoth(num)) {
                if (divisibleByBoth.length() > 0) {
                    divisibleByBoth.append(", ");
                }
                divisibleByBoth.append(num);
            } else if (isDivisibleBySeven(num)) {
                if (divisibleBySeven.length() > 0) {
                    divisibleBySeven.append(", ");
                }
                divisibleBySeven.append(num);
            } else if (isDivisibleByFive(num)) {
                if (divisibleByFive.length() > 0) {
                    divisibleByFive.append(", ");
                }
                divisibleByFive.append(num);
            } else {
                if (others.length() > 0) {
                    others.append(", ");
                }
                others.append(num);
            }
        }
        
        if (divisibleBySeven.length() > 0) {
            result.append(divisibleBySeven);
        }
        
        if (others.length() > 0) {
            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append(others);
        }
        
        if (divisibleByFive.length() > 0) {
            if (result.length() > 0) {
                result.append(" | ");
            }
            result.append(divisibleByFive);
        }
        
        return result.toString();
    }

}