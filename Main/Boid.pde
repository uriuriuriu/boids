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

	void draw() {
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

	void DrawPoint(){
		pushMatrix();
		beginShape();
		translate(_pos.x, _pos.y);
		float scaleSize = _vPos * 0.05;
		scaleSize = scaleSize * scaleSize + 0.4;
		scale(scaleSize);
		rotate(_angle);
		vertex(H/2, 0);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	void SetRandom(){
		_pos.set(random(width), random(height));
		SetRandomA();
	}

	void SetRandomA(){
		_vPos = 0;
		_aPos = random(0, _vMAX * 0.01);
		_angle = random(0, 1);
		_angle = random(0, PI * 2);;
	}
};
