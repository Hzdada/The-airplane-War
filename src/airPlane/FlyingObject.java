package airPlane;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected BufferedImage image;
    protected BufferedImage[] ember;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 检查是否出界
     */
    public abstract boolean outOfBounds();

    /**
     * 飞行物移动一步
     */
    public abstract void step();

    /**
     * 检查当前飞行物体是否被子弹(x,y)击(shoot)中，
     * true表示击中，飞行物可以被击中
     */
    public boolean shootBy(Bullet bullet) {
        if (bullet.isBomb()) {
            return false;
        }
        int x = bullet.x; // 子弹横坐标
        int y = bullet.y; // 子弹纵坐标
        boolean shoot = this.x < x && x < this.x + width
                && this.y < y && y < this.y + height;
        if (shoot) {
            bullet.setBomb(true);
        }
        return shoot;
    }

}