package IOFile;

/**
 * 实现放大器功能
 */
public class Test {
    public static void main(String[] args) {

    }

    public static void test1() {

    }
}

interface say {
    void say();
}

class persion implements say {
    private int voice = 10;

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    @Override
    public void say() {
        System.out.println("声音"+this.voice);
    }
}

class Alpersion implements say{
private persion p;

    public Alpersion(persion p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("声音变化"+p.getVoice()*100+"早");
    }
}