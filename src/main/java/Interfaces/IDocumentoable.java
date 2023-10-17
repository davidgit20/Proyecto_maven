package Interfaces;

import java.util.List;

import prjVentasAutosJPA.TblDocumento;

public interface IDocumentoable {
	public void registrarDocumento(TblDocumento docu);
	public void actualizarDocumento(TblDocumento docu);
	public void eliminarDocumento(TblDocumento docu);
	List<TblDocumento> milista();
	public TblDocumento buscarDocumento(TblDocumento duco);
}
