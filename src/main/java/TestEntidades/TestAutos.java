package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.sun.media.sound.EmergencySoundbank;

import prjVentasAutosJPA.TblAuto;

public class TestAutos {

	public static void main(String[] args) {
		//establecemos la conexion con la unidad de persistencia
		// ponmeos el nombre de persisitence
		EntityManagerFactory conex = Persistence.createEntityManagerFactory("Proyecto_maven");
		
		// gestionar entidades como registrar actualizar eliminar listar y buscar
		EntityManager emanager = conex.createEntityManager();
		
		//iniciamos transacncion // iniciar las operaciones
		emanager.getTransaction().begin();
		//realizamos una instancia de la entidad tbl_auto
		TblAuto auto = new TblAuto();
		
		//aplicamos un shwircj
		String accion=JOptionPane.showInputDialog("ingrese la accion");
		switch (accion) {
		case "Registrar":
			//ingresamos valores a enviar a la base de datos
			auto.setColor("rojomaven");
			auto.setModelo("civic_maven");
			auto.setMotor("1.2");
			auto.setPrecio(24000);
			auto.setMarca("honda");
			auto.setFabricacion("2022");
			
			//registramos los datos con persist
			// persisit sirve para agregar   (insert into tbl_auto value ) 
			emanager.persist(auto);
			// emitimos un mensaje por consola
			System.out.println("Datos registrados en la base de datos");
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos 
			emanager.close();
			break;
		case "Actualizar" :
			auto.setIdauto(4);
			auto.setColor("azul claros maven");
			auto.setModelo("F1");
			auto.setMotor("1.8");
			auto.setPrecio(300000);
			auto.setMarca("BMW");
			auto.setFabricacion("2023");
			
			// realizamos la actualizacion
			// update tbl_auto (upadte ) merge sirve : para actualizar
			if(emanager.merge(auto) != null)
			{
				//emitimos un mensaje
				System.out.println("datos actualizados correctamente");
			}
			else
			{
				//emitimos un mensaje
				System.out.println("No se pudo actualizar");
			}
				
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			break;
		// primera forma de eliminar
		case "Eliminar":
			//codigo a eliminar 5
			auto.setIdauto(4);
			// preimera forma
			TblAuto elim = emanager.merge(auto);
			//realizar la eliminacion
			// en jdbc delete from tbl wherew 
			emanager.remove(elim);
			//imprimos el mensaje
			System.out.println("Eliminado correctamente");
			// confirmamos 
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			break;
		// segunda forma de eliminar	
		case "Eliminar2" :
			//eliminamos el codigo 3
			TblAuto elim2 = emanager.find(TblAuto.class, 3);
			// aplicamos una condicion
			if(elim2 == null)
			{
				//emitimos un mensaje
				System.out.println("El codigo no existe");
			}
			else
			{
				//eliminamos el registro
				emanager.remove(elim2);
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos 
				emanager.close();
				// emitimos un mensaje por consola
				System.out.println("Eliminado correctamente");
			}
			break;
		
		case "Buscar" :
			TblAuto busc=emanager.find(TblAuto.class,3);
			
			//aplicamos una condicion null nno ha encoitrado nda
			if(busc == null)
			{
				//emitimos un mensaje por pantalla
				System.out.println("registro no encontrado");
			}
			else
			{
				System.out.println("Datos encontrados");
				//imprimos su respectiva caracteristicas del auto encontrado
				System.out.println("codigo :"+busc.getIdauto()+"color :"+busc.getColor()+
						"modelo :"+busc.getModelo()+"motor :"+busc.getMotor()+"precio :"+busc.getPrecio()+
						"marca :"+busc.getMarca()+"año :"+busc.getFabricacion());
			}
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			break;
		
		case "Listar" :
			List<TblAuto> listado = emanager.createQuery("select a from TblAuto a",TblAuto.class).getResultList();
			//mostramos los datos por consola
			for(TblAuto list:listado)
			{
				//imprimimos
				System.out.println("  codigo :"+list.getIdauto()+"  color :"+list.getColor()+
						"  modelo :"+list.getModelo()+"  motor :"+list.getMotor()+"  precio :"+list.getPrecio()+
						"  marca :"+list.getMarca()+"  año :"+list.getFabricacion());
			}
			//confirmamos
			emanager.getTransaction().commit();
			//cerramos
			emanager.close();
			break;
			default :
			//emitimos un mensaje por pantalla
			System.out.println("accion no encontrada");
			break;
		} // fin del switch
		
		
	} // fin del metodo principal

} // fin de la clase
