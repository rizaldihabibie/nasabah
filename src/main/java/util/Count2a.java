package util;

import java.util.List;

public class Count2a implements Runnable{
    private List<Integer> listIds;
    private DataAction dataAction;

    public Count2a(List<Integer> listIds, DataAction dataAction){
        this.listIds = listIds;
        this.dataAction = dataAction;
    }
    @Override
    public void run() {
        dataAction.addBonus5(listIds,Thread.currentThread().getId());
    }
}
