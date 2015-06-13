class Boid{
	private String aa = "acaa";
	public String bb = "bbbb";
	private static final float W = 2;
	private static final float H = 10;
	public PVector pos = new PVector(0,0);
	public PVector vPos = new PVector(0,0);
	Boid(){
		fill(55, 255);
		drawPoint();
	}

	void draw() {
		drawPoint();
	}

	void drawPoint(){
		pushMatrix();
		beginShape();
		translate(pos.x, pos.y);
		rotate(atan2(vPos.y, vPos.x));
		// vertex(W, -H/2);
		// vertex(0, H/2);
		// vertex(-W, -H/2);
		vertex(H/2, W/2);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	void SetRandom(float w, float h){
		pos.set(random(w), random(h));
		vPos.set(random(10), random(10));
	}
};
