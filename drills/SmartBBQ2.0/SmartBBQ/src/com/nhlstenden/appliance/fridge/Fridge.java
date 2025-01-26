package com.nhlstenden.appliance.fridge;

import com.nhlstenden.appliance.thermometer.Measurable;
import com.nhlstenden.food.Food;
import com.nhlstenden.food.meat.Meat;
import com.nhlstenden.food.vegetable.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Fridge implements Measurable
{
    private static Fridge instance;
    private List<Food> foodsInFridge;
    private int currentTemperature;

    public Fridge()
    {
        this.foodsInFridge = new ArrayList<>();
        this.currentTemperature = 8;
    }

    public List<Food> getFoodsInFridge ()
    {
        return foodsInFridge;
    }

    public void setFoodsInFridge (List<Food> foodsInFridge)
    {
        this.foodsInFridge = foodsInFridge;
    }

    public static Fridge getInstance()
    {
        if (instance == null)
        {
            instance = new Fridge();
        }

        return instance;
    }

    public void addFood(Food food)
    {
        this.foodsInFridge.add(food);
    }

    @Override
    public int getTemperature ()
    {
        return currentTemperature;
    }

    public void setCurrentTemperature (int currentTemperature)
    {
        this.currentTemperature = currentTemperature;
    }

    public Food getNextItem(FoodType type) throws FridgeIsEmptyException, NoMoreFoodException
    {
        if (this.foodsInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException();
        }

        for (int i = 0; i < this.foodsInFridge.size(); i++)
        {
            Food searchingFood = this.foodsInFridge.get(i);
            switch (type)
            {
                case MEAT:
                    if (searchingFood instanceof Meat)
                    {
                        return this.foodsInFridge.remove(i);
                    }
                    break;
                case VEGETABLE:
                    if (searchingFood instanceof Vegetable)
                    {
                        return this.foodsInFridge.remove(i);
                    }
                    break;
                default:
                    break;
            }
        }
        throw new NoMoreFoodException(type.name());
    }

    public Meat getNextMeat()
    {
        return (Meat) this.getNextItem(FoodType.MEAT);
    }

    public Vegetable getNextVegetable()
    {
        return (Vegetable) this.getNextItem(FoodType.VEGETABLE);
    }
}
