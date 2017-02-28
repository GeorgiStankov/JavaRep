package bg.speedRacing;

 

class Car {
    String carModel;
    double fuelAmount;
    double fuelCostFor1Km;
    int distanceTraveled = 0;
 
    public Car(String carModel, double fuelAmount, double fuelCostFor1Km) {
        this.carModel = carModel;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
    }
    public boolean canCarMove(int kmToDrive){
        double fuelSpended = kmToDrive * fuelCostFor1Km;
        if (fuelAmount >= fuelSpended) {
            fuelAmount -= fuelSpended;
            distanceTraveled+= kmToDrive;
            return true;
        }
        return false;
    }
}