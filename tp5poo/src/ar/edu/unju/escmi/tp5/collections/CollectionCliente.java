package ar.edu.unju.escmi.tp5.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp5.dominio.*;

public class CollectionCliente {
    public static List<Cliente> clientes = new ArrayList<>();

    public static void precargar() {
        clientes.add(new ClienteMayorista("Pérez", "Carlos", "Av. Belgrano 123", "M001"));
        clientes.add(new ClienteMinorista("Gómez", "Lucía", "San Martín 555", "40123456", true));
    }
}