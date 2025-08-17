package ProtoTypeDP;

public interface Plant extends Cloneable {
    void grow();
    String getGrowthType();
    void setGrowthType(String type);
    Plant clone();
}
