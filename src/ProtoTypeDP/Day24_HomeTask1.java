package ProtoTypeDP;

public class Day24_HomeTask1 {
    public static void main(String[] args) {
        // Create original objects
        Plant creeper1 = new Creeper("climbing walls");
        Plant shrub1 = new Shrub("growing bushy");

        // Clone them
        Plant creeper2 = creeper1.clone();
        creeper2.setGrowthType("spreading along ground");

        Plant shrub2 = shrub1.clone();
        shrub2.setGrowthType("flowering");

        // Test growth
        creeper1.grow();
        creeper2.grow();
        shrub1.grow();
        shrub2.grow();
    }
}
