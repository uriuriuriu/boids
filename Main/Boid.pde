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

	void draw() {
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

	void DrawPoint(){
		pushMatrix();
		beginShape();
		translate(_pos.x, _pos.y);
		float scaleSize = (_vPos.x + _vPos.y)*0.05;
//		if(scaleSize < 0)scaleSize *= -1;
		scaleSize = scaleSize * scaleSize + 0.4;
		scale(scaleSize);
		rotate(atan2(_vPos.y, _vPos.x));
		vertex(H/2, 0);
		vertex(-H/2, -W/2);
		vertex(-H/2, W/2);
		endShape(CLOSE);
		popMatrix();
	}

	void SetRandom(){
		_pos.set(random(width), random(height));
		SetRandomA();
//		_vPos.set(random(_vMAX.x), -random(_vMAX.y));
	}

	void SetRandomA(){
		_aPos.set(random(_vMAX.x)*0.08, random(_vMAX.y)*0.08);
	}
};
