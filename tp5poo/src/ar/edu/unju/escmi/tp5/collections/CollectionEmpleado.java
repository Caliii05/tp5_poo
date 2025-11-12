package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Empleado;

public class CollectionEmpleado {
    public static List<Empleado> empleados = new ArrayList<>();

    public static void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado e : empleados) {
            if (e.getIdEmpleado() == id) {
                return e;
            }
        }
        return null;
    }
}