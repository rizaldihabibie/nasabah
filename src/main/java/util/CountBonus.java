package util;

import java.util.List;

public class CountBonus implements Runnable{

    private List<Integer> listIds;
    private DataAction dataAction;

    public CountBonus(List<Integer> listIds, DataAction dataAction){
        this.listIds = listIds;
        this.dataAction = dataAction;
    }

    @Override
    public void run() {
        dataAction.addBonus10(listIds, Thread.currentThread().getId());
    }
}
