package menu;

import animals.FarmAnimals;
import farm.Farm;

public class AllActions {

    // Métodos que representan acciones del menú
    public static Object[] addAnimal(Object[] params) {
        System.out.println("Adding animal...");
        if ((params[0] instanceof Farm)&&(params[1] instanceof FarmAnimals)){
            ((Farm) params[0]).addAnimal((FarmAnimals) params[1]);
        }
        // lógica aquí
        return null;
    }

    public static Object[] editarAnimal(Object[] params) {
        System.out.println("Editando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] eliminarAnimal(Object[] params) {
        System.out.println("Eliminando animal...");
        // lógica aquí
        return null;
    }

    public static Object[] exit(Object[] params) {
        System.out.println("Saliendo del programa...");
        return null;
    }

    public static Object[] displayAnimals(Object[] params) {
        ((Farm)params[0]).displayAnimals();
        return null;
    }


}
