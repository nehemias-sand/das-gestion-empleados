package service;

import empleados.Empleado;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private List<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public double calcularSalarioTotal() {
        double salarioTotal = 0;
        for (Empleado empleado : empleados) {
            salarioTotal += empleado.calcularSalario();
        }
        return salarioTotal;
    }

    public void mostrarEmpleados() {
        System.out.println("Lista de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
