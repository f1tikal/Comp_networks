import static java.lang.Math.pow;

class Ship{
    String name;
    int water_pl,length, speed;
    int x,y;

    public Ship(String name, int water_pl, int length, int speed, int x, int y) {
        this.name = name;
        this.water_pl = water_pl;
        this.length = length;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getWater_pl() {
        return water_pl;
    }

    public int getLength() {
        return length;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWater_pl(int water_pl) {
        this.water_pl = water_pl;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    void print(){
        System.out.println("Name: "+ name + "Water skolko: "+water_pl+" "+length+"m "+"Speed "+speed+"\n coordinates: "+x+" "+y);
    }
    void run(int x, int y){
        this.x+=x;
        this.y+=y;
    }
    double getVector(){
        return pow((pow(this.x,2)+pow(this.y,2)),0.5);
    }
    void SWEN(){
        if(x>=0&&y>=0){
            System.out.println("NE");
        }
        else if(x>=0&&y<=0){
            System.out.println("SE");
        }
        else if(x<=0&&y<=0){
            System.out.println("SW");
        }
        else if(x<=0&&y>=0){
            System.out.println("NW");
        }
    }
    void crush(){
        this.water_pl=0;
        this.length=0;
        this.speed=0;
        System.out.println("It crushed");
    }

}
class Passenger_Ship extends Ship{
    int seats,shlups;
    int moshnost;
    public Passenger_Ship(String name, int water_pl, int length, int speed, int x, int y, int seats, int shlups,int moshnost) {
        super(name, water_pl, length, speed, x, y);
        this.seats = seats;
        this.shlups = shlups;
        this.moshnost=moshnost;
    }

    public int getMoshnost() {
        return moshnost;
    }

    public void setMoshnost(int moshnost) {
        this.moshnost = moshnost;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getShlups() {
        return shlups;
    }

    public void setShlups(int shlups) {
        this.shlups = shlups;
    }
    int saved(){
        if(shlups*4>seats){
            return seats;
        }
        else{
            return shlups*4;
        }
    }
    void getMorePassangers(int multiplier){
        this.seats*=multiplier;
    }
    void upgrade(int multiplier){
        this.moshnost*=multiplier;
        System.out.println("You're upgrade your vehicle");
    }

}
class War_Ships extends Ship{
    int weapons, distance;

    public War_Ships(String name, int water_pl, int length, int speed, int x, int y, int weapons, int distance) {
        super(name, water_pl, length, speed, x, y);
        this.weapons = weapons;
        this.distance = distance;
    }

    public int getWeapons() {
        return weapons;
    }

    public void setWeapons(int weapons) {
        this.weapons = weapons;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    void canFire(int x, int y){
        if(distance>=(pow((pow(x-this.x,2)+pow(y-this.y,2)),0.5))){
            System.out.println("Can");
        }
        else{
            System.out.println("No");
        }
    }
    void upgrade(int multiplier){
        this.weapons*=multiplier;
        this.distance+=this.weapons/3;
        System.out.println("You're upgraded your monster ship");
    }
    void downgrade(int multiplier){
        this.weapons/=multiplier;
        this.distance-=this.weapons/3;
        System.out.println("Downgraded");
    }
}


public class Main {
    public static void main(String[] args) {



    }
}