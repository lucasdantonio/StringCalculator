package me.lucas.mathCalculator;

public class Cerebro {

	public static double calc(String equacao) {
		double result = 0;

		int opIndex = equacao.indexOf("+");
		int opIndex2 = equacao.indexOf("-");
		int opIndex3 = equacao.indexOf("*");
		int opIndex4 = equacao.indexOf("/");

		if (opIndex == -1 && opIndex2 == -1 && opIndex3 == -1 && opIndex4 == -1) {
			result = Double.parseDouble(equacao);
		} else {
			if (opIndex3 != -1) {
				result = calc(equacao.substring(0, opIndex3)) * calc(equacao.substring(opIndex3 + 1, equacao.length()));
			}
			if (opIndex4 != -1) {
				result = calc(equacao.substring(0, opIndex4)) / calc(equacao.substring(opIndex4 + 1, equacao.length()));
			}
			if (opIndex != -1) {
				result = calc(equacao.substring(0, opIndex)) + calc(equacao.substring(opIndex + 1, equacao.length()));
			}
			if (opIndex2 != -1) {
				result = calc(equacao.substring(0, opIndex2)) - calc(equacao.substring(opIndex2 + 1, equacao.length()));
			}
		}

		return result;
	}
}
