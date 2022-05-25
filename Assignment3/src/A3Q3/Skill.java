package A3Q3;

public class Skill {
    private String name;
    private int cd;
    private int atk;
    private int tempCd;

    public Skill(String name, int cd, int atk) {
        if (cd > 0 && atk > 0) {
            this.name = name;
            this.cd = cd;
            this.atk = atk;
            tempCd=cd;
        } else {
            this.name = "error";
            this.cd = 51;
            this.atk = 0;
        }
    }

    public String getSkillName() {
        return name;
    }

    public int getSkillCd() {
        return cd;
    }

    public int getSkillAtk() {
        return atk;
    }

    public int getTempCd() {
        return tempCd;
    }

    public void setTempCd(int tempCd) {
        this.tempCd = tempCd;
    }
}
