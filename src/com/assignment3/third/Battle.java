package com.assignment3.third;

public class Battle {
    public static Player tatakai(Player p1, Player p2) {
        return battleWin(p1, p2);
    }

    public static Player battleWin(Player p1, Player p2) {
        Player winner;
        Pokemon on1 = release(p1);
        Pokemon on2 = release(p2);
        for (int i = 0; i < 50; i++) {
            attackA(on1, on2);
            if (checkHp(on1, on2)) {
                continue;
            } else {
                on1 = release(p1);
                on2 = release(p2);
                if (on1.getTempHp() <= 0 || on2.getTempHp() <= 0) {
                    winner = checkWinner(p1, p2);
                    recover(p1);
                    recover(p2);
                    return winner;
                }
            }
        }
        recover(p1);
        recover(p2);
        return null;
    }

    public static void recover(Player pl) {
        for (int i = 0; i < pl.pokemons.size(); i++) {
            Pokemon re = pl.pokemons.get(i);
            re.setTempHp(re.getHp());
            re.skill.setTempCd(re.skill.getSkillCd());
        }
    }

    public static Boolean checkHp(Pokemon on1, Pokemon on2) {
        if (on1.getTempHp() > 0 && on2.getTempHp() > 0) {
            return true;
        } else {
            on1.skill.setTempCd(on1.skill.getSkillCd());
            on2.skill.setTempCd(on2.skill.getSkillCd());
            return false;
        }
    }

    public static Pokemon release(Player pl) {
        Pokemon on = new Pokemon("On", 0, 0, null, 0, 0, 0, 0);
        for (int i = 0; i < pl.pokemons.size(); i++) {
            if (pl.pokemons.get(i).getTempHp() > 0) {
                on = pl.pokemons.get(i);
                break;
            } else if (i == pl.pokemons.size() - 1) {
                on = pl.pokemons.get(i);
            }
        }
        return on;
    }

    public static Player checkWinner(Player p1, Player p2) {
        Pokemon on1 = release(p1);
        Pokemon on2 = release(p2);
        if (on1.getTempHp() > 0 && on2.getTempHp() <= 0 || on1.getTempHp() != 0 && on2.getTempHp() == 0) {
            return p1;
        } else {
            return p2;
        }
    }

    public static Boolean checkSpeed(Pokemon on1, Pokemon on2) {
        if (on1.getSpeed() < on2.getSpeed()) {
            return false;
        } else {
            return true;
        }
    }

    public static void attackA(Pokemon on1, Pokemon on2) {
        int hp1 = on1.getTempHp();
        int hp2 = on2.getTempHp();
        if (checkSpeed(on1, on2)) {
            int dam1 = dam(on1);
            on2.setTempHp(hp2 - dam1);
            if (on2.getHp() > 0) {
                int dam2 = dam(on2);
                on1.setTempHp(hp1 - dam2);
            }
        } else {
            int dam2 = dam(on2);
            on1.setTempHp(hp1 - dam2);
            if (on1.getTempHp() > 0) {
                int dam1 = dam(on1);
                on2.setTempHp(hp2 - dam1);
            }
        }
    }

    public static int dam(Pokemon on) {
        int tempCd = on.skill.getTempCd();
        int dam;
        on.skill.setTempCd(tempCd - 1);
        if (on.skill.getTempCd() != 0) {
            dam = on.getAtk();
        } else {
            dam = on.skill.getSkillAtk();
            on.skill.setTempCd(on.skill.getSkillCd());
        }
        return dam;
    }
}
