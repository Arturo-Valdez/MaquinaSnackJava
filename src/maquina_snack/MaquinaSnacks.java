package maquina_snack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    private static void maquinaSnacks() {
        var salir = false;
        Scanner consola = new Scanner(System.in);

        //Creamos la lista de productos tipo Snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        Snacks.mostrarSacks();//Mostrar inventario disponibles

        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                //salir = ejecutarOpciones(opcion,consola,productos);


            }catch ( Exception e){
                System.out.println("Ocurrio un errr: " + e.getMessage());
            }finally {
                System.out.println();//Imprime un salto de linea de cada interacion
            }
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.println("""
                Menu:
                1. Comprar Snack
                2. Mostrar ticket
                3. Agregar Nuevo Snack
                4. Salir
                Elige una opcion: \s""");
        //Leemos y retornamos la opcion seleccionada
        return Integer.parseInt(consola.nextLine());
    }
}
