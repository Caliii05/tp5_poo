package ar.edu.unju.escmi.tp5.collections;

import ar.edu.unju.escmi.tp5.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    public static boolean guardarCliente(Cliente c) {
        
        if (buscarCliente(c.getDni()) != null) return false;
        clientes.add(c);
        return true;
    }

    public static Cliente buscarCliente(int dni) {
        for (Cliente c : clientes) {
            if (c.getDni() == dni) return c;
        }
        return null;
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
