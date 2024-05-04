package empleados;

public class EmpleadoContrato extends Empleado {

    private double salarioDiario;
    private int diasTrabajados;

    public EmpleadoContrato(String nombre, double salarioDiario, int diasTrabajados) {
        super(nombre);
        this.salarioDiario = salarioDiario;
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public double calcularSalario() {
        return salarioDiario * diasTrabajados;
    }
}
