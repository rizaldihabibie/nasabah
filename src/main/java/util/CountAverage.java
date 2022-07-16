package util;

import java.util.List;

public class CountAverage implements Runnable{

    private List<Integer> listIds;
    private DataAction dataAction;

    public CountAverage( List<Integer> listIds, DataAction dataAction){
        this.listIds = listIds;
        this.dataAction = dataAction;
    }

    @Override
    public void run() {
        dataAction.countAverage(listIds, Thread.currentThread().getId());
    }
}
