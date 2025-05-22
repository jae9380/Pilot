package com.step3.problem05;

import com.step3.problem05.entity.SolarStone;
import com.step3.problem05.entity.Sorcerer;
import com.step3.problem05.entity.WaterMirror;
import com.step3.problem05.entity.WindAmulet;

public class BiodomeFamily05 {
    public static void main(String[] args) {
        Sorcerer sorcerer = new Sorcerer("이리엘");
        SolarStone solarStone = new SolarStone();
        WindAmulet windAmulet = new WindAmulet();
        WaterMirror waterMirror = new WaterMirror();
        System.out.println();
        sorcerer.addArtifact(solarStone);
        sorcerer.addArtifact(windAmulet);
        sorcerer.addArtifact(waterMirror);
        System.out.println();
        sorcerer.useArtifacts(true,false);
    }
}
