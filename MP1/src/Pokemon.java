import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pokemon extends ObjectPlus {
    private int id;
    private String name, gender, category;
    private float height, weight;
    private Type mainType;
    private Type secType;   //atr. Opcjonalny
    private Stats stats;    //atr. Złożony
    private int level = 1;
    private final static int maxLevel = 100;    //atr. klasowy
    private List<Move> moves = new ArrayList<>();   //atr. Powtarzalny

    public Pokemon(int id, String name, float height, float weight, String gender, Type mainType, String category, Stats stats, int level) {
        try {
            setId(id);
            setName(name);
            setHeight(height);
            setWeight(weight);
            setGender(gender);
            setMainType(mainType);
            setCategory(category);
            setStats(stats);
            setLevel(level);
        }catch (Exception e){
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public Pokemon(int id, String name, float height, float weight, String gender, String category, Type mainType, Type secType, Stats stats, int level) {
        try {
            setId(id);
            setName(name);
            setHeight(height);
            setWeight(weight);
            setGender(gender);
            setMainType(mainType);
            setSecType(secType);
            setCategory(category);
            setStats(stats);
            setLevel(level);
        }catch (Exception e){
            e.printStackTrace();
            removeFromExtent();
        }
    }

    public List<Move> getMoves() {
        return Collections.unmodifiableList(moves);
    }

    public void addMove(Move move) {
        moves.add(move);
    }

    public void removeMove(String name) {
        moves.removeIf(move -> move.getName().equals(name));
    }

    //Met. Klasowa
    public static Pokemon findPokemon(int id) {
        return ObjectPlus.getExtentFromClass(Pokemon.class).stream().filter(pokemon -> pokemon.getId() == id).findFirst().orElse(null);
    }

    //Przeciążenie
    public static Pokemon findPokemon(String name) {
        return ObjectPlus.getExtentFromClass(Pokemon.class).stream().filter(pokemon -> pokemon.getName().equals(name)).findFirst().orElse(null);
    }

    //Przesłonienie
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", mainType=" + mainType +
                ", secType=" + secType +
                ", stats=" + stats +
                ", level=" + level +
                ", moves=" + Arrays.toString(moves.toArray()) +
                '}';
    }

    //atr. Pochodny
    public int distanceToMaxLevel() {
        return maxLevel - level;
    }

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
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height < 0) throw new IllegalArgumentException("Height cannot be negative");
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isBlank()) throw new IllegalArgumentException("Gender cannot be null or blank");
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category == null || category.isBlank()) throw new IllegalArgumentException("category cannot be null or empty");
        this.category = category;
    }

    public Type getMainType() {
        return mainType;
    }

    public void setMainType(Type mainType) {
        this.mainType = mainType;
    }

    public Type getSecType() {
        return secType;
    }

    public void setSecType(Type secType) {
        this.secType = secType;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        if (stats == null) throw new IllegalArgumentException("Stats cannot be null");
        this.stats = stats;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > maxLevel) throw new IllegalArgumentException("Level must be between 1 and 100");
        this.level = level;
    }
}
