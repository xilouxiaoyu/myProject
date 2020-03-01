package com.team.com.team.domain;

public class Designer extends Programmer{

    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetail()+"\t设计师\t" + getStatus() +"\t"+bonus+"\t\t" + getEquipment().getDescription();
    }

    public String getDetailForTeam(){
        return getMemberId() +"/" + getName() +"\t" +getAge()  +"\t" + getSalary() +"设计师\t" + getBonus();
    }
}
