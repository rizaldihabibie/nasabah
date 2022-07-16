package util;

import model.DataAfter;
import model.Output;

import java.util.List;

public class DataAction {

    public synchronized void countAverage(List<Integer> listIds, long threadNumber){
        System.out.println("Thread no "+threadNumber+" Processing "+listIds.size()+" data.");
        for(Integer id : listIds) {
            DataAfter dataAfter = Output.outputMap.get(id);
            int average = (dataAfter.getBalanced() + dataAfter.getPreviousBalanced()) / 2;
            Output.outputMap.get(dataAfter.getId()).setAverageBalanced(average);
            Output.outputMap.get(dataAfter.getId()).setNo1ThreadNo(threadNumber);
        }
    }

    public synchronized void addBonus5(List<Integer> listIds, long threadNumber){
        System.out.println("Thread 2a no "+threadNumber+" Processing "+listIds.size()+" data.");
        for(Integer id : listIds) {
            DataAfter dataAfter = Output.outputMap.get(id);
            Output.outputMap.get(dataAfter.getId()).setFreeTransfer(5);
            Output.outputMap.get(dataAfter.getId()).setNo2aThreadNo(threadNumber);
        }
    }

    public synchronized void addBonus25(List<Integer> listIds, long threadNumber){
        System.out.println("Thread 2b no "+threadNumber+" Processing "+listIds.size()+" data.");
        for(Integer id : listIds) {
            DataAfter dataAfter = Output.outputMap.get(id);
            Output.outputMap.get(dataAfter.getId()).setFreeTransfer(25+dataAfter.getFreeTransfer());
            Output.outputMap.get(dataAfter.getId()).setNo2bThreadNo(threadNumber);
        }
    }

    public synchronized void addBonus10(List<Integer> listIds, long threadNumber){
        System.out.println("Thread 3 no "+threadNumber+" Processing "+listIds.size()+" data.");
        for(Integer id : listIds) {
            DataAfter dataAfter = Output.outputMap.get(id);
            Output.outputMap.get(dataAfter.getId()).setBalanced(10+dataAfter.getBalanced());
            Output.outputMap.get(dataAfter.getId()).setNo3ThreadNo(threadNumber);
        }
    }
}
