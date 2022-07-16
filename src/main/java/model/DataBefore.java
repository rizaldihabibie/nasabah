package model;

import com.opencsv.bean.CsvBindByPosition;

public class DataBefore {

    @CsvBindByPosition(position = 0)
    private int id;
    @CsvBindByPosition(position = 1)
    private String name;
    @CsvBindByPosition(position = 2)
    private int age;
    @CsvBindByPosition(position = 3)
    private int balanced;
    @CsvBindByPosition(position = 4)
    private int previousBalanced;
    @CsvBindByPosition(position = 5)
    private double averageBalanced;
    @CsvBindByPosition(position = 6)
    private int freeTransfer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalanced() {
        return balanced;
    }

    public void setBalanced(int balanced) {
        this.balanced = balanced;
    }

    public int getPreviousBalanced() {
        return previousBalanced;
    }

    public void setPreviousBalanced(int previousBalanced) {
        this.previousBalanced = previousBalanced;
    }

    public double getAverageBalanced() {
        return averageBalanced;
    }

    public void setAverageBalanced(double averageBalanced) {
        this.averageBalanced = averageBalanced;
    }

    public int getFreeTransfer() {
        return freeTransfer;
    }

    public void setFreeTransfer(int freeTransfer) {
        this.freeTransfer = freeTransfer;
    }
}
