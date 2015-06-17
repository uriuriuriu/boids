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
	for (int i = 0; i < 20; ++i) {
		Boid boid = new Boid();
		boid.SetRandom();
		boids.add(boid);
	}
//	println("boids.get(0).aa: " + boids.get(0).aa);
}

public void draw() {
	background(130);

	for (Boid boid : boids) {
		boid.draw();
	}
//	Boid boid = boids.get(0);
}
class Boid{
	private int _lifeCount = 0;
	private static final float W = 4;
	private static final float H = 10;
	public PVector _pos = new PVector(0,0);
	public float _angle = random(0, 360);
	public float _aPos = 0;
	public float _vPos = 0;
	public float _vMAX = 10;
	Boid(){
		fill(55, 255);
		DrawPoint();
	}

	public void draw() {
		if((_lifeCount % 200) == 0){
			SetRandomA();

		}


		_vPos += _aPos;
		if(_vMAX < _vPos)_vPos = _vMAX;
		if(_vPos < -_vMAX)_vPos = -_vMAX;
		_pos.add(_vPos * cos(_angle), _vPos * sin(_angle), 0);
		if(_pos.x < 0)_pos.x += width;
		if(_pos.y < 0)_pos.y += height;
		if(width < _pos.x)_pos.x -= width;
		if(height < _pos.y)_pos.y -= height;
		DrawPoint();
		_lifeCount++;
	}

	public void DrawPoint(){
		pushMatrix();
		beginShape();
		translate(_pos.x, _pos.y);
		float scaleSize = _vPos * 0.05f;
		scaleSize = scaleSize * scaleSize + 0.4f;
		scale(scaleSize);
		rotate(_angle);
		vertex(H/2, 0);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	public void SetRandom(){
		_pos.set(random(width), random(height));
		SetRandomA();
	}

	public void SetRandomA(){
		_vPos = 0;
		_aPos = random(0, _vMAX * 0.01f);
		_angle = random(0, 1);
		_angle = random(0, PI * 2);;
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
