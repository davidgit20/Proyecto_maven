package TestEntidades;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLInput;

import prjVentasAutosJPA.TblAuto;
import prjVentasAutosJPA.TblCliente;
import sun.font.CreatedFontTracker;

public class testCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//establecemos la conexion con la unidad de persistencia
				// ponmeos el nombre de persisitence
				
		
				EntityManagerFactory conex = Persistence.createEntityManagerFactory("BDAutosJPA");
				// gestionar entidades como registrar actualizar eliminar listar y buscar
				EntityManager emanager = conex.createEntityManager();
				//iniciamos transacncion // iniciar las operaciones
				emanager.getTransaction().begin();
				// realizamos la instancia
				TblCliente cliente = new TblCliente();
				
				//creamos una variable de tipo accion
				String accion = JOptionPane.showInputDialog("Ingresar la accion");
				switch (accion) {
				case "Registrar":
					cliente.setNombre("lucas");
					cliente.setApellido("campos");
					cliente.setEmail("lucas.email");
					cliente.setDni("12367456");
					cliente.setSexo("M");
					
					// lo agregamos
					emanager.persist(cliente);
					//emitimos un msnejas por consola
					System.out.println("Registrado correctamente");
					//confirmaos 
					emanager.getTransaction().commit();
					//cerramos
					emanager.close();
					break;
				case "Actualizar" :
					cliente.setNombre("davey");
					cliente.setApellido("huertas");
					cliente.setEmail("davey.email");
					cliente.setDni("74867456");
					cliente.setSexo("M");
					
					if(emanager.merge(cliente) != null)
					{
						System.out.println("datos actualizado");
					}
					else
					{
						System.out.println("no se pudo actualizar");
					}
					
					emanager.getTransaction().commit();
					emanager.close();
					
					break;
				case "Eliminar2" :
					TblCliente eli = emanager.find(TblCliente.class, 1);
					if(eli == null)
					{
						System.out.println("Código no existe");
					}
					else
					{
						System.out.println("registro eliminado");
						emanager.remove(eli);
					}
					//
					emanager.getTransaction().commit();
					//
					emanager.close();
					break;
				case "Buscar" :
					TblCliente bus = emanager.find(TblCliente.class, 1);
					if(bus == null)
					{
						System.out.println("Codigo no existe");
					}
					else
					{
						System.out.println("Registro encontrado");
						System.out.println("codigo :"+bus.getIdcliente()+"nombre :"+bus.getNombre()+"apellido :"+bus.getApellido()+
								"email :"+bus.getEmail()+"dni :"+bus.getDni()+"sexo :"+bus.getSexo());
					}
					//
					emanager.getTransaction().commit();
					//
					emanager.close();
					break;
				case "Listar" :
					List<TblCliente> milista = emanager.createQuery("select a from TblCliente a", TblCliente.class).getResultList();
					for(TblCliente list : milista)
					{
						System.out.println("Registro encontrado");
						System.out.println("codigo :"+list.getIdcliente()+"nombre :"+list.getNombre()+"apellido :"+list.getApellido()+
								"email :"+list.getEmail()+"dni :"+list.getDni()+"sexo :"+list.getSexo());
					}
					//
					emanager.getTransaction().commit();
					//
					emanager.close();
					break;
				case "Eliminar1" :
					cliente.setIdcliente(1);
					//
					TblCliente eli2 = emanager.merge(cliente);
					//
					emanager.remove(eli2);
					//
					System.out.println("Registro eliminado");
					//
					emanager.getTransaction().commit();
					//
					emanager.close();
					break;
				default:
					System.out.println("accion no encontrada");
					break;
				}
	
				
				
	} // fin del metodo

}//fin de la clase
