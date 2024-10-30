package com.example.hamburguesas.model;

//Es mi TDA
public class VentaModel {
	// Datos (Entrada)

	private String tipoHamburguesa;
	private byte cantidad;
	private String tipoPago;

	public String getTipoHamburguesa() {
		return tipoHamburguesa;
	}

	public void setTipoHamburguesa(String tipoHamburguesa) {
		this.tipoHamburguesa = tipoHamburguesa;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public void setCantidad(byte cantidad) {
		this.cantidad = cantidad;
	}

	// Operaciones (Metodos)
	public String calcularVentas() {
		double totalPagar = 0;

		// If validacion tipo de hamburguesa
		switch (tipoHamburguesa) {
		case "Sencilla":
			totalPagar = cantidad * 30;
			break;
		case ("Doble"):
			totalPagar = cantidad * 38;
			break;
		case ("Triple"):
			totalPagar = cantidad * 58;
			break;
		}
		if (tipoPago.equals("Tarjeta")) {
			totalPagar = totalPagar * 1.05;
		}

		return "Total a pagar: $" + totalPagar + "\nGracias por su compra";
	}
}
