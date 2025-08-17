package ProtoTypeDP;

public class Shrub implements Plant {
    private String growthType;

    public Shrub(String growthType) {
        this.growthType = growthType;
    }

    @Override
    public void grow() {
        System.out.println("Shrub grows by " + growthType);
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
        return new Shrub(this.growthType);
    }
}
