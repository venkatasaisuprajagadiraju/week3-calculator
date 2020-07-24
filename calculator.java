
  
package com.epam.calculator.entity;

import com.epam.calculator.validate.Validator;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class Calculator {
    public static BigDecimal sum(BigDecimal first, BigDecimal second) {
        return first.add(second);
    }

    public static BigDecimal difference(BigDecimal first, BigDecimal second) {
        return first.subtract(second);
    }

    public static BigDecimal multiplication(BigDecimal first, BigDecimal second) {
        return first.multiply(second);
    }

    public static BigDecimal division(BigDecimal first, BigDecimal second) {
        return first.divide(second);
    }

    public static BigDecimal calculateExpression(Expression expression) {
        if (Validator.validateExpression(expression)) {
            switch (expression.getSign()) {
                case DIV: return division(expression.getFirst(), expression.getSecond());

                case MULT: return multiplication(expression.getFirst(), expression.getSecond());

                case MINUS: return difference(expression.getFirst(), expression.getSecond());

                case PLUS: return sum(expression.getFirst(), expression.getSecond());
            }
        }
        throw new InvalidParameterException("Expression is invalid");
    }
}
