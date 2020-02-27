public class FelidaeFamily extends Animal{
    boolean meowing;
    public FelidaeFamily(int age, int weight, boolean running, boolean eating, boolean meowing) {
        super(age, weight, running, eating);
        this.meowing = meowing;
    }

    public boolean isMeowing() {
        return meowing;
    }

    public void setMeowing(boolean meowing) {
        this.meowing = meowing;
    }
}
