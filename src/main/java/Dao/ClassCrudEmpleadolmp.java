package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IEmpleadoable;
import prjVentasAutosJPA.TblEmpleado;

public class ClassCrudEmpleadolmp implements IEmpleadoable{

	@Override
	public void registrarempleado(TblEmpleado tblem) {
		// TODO Auto-generated method stub
		//establecemos conexion con la unidad de persistencia
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// manejador de entidades segun unidad de persistencia
		EntityManager emaneger = conex.createEntityManager();
		//REALIZAMOS EL PROCESO
		//iniciar transaccion
		emaneger.getTransaction().begin();
		//registramos datos
		emaneger.persist(tblem);
		//mensaje
		System.out.println("Datos registrados correctamente");
		// confirmamos 
		emaneger.getTransaction().commit();
		//cerramos
		emaneger.close();
	}

	@Override
	public void actualizarempleado(TblEmpleado tblem) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// manejador de entidades segun unidad de persistencia
		EntityManager emaneger = conex.createEntityManager();
		//REALIZAMOS EL PROCESO
		//iniciar transaccion
		emaneger.getTransaction().begin();
		//
		emaneger.merge(tblem);
		//
		System.out.println("Datos actualizados");
		//
		emaneger.getTransaction().commit();
		//
		emaneger.close();
	}

	@Override
	public void eliminarempleado(TblEmpleado tblem) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// manejador de entidades segun unidad de persistencia
		EntityManager emaneger = conex.createEntityManager();
		//REALIZAMOS EL PROCESO
		//iniciar transaccion
		emaneger.getTransaction().begin();
		//
		TblEmpleado eli = emaneger.merge(tblem);
		//
		emaneger.remove(eli);
		//
		System.out.println("Registro eliminado");
		//
		emaneger.getTransaction().commit();
		//
		emaneger.close();
		
		
	}

	@Override
	public List<TblEmpleado> listar() {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// manejador de entidades segun unidad de persistencia
		EntityManager emaneger = conex.createEntityManager();
		//REALIZAMOS EL PROCESO
		//iniciar transaccion
		emaneger.getTransaction().begin();
		//aplicmaos jpql se basa en entidades
		List<TblEmpleado> milista = emaneger.createQuery("select a from TblEmpleado a",TblEmpleado.class).getResultList();
		//
		emaneger.getTransaction().commit();
		//
		emaneger.close();
		
		
		return milista;
	}

	@Override
	public TblEmpleado buscarempleado(TblEmpleado tblem) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// manejador de entidades segun unidad de persistencia
		EntityManager emaneger = conex.createEntityManager();
		//REALIZAMOS EL PROCESO
		//iniciar transaccion
		emaneger.getTransaction().begin();
		//enviamos el codigo a buscar en base de datos
		TblEmpleado bus = emaneger.find(TblEmpleado.class, 1);
		//
		emaneger.getTransaction().commit();
		//
		emaneger.close();
		return bus;
	}

}
