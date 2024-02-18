package com.uce.edu.funcional;

public class MetodosReferenciados {
	
	public String obtenerId() {
		String cedula = "14151515";
		cedula=cedula+" referenciado";
		return cedula;
	}
	public void procesar (String cadena) {
		System.out.println(cadena);
		System.out.println("Se procesa la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Edison".contains(cadena);
	}
	
	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}
	
	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud=new Ciudadano();
		String nombre =empl.getNombreCompleto().split(" ")[0];
		String apellido =empl.getNombreCompleto().split(" ")[1];
		ciud.setApellido(apellido);
		ciud.setNombre(nombre);
		ciud.setProvincia("Chimborazo");
		return ciud;
	}
	
	public Empleado procesar (Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+" "+empl.getPais());
		empl.setPais(empl.getPais()+" de nacimiento");
		return empl;
	}
}
