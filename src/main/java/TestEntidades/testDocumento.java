package TestEntidades;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import prjVentasAutosJPA.TblDocumento;
import prjVentasAutosJPA.TblTipodocumento;

public class testDocumento {
	public static void main(String[] args) {
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		
		TblTipodocumento tipo = new TblTipodocumento();
		TblDocumento documento = new TblDocumento();
		
		/*
		//rtegistrar
		//ingresamos los valores
		tipo.setNombre("factura");
		tipo.setDescrip("comprobante de pago");
		emanager.persist(tipo);
		documento.setNroDocumento("667543");
		documento.setProvedorDocumento("industria s.a.c");
		documento.setRucDocumento("7612363453");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		documento.setFecha(fechasql);
		documento.setDescripDocumento("recolectar IGV para la sunat");
		documento.setTblTipodocumento(tipo);
		emanager.persist(documento);
		System.out.println("Datos registrtados correctamente");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
		*/
		
		
		////////////////////////////////////////////////////////////////////////
		//-actualizar
		/*
		tipo.setIdTipoDocumento(1);
		tipo.setNombre("tickect");
		tipo.setDescrip("para llevar el control interno");
		emanager.merge(tipo);
		documento.setIddocumento(1);
		documento.setNroDocumento("777666");
		documento.setProvedorDocumento("poliCliniCo lima");
		documento.setRucDocumento("7667585845");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		documento.setFecha(fechasql);
		documento.setDescripDocumento("comprobante de pago");
		documento.setTblTipodocumento(tipo);
		emanager.merge(documento);
		//
		System.out.println("actualizados corectamente");
		//
		emanager.getTransaction().commit();
		//
		emanager.close();
		*/
		
		
		/*
		//listado
		List<TblDocumento> milista = emanager.createQuery("select a from TblDocumento a",TblDocumento.class).getResultList();
		for(TblDocumento a:milista)
		{
			System.out.println("codigo :"+a.getIddocumento()+"nro_documento :"+a.getNroDocumento()+"proveedor :"+a.getProvedorDocumento()+
					"ruc :"+a.getRucDocumento()+"fecha :"+a.getFecha()+"descripcion :"+a.getDescripDocumento()+"Tipo de doc. :"
					+a.getTblTipodocumento().getIdTipoDocumento()+"nombre de doc. :"+a.getTblTipodocumento().getNombre()+"descripcion docuemtno :"+a.getTblTipodocumento().getDescrip());
		}
		*/
		
		
		
		
		//buscar
		TblDocumento bus = emanager.find(TblDocumento.class, 2);
		//
		System.out.println("codigo :"+bus.getIddocumento()+"nro_documento :"+bus.getNroDocumento()+"proveedor :"+bus.getProvedorDocumento()+
				"ruc :"+bus.getRucDocumento()+"fecha :"+bus.getFecha()+"descripcion :"+bus.getDescripDocumento()+"Tipo de doc. :"
				+bus.getTblTipodocumento().getIdTipoDocumento()+"nombre de doc. :"+bus.getTblTipodocumento().getNombre()+"descripcion docuemtno :"+bus.getTblTipodocumento().getDescrip());
		
		
		
		
		
		
		
		
	}
}
