package model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CMBSDKPGK")
public class AccountBalance {
	@XmlElement(name="INFO")
	private Info info;
	@XmlElement(name="SDKACINFX")
	private SDKACINFX sDKACINFX;
	
	
	public AccountBalance(Info info, SDKACINFX sDKACINFX) {
		super();
		this.info = info;
		this.sDKACINFX = sDKACINFX;
	}
    public AccountBalance(){
    	super();
    }

	public static void main(String ags[]){
		try {
			JAXBContext jc=JAXBContext.newInstance(AccountBalance.class);
			Marshaller ms=jc.createMarshaller();
			Info info=new Info("funnam", "xml", "nana.chao");
			SDKACINFX sDKACINFX=new SDKACINFX("001", "招商银行", "18811072032");
			AccountBalance accountBalance=new AccountBalance(info,sDKACINFX);
			
			ms.marshal(accountBalance, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
