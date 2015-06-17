import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Main extends PApplet {

public static final int NUM_POINT = 100;
public static ArrayList<Boid> boids = new ArrayList<Boid>();

public void setup() {size(512, 512);
	background(130);
	fill(255, 150);
	ellipse(width/2, height/2, 30, 30);
	for (int i = 0; i < 10; ++i) {
		Boid boid = new Boid();
		boid.SetRandom(width, height);
		boids.add(boid);
	}
//	println("boids.get(0).aa: " + boids.get(0).aa);
}

public void draw() {
	background(130);

	for (Boid boid : boids) {
		boid.pos.set(boid.pos.x + boid.vPos.x, boid.pos.y + boid.vPos.y);
		if(512 < boid.pos.x){boid.pos.x -=512;}
		if(512 < boid.pos.y){boid.pos.y -=512;}
		boid.draw();
	}
//	Boid boid = boids.get(0);
}
class Boid{
	private static final float W = 4;
	private static final float H = 10;
	public PVector pos = new PVector(0,0);
	public PVector vPos = new PVector(0,0);
	Boid(){
		fill(55, 255);
		drawPoint();
	}

	public void draw() {
		drawPoint();
	}

	public void drawPoint(){
		pushMatrix();
		beginShape();
		translate(pos.x, pos.y);
		rotate(atan2(vPos.y, vPos.x));
		vertex(H/2, 0);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	public void SetRandom(float w, float h){
		pos.set(random(w), random(h));
		vPos.set(random(10), random(10));
	}
};
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
