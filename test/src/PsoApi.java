import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//粒子状态接口
public class PsoApi {
    //粒子数量
    private static int particleNum = 1000;
    //个体学习因子
    private static double c1 = 2;
    //社会学习因子
    private static double c2 = 2;
    //最大速度
    private static double vMax = 1;
    //速度惯性权重
    private static double w = 1;
    //迭代次数
    private static int genMax = 50000;
    //全局最优位置
    private static double gbest[];
    //全局最优位置对应适应值
    private static double gbest_fitness = Double.MAX_VALUE;
    //粒子群数组
    private static List<Particle> particles = new ArrayList<Particle>(); //粒子群

    public static void main(String[] args) {
        initialParticles(); //初始化
        updateGbest(); //更新gbest
        //循环指定次数genMax次
        for (int i = 0; i < genMax; i++) {
            updateV(i); //更新v
            updateX(); //更新x
            updateGbest(); //更新gbest
            //输出内容
            if (i % 20 == 0) {
                System.out.println(i + "fitness=" + gbest_fitness);
            }
        }
    }

    //初始化所有粒子
    public static void initialParticles() {
        for (int i = 0; i < particleNum; i++) {
            Particle particle = new Particle(); //创建粒子群实体对象
            particle.initialX(); //初始化粒子位置
            particle.initialV(); //初始化粒子速度
            particle.fitness = particle.calculateFitness();//计算距离
            particles.add(particle);//粒子信息放到集合中
        }
    }

    //更新gbest
    public static void updateGbest() {
        double fitness = Double.MAX_VALUE;
        int index = 0; //保存适应值最小粒子序号
        for (int i = 0; i < particleNum; i++) { //找到适应值最小的粒子
            if (particles.get(i).fitness < fitness) {
                index = i; //更新序号
                fitness = particles.get(i).fitness;
            }
        }
        if (fitness < gbest_fitness) { //如果个体适应值小于全局适应值，更新全局的最优值为个体最优值  不在上面循环更新可以减少赋值次数，优化更好
            gbest = particles.get(index).pbest.clone(); //.clone 创建副本保证不改变原来的pbest值
            gbest_fitness = fitness;
        }
    }

    //更新速度
    public static void updateV(int n) {
        //如果循环次数过多还未达到目标就减少最大速度
        if (n % 1000 == 0) {
            vMax = vMax * 0.1;
        }
        for (Particle particle : particles) {
            for (int i = 0; i < particle.dimension; i++) {
                double v = w * particle.v[i] + c1 * new Random().nextDouble() *
                        (particle.pbest[i] - particle.x[i]) + c2 * new Random().nextDouble() * (gbest[i] - particle.x[i]);
                if (v > vMax) // 判断速度是否超过最大的速度
                    v = vMax;
                else if (v < -vMax) // 比最大速度的相反数小
                    v = -vMax;
                particle.v[i] = v;//更新Vi
            }
        }
    }

    //更新位置和pbest
    public static void updateX() {
        for (Particle particle : particles) {
            for (int i = 0; i < particle.dimension; i++) {
                particle.x[i] = particle.x[i] + particle.v[i];
            }
            double newFitness = particle.calculateFitness();//新的适应值
            //如果新的适应值比原来的小则跟新fitness和pbest
            if (newFitness < particle.fitness) {
                particle.pbest = particle.x.clone();
                particle.fitness = newFitness;
            }
        }
    }
}