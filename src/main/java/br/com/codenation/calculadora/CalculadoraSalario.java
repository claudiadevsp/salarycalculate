package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private final double inssPorcentagemMinima = 0.08;
	private final double inssPorcentagemMedia  = 0.09;
	private final double inssPorcentagemMaxima = 0.11;
	private final double irffPorcentagemMinima = 0.075;
	private final double irffPorcentagemMaxima = 0.15;

	public long calcularSalarioLiquido(double salarioBase) {

		return Math.round(this.calcularIrrf(this.calcularInss(salarioBase)));

	}

	private double calcularInss(double salarioBase) {

		if (salarioBase <= 1031.99)
			return 0.00;
		else if (salarioBase >= 1032.00 && salarioBase <= 1500.00)
			return this.valorCalculado(salarioBase, this.inssPorcentagemMinima);
		else if (salarioBase >= 1500.01 && salarioBase <= 4000.00)
			return this.valorCalculado(salarioBase, this.inssPorcentagemMedia);
		else
			return this.valorCalculado(salarioBase, this.inssPorcentagemMaxima);
	}

	private double calcularIrrf(double salarioBase) {

		if (salarioBase <= 3000.00)
			return salarioBase;
		else if (salarioBase >= 3000.01 && salarioBase <= 6000.00)
			return this.valorCalculado(salarioBase, this.irffPorcentagemMinima);
		else
			return this.valorCalculado(salarioBase, this.irffPorcentagemMaxima);
	}

	private double valorCalculado(double salarioBase, double porcentagem) {
		return salarioBase - (salarioBase * (porcentagem / 100) * 100);
	}
}
