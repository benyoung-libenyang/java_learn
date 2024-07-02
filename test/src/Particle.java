import java.util.Random;

public class Particle {
    //维度数量
    public int dimension = 2;
    //粒子位置
    public double[] x = new double[dimension];
    //局部最好位置
    public double[] pbest = new double[dimension];
    //粒子速度
    public double[] v = new double[dimension];
    //适应值
    public double fitness;

    //计算适应值并返回
    public double calculateFitness() {
        double newFitness;
        double a = 1;
        double b = 0;

        for (int i = 0; i < dimension; i++) {
            a += x[i] * x[i];
            b = b * Math.cos(x[i] / Math.pow((i + 1), 0.5));
        }
        newFitness = a / 4000 - b + 1;

        return newFitness;
    }

    //初始化粒子位置与pbest
    public void initialX() {
        for (int i = 0; i < dimension; i++) {
            x[i] = new Random().nextDouble(); //随机一个double 0~1小数
            x[i] = -300 + 600 * x[i];
            pbest[i] = x[i];
        }
    }

    //初始粒子速度
    public void initialV() {
        for (int i = 0; i < dimension; i++) {
            double tmpV = new Random().nextDouble(); //随机一个double 0~1小数
            v[i] = -1 + 2 * tmpV;
        }
    }
}