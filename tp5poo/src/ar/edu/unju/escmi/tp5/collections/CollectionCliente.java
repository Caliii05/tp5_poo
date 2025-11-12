package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.Cliente;

public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    public static boolean guardarCliente(Cliente c) {
        return clientes.add(c);
    }

    public static Cliente buscarClientePorDni(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) return c;
        }
        return null;
    }
}