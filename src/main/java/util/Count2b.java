package util;

import java.util.List;

public class Count2b implements Runnable{
    private List<Integer> listIds;
    private DataAction dataAction;

    public Count2b( List<Integer> listIds, DataAction dataAction){
        this.listIds = listIds;
        this.dataAction = dataAction;
    }
    @Override
    public void run() {
        dataAction.addBonus25(listIds,Thread.currentThread().getId());
    }
}
