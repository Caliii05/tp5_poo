package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Cliente;
import java.util.ArrayList;
import java.util.List;

public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    public static void guardarCliente(Cliente c) {
        clientes.add(c);
    }

    public static Cliente buscarPorDni(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) return c;
        }
        return null;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}