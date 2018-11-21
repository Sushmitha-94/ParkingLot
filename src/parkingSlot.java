import java.util.HashMap;
import java.util.LinkedList;

// Parking slot assignment and extraction of car information application
public class parkingSlot {

	
	public static String parkingSlotNo;
	public static String[] carSlotNo= new String[10];
	public static HashMap<String, Car> getCar=new HashMap<String, Car>();
	public static int slotsAvailable=0;
	public static HashMap<String, LinkedList<String>> getByColor;
	public static HashMap<String, LinkedList<String>> getByMake;
	public static HashMap<Integer, String> getBySlot=new HashMap<Integer, String>();
	
	// static colors and brand of cars
	static {
		getByColor = new HashMap<String, LinkedList<String>>();
		getByColor.put("Black", new LinkedList<String>());
		getByColor.put("White", new LinkedList<String>());
		getByColor.put("Silver", new LinkedList<String>());
		getByColor.put("Grey", new LinkedList<String>());
		getByColor.put("Blue", new LinkedList<String>());
		getByColor.put("Red", new LinkedList<String>()); 

		getByMake = new HashMap<String, LinkedList<String>>();
		getByMake.put("Audi", new LinkedList<String>());
		getByMake.put("BMW", new LinkedList<String>());
		getByMake.put("Jaguar", new LinkedList<String>());
		getByMake.put("Renault", new LinkedList<String>());
		getByMake.put("Maruti", new LinkedList<String>());
		getByMake.put("Benz", new LinkedList<String>());
	}
	
	// when car enters, the next available slot is identified using findSlot()
	// new car object is created
	// carNo is added to the corresponding colorMap, makeMap, slotMap and carMap
	public static String enterCar(String carNo,String carColor,String carMake) {
		String message="There are no slots available";
		int slotNo=findSlot();
		if(slotNo!=-1) {
			Car newCar=new Car(slotNo,carNo,carColor,carMake);
				getByColor.get(carColor).add(carNo);
				getByMake.get(carMake).add(carNo);
				carSlotNo[slotNo]=newCar.carNo;
				message="Car "+carNo+" is allocated to the Slot : "+slotNo;
				getCar.put(carNo,newCar);
				getBySlot.put(slotNo, carNo);
		}
		
		return message;
	}
	
	// when car exits, car information is deleted from all the maps and free the slot
	public static String exitCar(String carNo) {
		String message="Car "+carNo+ "is deallocated";
		Car carToDelete=getCar.get(carNo);
		getCar.remove(carNo);
		carSlotNo[carToDelete.slotNo]=null;
		getByColor.get(carToDelete.color).remove(carToDelete.carNo);
		getByMake.get(carToDelete.make).remove(carToDelete.carNo);
		getBySlot.remove(carToDelete.slotNo);
		return message;
	}
	
	// returns next available slot
	public static int findSlot() {
		for(int i=0;i<100;i++) {
			if(carSlotNo[i]==null || carSlotNo[i]=="")
				return i;
		}
		return -1;
	}
	
	public static void findCarByColor(String key) {		
		if(getByColor.get(key)==null) {
			System.out.println("No "+key+" colored car is parked");
		}
		else {
			for(String carNo:getByColor.get(key)) {
				System.out.println(carNo+" is parked in the slot "+findSlotByCarNo(carNo));
			}
		}
	}
	public static void findCarByMake(String key) {
		if(getByMake.get(key)==null) {
			System.out.println("No "+key+" car is parked");
		}
		else {
			for(String carNo:getByMake.get(key)) {
				System.out.println(carNo+" is parked in the slot "+findSlotByCarNo(carNo));
			}
		}
	}
	
	public static int findSlotByCarNo(String carNo) {
		return getCar.get(carNo).slotNo;
	}
	
	public static void main(String[] args) {
		System.out.println(enterCar("TN0987","Black","BMW"));
		System.out.println(enterCar("KL0A45","White","Maruti"));
		System.out.println(enterCar("TN0N23","Grey","Jaguar"));
		System.out.println(enterCar("AP0L98","Black","BMW"));
		System.out.println(enterCar("PY0S23","Blue","BMW"));
		System.out.println("Green Color cars:");
		findCarByColor("Black");
		System.out.println("BMW cars:");
		findCarByMake("BMW");
		System.out.println("Car no:TN0987 is parked in the slot:"+findSlotByCarNo("TN0987"));
		exitCar("TN0987");
		System.out.println(enterCar("TN0989","Black","BMW"));
		System.out.println("BMW cars:");
		findCarByMake("BMW");
	}

}
