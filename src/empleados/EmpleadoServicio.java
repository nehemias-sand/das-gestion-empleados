package empleados;

public class EmpleadoServicio extends Empleado {

    private double tarifaHora;
    private int horasTrabajadas;

    public EmpleadoServicio(String nombre, double tarifaHora, int horasTrabajadas) {
        super(nombre);
        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return tarifaHora * horasTrabajadas;
    }
}
