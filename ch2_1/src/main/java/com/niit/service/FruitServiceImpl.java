package com.niit.service;

import com.niit.domain.Fruit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FruitServiceImpl implements FruitService{
    @Override
    public List<Fruit> queryFruitList() {
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 19, "山东烟台"));
        fruitList.add(new Fruit("梨子", 8.5, "汤山"));
        fruitList.add(new Fruit("香蕉", 5, "海南"));
        return fruitList;
    }
}
