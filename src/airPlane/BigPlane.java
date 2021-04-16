package airPlane;

import java.util.Random;

public class BigPlane extends FlyingObject implements Enemy, Award {
    private int speed = 1;
    private int life;
    private int awardType;

    public BigPlane() {
        life = 4;
        this.image = MyFrame.bigPlane;
        this.ember = MyFrame.bigPlaneEmber;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(MyFrame.WIDTH - width);
        awardType = rand.nextInt(2);
    }

    @Override
    public int getType() {
        return awardType;
    }

    @Override
    public int getScore() {
        return 50;
    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    @Override
    public void step() { // 移动
        y += speed;
    }

    @Override
    public boolean shootBy(Bullet bullet) {
        if (super.shootBy(bullet)) {
            life--;
        }
        return life == 0;
    }
}