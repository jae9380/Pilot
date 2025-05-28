package com.step4.problem04.species;

//import com.step4.problem04.species.type.EnvironmentType;
//import com.step4.problem04.species.type.MetabolismType;

public class MicrobeFeature {
    private String environment;
    private boolean pathogenic;
    private String metabolismType;

    public MicrobeFeature(String environment, String pathogenic, String  metabolismType) {
        this.environment = environment;
        this.pathogenic = Boolean.parseBoolean(pathogenic);
        this.metabolismType = metabolismType;
    }
}
