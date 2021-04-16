package airPlane;
import java.util.Random;
public class Bee extends FlyingObject implements Award {
    private int xSpeed = 1;
    private int ySpeed = 2;
    private int awardType;// 奖励类型

    public Bee() {
        this.image = MyFrame.bee;
        this.ember = MyFrame.beeEmber;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(MyFrame.WIDTH - width);
        awardType = rand.nextInt(2); // 初始化时给奖励类型
    }

    @Override
    public int getType() {
        return awardType;
    }

    @Override
    public boolean outOfBounds() {
        return y > MyFrame.HEIGHT;
    }

    @Override
    public void step() { // 可斜飞
        x += xSpeed;
        y += ySpeed;
        if (x > MyFrame.WIDTH - width) {
            xSpeed = -1;
        }
        if (x < 0) {
            xSpeed = 1;
        }
    }
}