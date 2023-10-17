package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import Dao.ClassCrudEmpleadolmp;
import prjVentasAutosJPA.TblEmpleado;

public class testEmpleado {
	public static void main(String[] args) {
		//instanciamos las clases
		TblEmpleado tblem = new TblEmpleado();
		ClassCrudEmpleadolmp crud = new ClassCrudEmpleadolmp();
		
		//registrar
		/*
		//ingresamos valores
		tblem.setNombre("carlos");
		tblem.setApellido("mamani ticona");
		tblem.setSexo("femenino");
		tblem.setEmail("carlos.email.com");
		tblem.setDni("34561234");
		tblem.setTelefono("956734523");
		//convertimos la fecha a javasql javautil
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		tblem.setFechanac(fechasql);
		//invocamos al meotodo registrar
		crud.registrarempleado(tblem);
		*/
		
		/*
		//metodo actualizar
		tblem.setIdempleado(2);
		tblem.setNombre("Nilson alexander");
		tblem.setApellido("campos valverde");
		tblem.setSexo("masculino");
		tblem.setEmail("nilson@gmail.com");
		tblem.setDni("34562345");
		tblem.setTelefono("92316745");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		tblem.setFechanac(fechasql);
		//invoacmos al metodo actulizar
		crud.actualizarempleado(tblem);
		*/
		
		/*
		//metodo eliminar
		tblem.setIdempleado(5);
		//invoacmos el metodo eliminar
		crud.eliminarempleado(tblem);
		*/
		
		/*
		//metodo listar
		List<TblEmpleado> listado = crud.listar();
		for(TblEmpleado lista:listado){
			System.out.println("codigo : "+lista.getIdempleado()+"Nombres : "+lista.getNombre()+
					"apellidos : "+lista.getApellido()+"sexo : "+lista.getSexo()+"email : "+lista.getEmail()+
					"dni : "+lista.getDni()+"telefono: "+lista.getTelefono()+"fecha naci"+lista.getFechanac());
		}
		*/
		
		/*
		//metodo buscar
		tblem.setIdempleado(1);
		TblEmpleado bus = crud.buscarempleado(tblem);
		//imprimimos por pantalla
		System.out.println("codigo : "+bus.getIdempleado()+"Nombres : "+bus.getNombre()+
			"apellidos : "+bus.getApellido()+"sexo : "+bus.getSexo()+"email : "+bus.getEmail()+
			"dni : "+bus.getDni()+"telefono: "+bus.getTelefono()+"fecha naci"+bus.getFechanac());
		*/
		
		
	}
}
