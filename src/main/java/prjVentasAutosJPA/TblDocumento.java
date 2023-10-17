package prjVentasAutosJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_documento database table.
 * 
 */
@Entity
@Table(name="tbl_documento")
@NamedQuery(name="TblDocumento.findAll", query="SELECT t FROM TblDocumento t")
public class TblDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddocumento;

	private String descripDocumento;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nroDocumento;

	private String provedorDocumento;

	private String rucDocumento;

	//bi-directional many-to-one association to TblTipodocumento
	@ManyToOne(optional=false,cascade=CascadeType.ALL,fetch=FetchType.EAGER)   
	@JoinColumn(name="idtipoDocumento")
	private TblTipodocumento tblTipodocumento;

	public TblDocumento() {
	}

	public int getIddocumento() {
		return this.iddocumento;
	}

	public void setIddocumento(int iddocumento) {
		this.iddocumento = iddocumento;
	}

	public String getDescripDocumento() {
		return this.descripDocumento;
	}

	public void setDescripDocumento(String descripDocumento) {
		this.descripDocumento = descripDocumento;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getProvedorDocumento() {
		return this.provedorDocumento;
	}

	public void setProvedorDocumento(String provedorDocumento) {
		this.provedorDocumento = provedorDocumento;
	}

	public String getRucDocumento() {
		return this.rucDocumento;
	}

	public void setRucDocumento(String rucDocumento) {
		this.rucDocumento = rucDocumento;
	}

	public TblTipodocumento getTblTipodocumento() {
		return this.tblTipodocumento;
	}

	public void setTblTipodocumento(TblTipodocumento tblTipodocumento) {
		this.tblTipodocumento = tblTipodocumento;
	}

}