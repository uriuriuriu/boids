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
	public PVector _aPos = new PVector(0,0);
	public PVector _vPos = new PVector(0,0);
	public PVector _vMAX = new PVector(10,10);
	Boid(){
		fill(55, 255);
		DrawPoint();
	}

	public void draw() {
		if((_lifeCount % 200) == 0){
//			SetRandomA();
			_aPos.set(-_aPos.x, -_aPos.y);
		}


		_vPos.add(_aPos);
		if(_vMAX.x < _vPos.x)_vPos.x = _vMAX.x;
		if(_vMAX.y < _vPos.y)_vPos.y = _vMAX.y;
		if(_vPos.x < -_vMAX.x)_vPos.x = -_vMAX.x;
		if(_vPos.y < -_vMAX.y)_vPos.y = -_vMAX.y;
		_pos.add(_vPos);
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
		float scaleSize = (_vPos.x + _vPos.y)*0.05f;
//		if(scaleSize < 0)scaleSize *= -1;
		scaleSize = scaleSize * scaleSize + 0.4f;
		scale(scaleSize);
		rotate(atan2(_vPos.y, _vPos.x));
		vertex(H/2, 0);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	public void SetRandom(){
		_pos.set(random(width), random(height));
		SetRandomA();
//		_vPos.set(random(_vMAX.x), -random(_vMAX.y));
	}

	public void SetRandomA(){
		_aPos.set(random(_vMAX.x)*0.08f, random(_vMAX.y)*0.08f);
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
