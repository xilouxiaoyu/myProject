package com.team.com.team.domain;

public class Architect extends Programmer{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, int stock) {
        super(id, name, age, salary, equipment);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetail()+"\t架构师\t" + getStatus() +"\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getDetailForTeam(){
        return getMemberId() +"/" + getName() +"\t" +getAge()  +"\t" + getSalary() +"架构师\t" + getStock();
    }
}
