import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new Pokemon(1, "Buzzwole", 190.0f, 150.0f, "Unknown","Swollen", Type.BUG, Type.FIGHTING, new Stats(10, 10, 10, 10, 10, 11), 15);
        new Pokemon(2, "", 190.0f, 150.0f, "Unknown","Swollen", Type.BUG, Type.FIGHTING, new Stats(10, 10, 10, 10, 10, 11), 15);

        new Pokemon(12312, "Buzzwole31231", 190.0f, 150.0f, "Unknown","Swollen", Type.BUG, Type.FIGHTING, new Stats(10, 10, 10, 10, 10, 11), 15);

        System.out.println(ObjectPlus.getExtentFromClass(Pokemon.class));

        try {
            ObjectPlus.loadExtent();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        try {
//            ObjectPlus.saveExtent();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(ObjectPlus.getExtentFromClass(Pokemon.class));

        Pokemon buzz = Pokemon.findPokemon(1);
        buzz.addMove(new Move("Harden", Type.NORMAL));
        System.out.println(buzz);
        buzz.removeMove("Harden");
        System.out.println(buzz);
        System.out.println(buzz.distanceToMaxLevel());
    }
}