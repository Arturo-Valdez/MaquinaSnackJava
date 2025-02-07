package maquina_snack;
import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

//    bloque static inicializador
    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papas", 20));
        snacks.add(new Snack("Refresco", 25));
        snacks.add(new Snack("Torta", 80));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSacks(){
        var inventarioSnack = "";
        for(var snack : snacks){
            inventarioSnack += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el inventario ---");
        System.out.println(inventarioSnack);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }


}
