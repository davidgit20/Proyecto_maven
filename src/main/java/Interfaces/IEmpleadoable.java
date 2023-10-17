package Interfaces;

import java.util.List;

import prjVentasAutosJPA.TblEmpleado;

public interface IEmpleadoable {
	public void registrarempleado(TblEmpleado tblem);
	public void actualizarempleado(TblEmpleado tblem);
	public void eliminarempleado(TblEmpleado tblem);
	public List<TblEmpleado> listar();
	public TblEmpleado buscarempleado(TblEmpleado tblem);
} // fin de la interfaz
