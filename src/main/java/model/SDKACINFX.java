package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SDKACINFX")
public class SDKACINFX {
	 @XmlElement(name="BBKNBR",required=true)
     private String BBKNBR;
	 @XmlElement(name="C_BBKNBR",required=true)
     private String C_BBKNBR;
	 @XmlElement(name="ACCNBR",required=true)
     private String ACCNBR;
	public SDKACINFX(String bBKNBR, String c_BBKNBR, String aCCNBR) {
		super();
		BBKNBR = bBKNBR;
		C_BBKNBR = c_BBKNBR;
		ACCNBR = aCCNBR;
	}
	
	public SDKACINFX(){
		super();
	}
	 
}
