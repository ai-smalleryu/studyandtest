package ThreadTest;

/**
 * 模拟归途赛跑
 */
public class Race implements Runnable {
    private String winner;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("兔子")) {
            for (int i = 0; i <= 10000; i += 6) {
             /*   if (Math.random()<0.3){
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                System.out.println(Thread.currentThread().getName() + "zoppppppppppppppppule" + i);
                boolean b = gameOver(i);
                if (b == true) {
                    try {
                        Thread.currentThread().join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        } else {
            for (int i = 0; i <= 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "zoule" + i);
                boolean b = gameOver(i);
                if (b == true) {
                    try {
                        Thread.currentThread().join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }

    }

    private boolean gameOver(int i) {
        if (winner != null) {
            return true;
        } else {
            if (i >= 10000) {
                winner = Thread.currentThread().getName();
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
