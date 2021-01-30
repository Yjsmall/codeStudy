package com.small;

/**
 * @author small
 */
public class Compute {
    float num1;
    int operator;
    float num2;
    float result;

    public Compute() {
        super();
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public float getResult() { // 计算式的运算结果
        float result1 = 0;
        try {
            switch (operator) {
                case 1:
                    result1 = num1 + num2;
                    break;
                case 2:
                    result1 = num1 - num2;
                    break;
                case 3:
                    result1 = num1 * num2;
                    break;
                case 4:
                    result1 = num1 / num2;
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return result1;
    }
}
