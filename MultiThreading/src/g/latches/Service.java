package g.latches;

public class Service {
	
	private String serviceName;
	
	public Service(){
		
	}

	public Service(String serviceName){
		this.serviceName = serviceName;
	}
	
	public void init() {
		// This methods initialize corresponding service
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
