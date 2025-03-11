import java.io.*;
import java.util.*;

public class ObjectPlus implements Serializable { //Ekstensja - trwałość

    private static Map<Class, List> extent = new HashMap<>();
    public static final String EXTENT_FILE_NAME = "pokemons.pkd";

    public ObjectPlus() {
        addToExtent();
    }

    public static void saveExtent() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EXTENT_FILE_NAME))) {
          oos.writeObject(extent);
        } finally {
            System.out.println("Objects saved to file");
        }
    }

    public static void loadExtent() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(EXTENT_FILE_NAME))) {
            extent = (Map<Class, List>) ois.readObject();
        } finally {
            System.out.println("Objects loaded from file");
        }
    }

    public static <T> List<T> getExtentFromClass(Class<T> type) {
        extent.computeIfAbsent(type, k -> new ArrayList<>());
        return Collections.unmodifiableList(extent.get(type));
    }

    protected void addToExtent() {
        List list = extent.computeIfAbsent(this.getClass(), k -> new ArrayList<>());
        list.add(this);
    }

    public void removeFromExtent() {
        List list = extent.get(this.getClass());
        if (list != null) {
            list.remove(this);
        }
    }
}
