package com.step06.problem02;

import java.util.HashMap;
import java.util.Map;

public class EnergyDistributor {
    private int totalE;
    private final HashMap<String, Integer> map;

    public EnergyDistributor() {
        this.map = new HashMap<>();
        totalE = 50000;
        init();
    }

    public void getTotalE() {
        System.out.printf("→ 남은 전체 에너지 : %d\n\n", totalE);
    }

    public void allocateE(String zone, String e) {
        try {
            if (!validationE(e)) {
                System.out.printf("%1$s에 할당 하려는 에너지의 크기는 남은 전체 에너지 보다 큽니다.\n\n"
                ,zone, e, totalE);
                return;
            }
        }catch (NumberFormatException exception) {
            System.out.println("할당 에너지는 숫자로 입력하세요.");
            return;
        }

        EnergyAllocator allocator = (z, e1) -> {
            map.put(z, map.getOrDefault(z, 0) + Integer.parseInt(e1));
            totalE -= Integer.parseInt(e1);
            System.out.printf("→ %1$s에 %2$s의 에너지가 할당되었습니다. 남은 전체 에너지: %3$d \n\n",
                    z, e1, totalE);
        };

        allocator.allocate(zone, e);
    }

    public void displayZoneEnergy() {
        System.out.println("→ 구역별 에너지 조회");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%1$s \t-\t%2$d\n",entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    /**
     * @FunctionalInterface
     * 해당 어노테이션 선언하는 이유
     * 1. 해당 인터페이스는 단일의 추상 메서드를 갖는다는 명시를 하기 위함 (문서적 목적)
     * 2. 어노테이션이 있을 경우 복수의 추상 메서드가 있을 경우 컴파일 에러가 발생된다.
     * 3. 해당 인터페이스는 바로 람다식에 사용할 수 있도록 해준다.
     */
    @FunctionalInterface
    interface EnergyAllocator {
        void allocate(String zone, String e);
    }

    private void init() {
        map.put("테라노바", 0);
        map.put("루미나베이", 0);
        map.put("플로우브릿지", 0);
    }

    private boolean validationE(String e) throws NumberFormatException{
        int energy = Integer.parseInt(e);
        return energy <= totalE;
    }
}
