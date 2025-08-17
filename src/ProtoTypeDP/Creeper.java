package ProtoTypeDP;
public class Creeper implements Plant {
    private String growthType;

    public Creeper(String growthType) {
        this.growthType = growthType;
    }

    @Override
    public void grow() {
        System.out.println("Creeper grows by " + growthType);
    }

    @Override
    public String getGrowthType() {
        return growthType;
    }

    @Override
    public void setGrowthType(String type) {
        this.growthType = type;
    }

    @Override
    public Plant clone() {
        return new Creeper(this.growthType);
    }
}
