package ec.edu.ups.appdis.g1.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Documentos implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIngreso;
	@Lob 
	@Column(length=16777216)
    private byte[] pdfC; 
	@Lob 
	@Column(length=16777216)
    private byte[] pdfP;
	public int getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
	public byte[] getPdfC() {
		return pdfC;
	}
	public void setPdfC(byte[] pdfC) {
		this.pdfC = pdfC;
	}
	public byte[] getPdfP() {
		return pdfP;
	}
	public void setPdfP(byte[] pdfP) {
		this.pdfP = pdfP;
	} 
	
}
