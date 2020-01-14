package br.com.codenation.calculadora;

public class PrincipalClass {

    public static void main(String[] args){
        CalculadoraSalario calc  = new CalculadoraSalario();
        System.out.println(calc.calcularSalarioLiquido(1500));
    }
}
