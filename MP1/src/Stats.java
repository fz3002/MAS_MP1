public class Stats extends ObjectPlus{
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public Stats(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        try {
            setHp(hp);
            setAttack(attack);
            setDefense(defense);
            setSpecialAttack(specialAttack);
            setSpecialDefense(specialDefense);
            setSpeed(speed);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                ", speed=" + speed +
                '}';
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHp(int hp) {
        if (hp < 0) throw new IllegalArgumentException("Hp cannot be negative");
        this.hp = hp;
    }

    public void setAttack(int attack) {
        if (attack < 0) throw new IllegalArgumentException("Attack cannot be negative");
        this.attack = attack;
    }

    public void setDefense(int defense) {
        if (attack < 0) throw new IllegalArgumentException("Defense cannot be negative");
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack) {
        if (attack < 0) throw new IllegalArgumentException("Special Attack cannot be negative");
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense) {
        if (attack < 0) throw new IllegalArgumentException("Special Defense cannot be negative");
        this.specialDefense = specialDefense;
    }

    public void setSpeed(int speed) {
        if (attack < 0) throw new IllegalArgumentException("Speed cannot be negative");
        this.speed = speed;
    }
}
