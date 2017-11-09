package com.hermes.domain.orders;

import com.hermes.domain.cargo.CargoFactory;

/**
 *  02.10.15.
 */
public class OrderBuilder {

    private AbstractOrder order;
    private CargoFactory cargoFactory;

    private OrderBuilder() {
        order = new BasicOrder();
        cargoFactory = CargoFactory.newCargoFactory(order);
    }

    public static OrderBuilder newOrderBuilder() {
        return new OrderBuilder();
    }

    public void setClientName(String clientName) {
        order.setClientName(clientName);
    }

    public void addCargo(String cargoType, double weight, double volume){
        order.addCargo(cargoFactory.createCargo(cargoType, weight, volume));
    }

    public void addCargo(String cargoType, double weight, double volume, int amount){
        for(int i = 0; i < amount; i++){
            addCargo(cargoType, weight, volume);
        }
    }

    public boolean orderIsReady(){
        return (order.getClientName() != null) && (order.size() > 0);
    }
    public AbstractOrder getOrder(){
        if(orderIsReady()){
            return order;
        }else{
            throw new IllegalStateException();
        }
    }
}
