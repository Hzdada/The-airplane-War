package airPlane;

public class AirPlane extends FlyingObject implements Enemy {

    int speed = 2; // 移动步骤

    public AirPlane() {
        this.image = MyFrame.airplane;
        this.ember = MyFrame.airplaneEmber;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        x = (int) (Math.random() * (MyFrame.WIDTH - width));
    }

    @Override
    public int getScore() { // 获取分数
        return 5;
    }

    @Override
    public boolean outOfBounds() { // 越界处理
        return y > MyFrame.HEIGHT;
    }

    @Override
    public void step() { // 移动
        y += speed;
    }

}
