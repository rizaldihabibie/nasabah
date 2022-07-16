package model;

public class DataAfter {
    private int id;
    private String name;
    private int age;
    private int balanced;
    private int previousBalanced;
    private double averageBalanced;
    private int freeTransfer;
    private long No1ThreadNo;
    private long No2aThreadNo;
    private long No2bThreadNo;
    private long No3ThreadNo;

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

    public long getNo1ThreadNo() {
        return No1ThreadNo;
    }

    public void setNo1ThreadNo(long no1ThreadNo) {
        No1ThreadNo = no1ThreadNo;
    }

    public long getNo2aThreadNo() {
        return No2aThreadNo;
    }

    public void setNo2aThreadNo(long no2aThreadNo) {
        No2aThreadNo = no2aThreadNo;
    }

    public long getNo2bThreadNo() {
        return No2bThreadNo;
    }

    public void setNo2bThreadNo(long no2bThreadNo) {
        No2bThreadNo = no2bThreadNo;
    }

    public long getNo3ThreadNo() {
        return No3ThreadNo;
    }

    public void setNo3ThreadNo(long no3ThreadNo) {
        No3ThreadNo = no3ThreadNo;
    }

    @Override
    public String toString() {
        return id +
                ";" + name +
                ";" + age +
                ";" + balanced +
                ";" + No2bThreadNo +
                ";" + No3ThreadNo+
                ";" + previousBalanced +
                ";" + averageBalanced +
                ";" + No1ThreadNo +
                ";" + freeTransfer +
                ";" + No2aThreadNo
                ;
    }
}
