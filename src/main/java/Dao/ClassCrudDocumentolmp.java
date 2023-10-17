package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IDocumentoable;
import prjVentasAutosJPA.TblDocumento;

public class ClassCrudDocumentolmp implements IDocumentoable{

	@Override
	public void registrarDocumento(TblDocumento docu) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		//
		emanager.persist(docu);
		//
		System.out.println("datos registrados correctamente");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
	}

	@Override
	public void actualizarDocumento(TblDocumento docu) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		//
		emanager.merge(docu);
		//
		System.out.println("datos actualizados correctamente");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
	}

	@Override
	public void eliminarDocumento(TblDocumento docu) {
	}

	@Override
	public List<TblDocumento> milista() {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		//
		List<TblDocumento> milista = emanager.createQuery("select a from TblDocumento a",TblDocumento.class).getResultList();
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
		return milista;
	}

	@Override
	public TblDocumento buscarDocumento(TblDocumento duco) {
		// TODO Auto-generated method stub
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		//
		TblDocumento bus = emanager.find(TblDocumento.class,1);
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
		return bus;
	}

}
