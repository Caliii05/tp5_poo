package ar.edu.unju.escmi.tp5.principal;

import java.util.Scanner;
import ar.edu.unju.escmi.tp5.collections.*;
import ar.edu.unju.escmi.tp5.dominio.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CollectionProducto.precargar();
        CollectionStock.precargar();
        CollectionCliente.precargar();

        System.out.println("=== Sistema de Ventas TP5 ===");
        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1. Encargado de Ventas");
        System.out.println("2. Agente Administrativo");
        System.out.println("3. Cliente");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                new EncargadoVentas("Juan").mostrarOpciones();
                break;
            case 2:
                new AgenteAdministrativo("María").mostrarOpciones();
                break;
            case 3:
                System.out.print("Ingrese número de factura: ");
                int nro = sc.nextInt();
                Factura f = CollectionFactura.buscarPorNumero(nro);
                if (f != null)
                    System.out.println(f);
                else
                    System.out.println("Factura no encontrada.");
                break;
        }
        sc.close();
    }
}