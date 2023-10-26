package Cuentaconherencia;

class cuentah {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public cuentah(float saldoInicial, float tasaAnual) {
        saldo = saldoInicial;
        numConsignaciones = 0;
        numRetiros = 0;
        this.tasaAnual = tasaAnual;
        comisionMensual = 0;
    }

    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (tasaAnual / 12) * saldo;
        saldo += interesMensual;
    }

    public void extractoMensual() {
        calcularInteresMensual();
        saldo -= comisionMensual;
    }

    public void imprimir() {
        System.out.println("Saldo: $" + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("Número de retiros: " + numRetiros);
    }
}

class CuentaDeAhorros extends cuentah {
    private boolean activa;

    public CuentaDeAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        activa = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        } else {
            System.out.println("Cuenta de ahorros inactiva. No se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        } else {
            System.out.println("Cuenta de ahorros inactiva. No se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual = 1000 * (numRetiros - 4);
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Cuenta de ahorros activa: " + activa);
    }
}

class CuentaCorriente extends cuentah {
    private float sobregiro;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo + sobregiro) {
            if (cantidad > saldo) {
                sobregiro += saldo - cantidad;
                saldo = 0;
            } else {
                saldo -= cantidad;
            }
            numRetiros++;
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);
        if (sobregiro != 0) {
            if (cantidad >= sobregiro) {
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
            }
        }
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Sobregiro: $" + sobregiro);
    }
}
