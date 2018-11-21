
// car object
public class Car {
	int slotNo;
	String carNo;
	String color;
	String make;
	
	Car(int slotNo,String carNo,String color,String make){
		this.slotNo=slotNo;
		this.carNo=carNo;
		this.color=color;
		this.make=make;
	}

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	
	
}
