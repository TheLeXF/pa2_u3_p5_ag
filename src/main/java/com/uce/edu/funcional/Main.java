package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. supplier
		System.out.println("-------------SUPPLIER-------------");
		// Clases
		System.out.println("Clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getID());
		// Lambdas
		System.out.println("Lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "14151515";
			cedula = cedula + " canton";
			return cedula;
		};

		System.out.println(supplierLambda.getID());

		IPersonaSupplier<String> supplierLambda2 = () -> "465544645" + " pais";
		System.out.println(supplierLambda2.getID());

		IPersonaSupplier<Integer> supplierLambda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLambda3.getID());

		// Metodos referenciados

		// 2. Consumer
		System.out.println("------------CONSUMER--------------");
		// CLASES
		System.out.println("Clases");

		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		System.out.println("Lambdas");

		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		
		//3. Predicate
		System.out.println("------------PREDICATE--------------");
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;
		
		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));
		
		IPersonaPredicate<String> predicateLambda2 = letra -> "Edison".contains(letra);
		
		System.out.println(predicateLambda2.evaluar("s"));
	}

}
