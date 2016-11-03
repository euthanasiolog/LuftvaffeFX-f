package logic;

/**
 * Created by Piatrok on 03.11.16.
 */
public class Airplan implements RefuelAirplan, DrainFuel, Comparable{

    /**
     * вес пустого самолета (вес топлива не учитывается)
     */
    int weight;

    /**
     * максимальный объем бака
     */
    int maxTankVolume;

    /**
     * гетеры и сетеры для всего
     */
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxTankVolume() {
        return maxTankVolume;
    }

    public void setMaxTankVolume(int maxTankVolume) {
        this.maxTankVolume = maxTankVolume;
    }

    public int getWeightOnBoard() {
        return weightOnBoard;
    }

    public void setWeightOnBoard(int weightOnBoard) {
        this.weightOnBoard = weightOnBoard;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public String getIsFly() {
        return isFly;
    }

    public void setIsFly(String isFly) {
        this.isFly = isFly;
    }



    /**
     * вес на борту
     */
    int weightOnBoard;

    /**
     * дистанция полета, высчитываемая по секретной авиационной формуле
     */
    private int flyDistance = (maxTankVolume*1000)/(weight+weightOnBoard);

    int getFlyDistance() {
        return flyDistance;
    }

    /**
     * Текущее количество топлива
     */
    private int fuelVolume;

    /**
     * Состояния самолета "Fly" либо "NotFly"
     */
    private String isFly="noT fly";

    /**
     * Заставляет самолет полететь
     * @return состояние самолета
     */
    private StringBuilder str = new StringBuilder();
    String fly (){
        str.append("Fly");
        return str.toString();
    }
    String notFly (){
        str.append("NotFly");
        return str.toString();
    }


    /**
     * Устанавливаем количество топлива равным нулю
     */

    @Override
    public void drainFuel() {
        this.fuelVolume = 0;
    }

    /**
     * добавляем в бак топливо
     * @param n - количество добавляемого топлива
     */

    @Override
    public void refuel(int n) {
        this.fuelVolume += n;
        if (fuelVolume>maxTankVolume){
            fuelVolume=maxTankVolume;
        }
    }
    public int compareTo(Object o) {
        String flyDistance = String.valueOf(this.flyDistance);
        String comparedFlyDistance = String.valueOf(((Airplan) o).getFlyDistance());
        return flyDistance.compareTo(comparedFlyDistance);
    }
}
