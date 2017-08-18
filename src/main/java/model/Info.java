package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="INFO")
public class Info {
	@XmlElement(name="FUNNAM",required=true)
	private String FUNNAM;
	@XmlElement(name="DATTYP",required=true)
	private String DATTYP;
	@XmlElement(name="LGNNAM",required=true)
	private String LGNNAM;
	public Info(String fUNNAM, String dATTYP, String lGNNAM) {
		super();
		FUNNAM = fUNNAM;
		DATTYP = dATTYP;
		LGNNAM = lGNNAM;
	}
	public Info(){
		super();
	}
    
}
