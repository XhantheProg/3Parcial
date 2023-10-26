package Cuentaconherencia;

public class main {
    public static void main(String[] args) {
        CuentaDeAhorros cuentaAhorros = new CuentaDeAhorros(12000, 0.05f);
        CuentaCorriente cuentaCorriente = new CuentaCorriente(500, 0.1f);

        cuentaAhorros.consignar(2000);
        cuentaAhorros.retirar(300);
        cuentaAhorros.retirar(1000);
        cuentaAhorros.extractoMensual();
        cuentaAhorros.imprimir();

        cuentaCorriente.consignar(300);
        cuentaCorriente.retirar(800);
        cuentaCorriente.retirar(500);
        cuentaCorriente.extractoMensual();
        cuentaCorriente.imprimir();
    }
}