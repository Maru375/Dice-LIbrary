package main;

public class Dice {
    private int num;

    public Dice(int num){
        if(num < 1 || num > 6){
            throw new IllegalArgumentException("1 미만 또는 6 초과 주사위는 생성할 수 없습니다.");
        }
        this.num = num;
    }

    public int getNumber() {
        return this.num;
    }

    public String toString(){
        return getNumber() + "";
    }
}
