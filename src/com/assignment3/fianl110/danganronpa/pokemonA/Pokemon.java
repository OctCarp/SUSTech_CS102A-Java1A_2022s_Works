package com.assignment3.fianl110.danganronpa.pokemonA;

public class Pokemon {
    private String name;
    private int hp;
    private int tempHp;
    private int atk;
    private int level;
    private int speed;
    private int rateAtk;
    private int rateHp;
    Skill skill;

    public void learnSkill(Skill skill) {
        this.skill = skill;
    }

    public Pokemon(String name, int hp, int atk, Skill skills, int level, int speed, int rateAtk, int rateHp) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        skill = skills;
        this.level = level;
        this.speed = speed;
        this.rateAtk = rateAtk;
        this.rateHp = rateHp;
        tempHp=hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public void levelUP(int up) {
        int oldHp = getHp();
        int oldAtk = getAtk();
        setAtk(rateAtk * up + oldAtk);
        setHp(rateHp * up + oldHp);
        tempHp=rateHp * up + oldHp;
    }
    public void setTempHp(int tempHp){
        this.tempHp=tempHp;
    }
    public int getTempHp(){
        return tempHp;
    }
}
