package TestEntidades;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import prjVentasAutosJPA.TblCategoria;
import prjVentasAutosJPA.TblProducto;

public class testProducto {
	public static void main(String[] args) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		EntityManager emanager = conex.createEntityManager();
		emanager.getTransaction().begin();
		
		TblProducto producto = new TblProducto();
		TblCategoria categoria = new TblCategoria();
		
		
		//registrar
		/*
		categoria.setNombre("marca");
		categoria.setDescrip("producto de alto precio");
		//
		producto.setNombre("codipront");
		producto.setPrecio(15);
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		producto.setFechaven(fechasql);
		producto.setCodbarras("777756");
		producto.setNrolote("L6867");
		producto.setTblCategoria(categoria);
		//
		emanager.persist(producto);
		//
		System.out.println("datos registrados correctamente");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
		*/
		
		
		//actualizar
		categoria.setIdcategoria(1);
		categoria.setNombre("generico");
		categoria.setDescrip("recomendado por el ministerio de salud");
		//
		producto.setIdproducto(1);
		producto.setNombre("paracetamol");
		producto.setPrecio(6);
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		producto.setFechaven(fechasql);
		producto.setCodbarras("7777777");
		producto.setNrolote("L333333");
		producto.setTblCategoria(categoria);
		//datos actualizados
		emanager.merge(producto);
		//
		System.out.println("Datos actualizados");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
	}
}
