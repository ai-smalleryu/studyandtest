package workTestMianshi;

public enum Sex {
    M(1), F(0);
    private int s;

    Sex(int s) {
        this.s = s;
    }

    public int getS() {
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Sex.M);
        Sex[] values = Sex.values();
        for (Sex value : values) {
            System.out.println(value+"枚举信息");
        }
        System.out.println(Sex.valueOf("M"));
        //使用拿值
        System.out.println(Sex.valueOf("M").getS());
    }
}
