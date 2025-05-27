package com.step3.problem09.service;

import com.step3.problem09.entity.menu.*;
import com.step3.problem09.entity.order.Order;
import com.step3.problem09.entity.order.OrderItem;
import com.step3.problem09.repository.OrderList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Caffe {
    private List<Menu> menuList;
    private final OrderList orderList;

    public Caffe() {
        orderList = new OrderList();
        menuList = new ArrayList<>();
    }

    public void addNewMenu(MenuType type, String... info) {
        Menu menu = form(type, info);

        if (menu.equals(null)) return;

        boolean exists = menuList.stream().anyMatch(m -> m.equals(menu));
        if (exists) {
            System.out.println("[CAFFE] 해당 메뉴는 메뉴판에 존재합니다.");
            return;
        }
        menuList.add(menu);
        System.out.printf("[CAFFE] 새로운 메뉴 %1$s %2$,d원 등록\n", menu.getName(), menu.getPrice());
    }

    public void getMenuList() {
        System.out.println("[CAFFE] ---- 전체 메뉴 조회 ----");

        for (Menu menu : menuList) {
            menu.getDetails();
        }
    }

    public void removeMenu(Menu menu) {
        boolean removed = menuList.removeIf(menu1 -> menu1.equals(menu));

        if (removed) {
            // 성공
        } else {
            // 실패
        }
    }
    public void createdNewOrder(String customerName, String[][] orderlist) {
        System.out.println("-------- 주문이 추가되었습니다. --------");
        Order order = new Order(customerName);
        System.out.printf("고객 : %s", customerName);
        System.out.printf("\t\t주문 시간 : %s\n", order.getOrderTime());
        int count = 0, totlaAmount = 0;
        for (String[] item : orderlist) {
            String menuName = item[0];

            Menu target = null;
            for (Menu menu : menuList) {
                if (menu.getName().equals(menuName)) {
                    target = menu;
                    break;
                }
            }

            if (target != null) {
                if (target instanceof Sandwich && !((Sandwich) target).expirationDateVerification()) {
                    System.out.printf("[CAFFE] %1$s 만료일이 초과되어 주문할 수 없습니다. \t 만료일 : %2s \n", target.getName(), ((Sandwich) target).getExpirationDateTime());
                    continue;
                }
                OrderItem orderItem = new OrderItem(target, Integer.parseInt(item[1]));
                order.addOrderItem(orderItem);
                totlaAmount += target.amountInfo(++count, Integer.parseInt(item[1]));

            } else {
                System.out.printf("[CAFFE] 메뉴 %s 는 존재하지 않습니다. 주문에서 제외됩니다.\n", menuName);
            }
        }

        if (order.isOrderEmpty()) {
            System.out.println("주문이 실패되었습니다. 다시 주문을 해주세요.");
        }else {
            orderList.save(order);
            System.out.printf("총 주문 금액 : %,d \n",totlaAmount);
            System.out.printf("[CAFFE] %s 고객님의 주문이 완료되었습니다.\n", customerName);
        }
    }

    public void getOrderList() {
        List<Order> list = orderList.getOrderList();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("주문 %1$d. \n", i+1 );
            list.get(i).showOrderInfo();
        }
    }

    private Menu form(MenuType type, String... str) {
        switch (type) {
            case DRINK :
                return new Drink(str);
            case COFFEE:
                return new Coffee(str);
            case SANDWICH:
                return new Sandwich(str);
            default:
                System.out.println("[CAFFE] 올바르지 않은 타입의 메뉴 레시피입니다.");
                return null;
        }
    }

}
