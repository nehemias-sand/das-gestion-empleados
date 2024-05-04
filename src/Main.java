import empleados.Empleado;
import empleados.EmpleadoContrato;
import empleados.EmpleadoServicio;
import empleados.EmpleadoTiempoCompleto;
import service.GestorEmpleados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Mostrar lista de empleados");
            System.out.println("4. Calcular salario total");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> agregarEmpleado(gestor, scanner);
                case 2 -> eliminarEmpleado(gestor, scanner);
                case 3 -> gestor.mostrarEmpleados();
                case 4 -> System.out.println("Salario total de los empleados: " + gestor.calcularSalarioTotal());
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarEmpleado(GestorEmpleados gestor, Scanner scanner) {
        System.out.println("\nAgregar empleado:");
        System.out.println("1. Empleado a tiempo completo");
        System.out.println("2. Empleado por contrato");
        System.out.println("3. Empleado por servicio");
        System.out.print("Seleccione el tipo de empleado: ");
        int tipoEmpleado = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        switch (tipoEmpleado) {
            case 1 -> {
                System.out.print("Ingrese el salario mensual del empleado a tiempo completo: ");
                double salarioMensual = scanner.nextDouble();
                gestor.agregarEmpleado(new EmpleadoTiempoCompleto(nombre, salarioMensual));
            }
            case 2 -> {
                System.out.print("Ingrese el salario diario del empleado por contrato: ");
                double salarioDiario = scanner.nextDouble();
                System.out.print("Ingrese los días trabajados del empleado por contrato: ");
                int diasTrabajados = scanner.nextInt();
                gestor.agregarEmpleado(new EmpleadoContrato(nombre, salarioDiario, diasTrabajados));
            }
            case 3 -> {
                System.out.print("Ingrese la tarifa por hora del empleado por servicio: ");
                double tarifaHora = scanner.nextDouble();
                System.out.print("Ingrese las horas trabajadas del empleado por servicio: ");
                int horasTrabajadas = scanner.nextInt();
                gestor.agregarEmpleado(new EmpleadoServicio(nombre, tarifaHora, horasTrabajadas));
            }
            default -> System.out.println("Tipo de empleado no válido.");
        }
    }

    private static void eliminarEmpleado(GestorEmpleados gestor, Scanner scanner) {
        System.out.println("\nEliminar empleado:");
        gestor.mostrarEmpleados();
        if (!gestor.getEmpleados().isEmpty()) {
            scanner.nextLine();
            System.out.print("Ingrese el nombre del empleado que desea eliminar: ");
            String nombreEmpleado = scanner.nextLine();
            Empleado empleadoAEliminar = null;
            for (Empleado empleado : gestor.getEmpleados()) {
                if (empleado.getNombre().equals(nombreEmpleado)) {
                    empleadoAEliminar = empleado;
                    break;
                }
            }
            if (empleadoAEliminar != null) {
                gestor.eliminarEmpleado(empleadoAEliminar);
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Empleado no encontrado.");
            }
        } else {
            System.out.println("No hay empleados para eliminar.");
        }
    }
}
