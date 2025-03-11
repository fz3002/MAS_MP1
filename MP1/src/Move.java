public class Move extends ObjectPlus{
    private String name;
    private Type type;

    public Move(String name, Type type) {
        try {
            setName(name);
            setType(type);
        } catch (Exception e) {
            e.printStackTrace();
            removeFromExtent();
        }
    }

    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", Type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Move name cannot be blank");
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        if (type == null) throw new IllegalArgumentException("Move type cannot be null");
        this.type = type;
    }
}
