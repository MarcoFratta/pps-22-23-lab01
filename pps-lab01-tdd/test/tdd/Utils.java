package tdd;

import lab01.tdd.BaseList;

import java.util.Optional;

public class Utils {

    private Utils(){}

    public static void populateListRandomly(final BaseList<Integer> list, final int size){
        for(int i = 0; i < size; i++){
            list.add((int) (Math.random() * 100));
        }
    }

    public static void populateListOrdered(final BaseList<Integer> list,final int size){
        for(int i = 0; i < size; i++){
            list.add(i);
        }
    }

    public static <T> T checkExistence(final Optional<T> x){
        return x.orElseThrow(RuntimeException::new);
    }
}
