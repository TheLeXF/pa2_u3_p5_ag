package com.uce.edu.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. supplier
		System.out.println("-------------SUPPLIER-------------");
		// Clases
		System.out.println("CLASES");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		System.out.println(supplierClase.getID());
		// Lambdas
		System.out.println("LAMBDAS");
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
		System.out.println("METODOS REFERENCIADOS");
		MetodosReferenciados met = new MetodosReferenciados();
		IPersonaSupplier<String> supplierLambda4 = met::obtenerId;
		System.out.println(supplierLambda4.getID());
		// 2. Consumer
		System.out.println("------------CONSUMER--------------");
		// CLASES
		System.out.println("CLASES");

		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");

		System.out.println("LAMBDAS");

		IPersonaConsumer<String> consumerLambda = cadena -> {
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		// Metodos Referenciados
		System.out.println("METODOS REFERENCIADOS");

		IPersonaConsumer<String> consumer2 = met::procesar;
		consumer2.accept("Alexis Guanoluisa");
		// 3. Predicate
		System.out.println("------------PREDICATE--------------");
		System.out.println("LAMBDAS");
		IPersonaPredicate<Integer> predicateLambda = numero -> numero.compareTo(7) == 0;

		System.out.println(predicateLambda.evaluar(Integer.valueOf(8)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Edison".contains(letra);

		System.out.println(predicateLambda2.evaluar("s"));
		// Metodos Referenciados
		System.out.println("METODOS REFERENCIADOS");

		IPersonaPredicate<String> predicate2 = met::evaluar;
		System.out.println(predicate2.evaluar("E"));

		IPersonaPredicate<Integer> predicate3 = met::evaluar;
		System.out.println(predicate3.evaluar(8));

		// 4. Function
		System.out.println("------------FUNCTION--------------");
		System.out.println("LAMBDAS");
		IPersonaFunction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};

		System.out.println(functionLambda.aplicar(Integer.valueOf(10)));

		IPersonaFunction<Empleado, Ciudadano> functionLambda2 = ciudadano -> {
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());

			if (ciudadano.getProvincia().compareTo("Pichincha") == 0) {
				empl.setPais("Ecuador");
			}
			return empl;

		};
		Ciudadano ciu = new Ciudadano();
		ciu.setApellido("Guanoluisa");
		ciu.setNombre("Alexis");
		ciu.setProvincia("Pichincha");
		Empleado empl = functionLambda2.aplicar(ciu);
		System.out.println(empl);

		// Metodos Referenciados
		System.out.println("METODOS REFERENCIADOS");
		Empleado empl2 = new Empleado();
		empl2.setNombreCompleto("Santiago Guanoluisa");
		empl2.setPais("Ecuador");
		IPersonaFunction<Ciudadano, Empleado > function2 = met::cambiar;
		Ciudadano ciud2=function2.aplicar(empl2);
		System.out.println(ciud2);
		
		//5. UNARY OPERATOR
		System.out.println("------------Unary Operator--------------");
		System.out.println("LAMBDAS");

		IPersonaUnaryOperator<Integer> unaryOperatorLambda = numero -> numero + (numero * 2);

		System.out.println(unaryOperatorLambda.aplicar(14));

		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero * 3);
		System.out.println(unaryOperatorLambda2.aplicar(10));
		
		System.out.println("METODOS REFERENCIADOS");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met::procesar;
		Empleado empl3=unary3.aplicar(empl2);
		System.out.println(empl3);
		
		System.out.println(" ");

		
		System.out.println("-----IMPLEMENTACION DE INTERFACES FUNCIONALES MEDIANTE LIBRERIAS JAVA-----");
		
		//1.Supplier
		System.out.println("Supplier JAVA");
		Stream <String> lista=Stream.generate(() -> "465544645" + " pais").limit(20);
		lista.forEach(cadena->System.out.println(cadena));
		
		
		//2.Consumer
		System.out.println("Consumer JAVA");
		List<Integer> lista2=Arrays.asList(1,2,3,4,5,16,4,14,5,8);
		lista2.forEach(numero -> {
			System.out.println("Se inserta");
			System.out.println(numero);
		});
		
//		for (Integer numero:lista2) {
//			System.out.println("Se inserta");
//			System.out.println(numero);
//		}
		//3.Predicate
		System.out.println("Predicate JAVA");
		Stream<Integer> listaFiltrada=lista2.stream().filter(numero->numero>=10);
		listaFiltrada.forEach(numero->System.out.println(numero));
		//4. Function
		System.out.println("Function JAVA");
		Stream <String> listaCambiada = lista2.stream().map(numero->{
			numero = numero *100/50;
			return "Num: "+numero.toString();
		});
		listaCambiada.forEach(cadena->System.out.println(cadena));
		
		System.out.println(" ");
		
		Ciudadano ciu2 = new Ciudadano();
		ciu2.setApellido("Guanoluisa");
		ciu2.setNombre("Santiago");
		ciu2.setProvincia("Pichincha");
		
		Ciudadano ciu3 = new Ciudadano();
		ciu3.setApellido("Guanoluisa");
		ciu3.setNombre("Alexis");
		ciu3.setProvincia("Pichincha");
		
		Ciudadano ciu4 = new Ciudadano();
		ciu4.setApellido("Jimenes");
		ciu4.setNombre("Jose");
		ciu4.setProvincia("Pichincha");
		
		List<Ciudadano>listaCiudadanos= Arrays.asList(ciu2,ciu3,ciu4);
		
		Stream<Empleado>listaEmpleado=listaCiudadanos.stream().map(ciudadano1->{Empleado empl01 = new Empleado();
		empl01.setNombreCompleto(ciudadano1.getNombre() + " " + ciudadano1.getApellido());

		if (ciudadano1.getProvincia().compareTo("Pichincha") == 0) {
			empl01.setPais("Ecuador");
		}
		return empl01;});
		
		listaEmpleado.forEach(empleado->System.out.println(empleado));
		
		//5. Unary Operator 
		
		System.out.println("Unary Operator JAVA");
		
		Stream<Integer>listaNumeros2=lista2.stream().map(numero->{
			numero = numero *100/50;
			return numero;
		});
		listaNumeros2.forEach(numero->System.out.println(numero));
	}

}
