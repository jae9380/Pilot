//package com.step3.problem03.entity;
//
//import com.step3.problem03.entity.baseEntity.Organism;
//
//import java.util.Map;
//
//public class Plant extends Organism {
//    private int bloomingSeason;
//    private boolean hasFruit;
//
//    public Plant(String[] info) {
//        super(info[0], info[1], info[2]);
//        this.bloomingSeason = Integer.parseInt(info[3]);
//        this.hasFruit = Boolean.parseBoolean(info[4]);
//    }
//    public Plant(String name, String species, String habitat, String bloomingSeason, boolean hasFruit) {
//        super(name, species, habitat);
//        this.bloomingSeason = Integer.parseInt(bloomingSeason);
//        this.hasFruit = hasFruit;
//    }
//
//    @Override
//    public void displayInfo() {
//        super.displayInfo();
//        System.out.printf("개화 시기: %1$s월  \t 열매 유무: %2$-6s\n",
//                this.bloomingSeason, this.hasFruit ? "열매 있음" : "열매 없음");
//    }
//
//    @Override
//    public Map<String, String> getAllInfo() {
//        Map<String, String> info = super.getAllInfo();
//        info.put("bloomingSeason", String.valueOf(bloomingSeason));
//        info.put("hasFruit", hasFruit ? "열매 있음" : "열매 없음");
//        return info;
//    }
//}
