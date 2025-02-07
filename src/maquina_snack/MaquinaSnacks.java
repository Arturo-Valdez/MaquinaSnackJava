package maquina_snack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MaquinaSnacks {
    public static void main(String[] args) {
        maquinaSnacks();//Inicializacion de proyecto maquinaSnacks
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
                salir = ejecutarOpciones(opcion,consola,productos);


            }catch ( Exception e){
                System.out.println("Ocurrio un errr: " + e.getMessage());
            }finally {
                System.out.println();//Imprime un salto de linea de cada interacion
            }
        }
    }

    private static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> productos) {
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(consola,productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(consola);
            case 4 -> {
                System.out.println("Regresa pronto!!!...");
                salir = true;
            }
        }
        return salir;
    }

    private static void agregarSnack(Scanner consola){
        System.out.print("Ingrese nombre del nuevo snack: ");
        var nombre = consola.nextLine();
        System.out.print("Ingrese el precio del snack: ");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Tu snack se ha agregado correctamente");
        Snacks.mostrarSacks();
    }

    private static void mostrarTicket(List<Snack> productos) {
        var ticket = "*** Ticket de Venta ***";
        var total = 0.0;
        for (var producto : productos){
            ticket += "\n\t+" + producto.getNombre() + " - $" + producto.getPrecio();
            total += producto.getPrecio();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }

    private static void comprarSnack(Scanner consola, List<Snack> productos) {
        System.out.print("¿Que snack quieres comprar (id)?: ");
        var idSnack = Integer.parseInt(consola.nextLine());
        //Validar que el snac exista en la lisa de snacks
        var snackEncontrado = false;
        for( var snack : Snacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                //Agregamos el snack a la lista de productos
                productos.add(snack);
                System.out.println("OK, Snack agregado: " + snack);
                snackEncontrado = true;
                break;
            }
        }
        if(!snackEncontrado){
            System.out.println("Id de snack no encontrado: " + idSnack);
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
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
