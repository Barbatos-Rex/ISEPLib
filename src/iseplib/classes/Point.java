package iseplib.classes;
import java.lang.Math;

class Point {
    public double x;
    public double y;
    public double dist;
    public double ang;
    private boolean initialInfo = true;

    private void calculateAngleAndDistance() {
        if (initialInfo) {
            if (this.x == 0) {
                this.ang = (MyMath.PI / 2) * (this.y / MyMath.abs(this.y));
            } else {
                this.ang = Math.atan(y / x);
            }
            if (this.ang < 0) {
                this.ang += 2 * MyMath.PI;
            }
            this.dist = Math.pow(this.x * this.x + this.y * this.y, 0.5);
        }
    }

    public Point(double x,double y){
        this.x=x;
        this.y=y;
        calculateAngleAndDistance();
    }
    public void info(){
        System.out.println("x: "+this.x+"\ny: "+this.y+"\nDistance to origin: " +this.dist+"\nAngle with the x axis: "+this.ang);
    }
    public void move(double x0,double y0){
        this.x+=x0;
        this.y+=y0;
        initialInfo=false;
        calculateAngleAndDistance();
    }
    public void reflect(double x0,double y0){
        this.x=-this.x+2*x0;
        this.y=-this.y+2*y0;
        initialInfo=false;
        calculateAngleAndDistance();
    }
    public void rotation(double x0,double y0,double angleOfRotation){
        this.x-=x0;
        this.y-=y0;
        calculateAngleAndDistance();
        angleOfRotation=angleOfRotation%(2*MyMath.PI);
        this.ang+=angleOfRotation;
        this.x=this.dist*Math.cos(this.ang);
        this.y=this.dist*Math.sin(this.ang);
        this.x+=x0;
        this.y+=y0;
        calculateAngleAndDistance();
    }
}