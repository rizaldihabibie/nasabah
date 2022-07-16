import model.DataAfter;
import model.DataBefore;
import model.Output;
import util.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args){
        String fileName = null;
        String outputFileName = null;
        if(null != args && args.length>1 && null != args[0]){
            fileName = args[0];
        }else{
            fileName = "./Before_Eod.csv";
        }
        if(null != args && args.length>1 && null != args[1]){
            outputFileName = args[1];
        }else{
            outputFileName = "./test_alami.csv";
        }
        CSV csv = new CSV();
        List<DataBefore> listDataBefore = csv.convertToObject(FileLoader.load(fileName));
        List<Integer> listIds = new ArrayList<>();
        List<Integer> listIds2a = new ArrayList<>();
        List<Integer> listIds2b = new ArrayList<>();
        List<Integer> listIds3 = new ArrayList<>();
        DataAction dataAction = new DataAction();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorService executor2a = Executors.newFixedThreadPool(3);
        ExecutorService executor2b = Executors.newFixedThreadPool(3);
        ExecutorService executor3 = Executors.newFixedThreadPool(8);

        int indexBonus = 0;
        for(DataBefore dataBefore : listDataBefore){
            DataAfter dataAfter = new DataAfter();
            dataAfter.setId(dataBefore.getId());
            dataAfter.setName(dataBefore.getName());
            dataAfter.setAge(dataBefore.getAge());
            dataAfter.setBalanced(dataBefore.getBalanced());
            dataAfter.setAverageBalanced(dataBefore.getAverageBalanced());
            dataAfter.setFreeTransfer(dataBefore.getFreeTransfer());
            dataAfter.setPreviousBalanced(dataBefore.getPreviousBalanced());
            Output.outputMap.put(dataBefore.getId(),dataAfter);
            listIds.add(dataBefore.getId());
            if(listIds.size() == 100){
                executor.execute(new CountAverage(listIds,dataAction));
                listIds = new ArrayList<>();
            }
            if(dataAfter.getBalanced() >= 100 && dataAfter.getBalanced() <=150){
                listIds2a.add(dataAfter.getId());
                if(listIds2a.size() == 30){
                    executor2a.execute(new Count2a(listIds2a,dataAction));
                    listIds2a = new ArrayList<>();
                }
            }else if(dataAfter.getBalanced()>150){
                listIds2b.add(dataAfter.getId());
                if(listIds2b.size() == 30){
                    executor2b.execute(new Count2b(listIds2b,dataAction));
                    listIds2b = new ArrayList<>();
                }
            }
            if(indexBonus < 100){
                listIds3.add(dataAfter.getId());
                if(listIds3.size() == 10){
                    executor3.execute(new CountBonus(listIds3,dataAction));
                    listIds3 = new ArrayList<>();
                }
                indexBonus++;
            }
        }
        if(listIds.size() > 0){
            executor.execute(new CountAverage(listIds,dataAction));
        }
        if(listIds2a.size() > 0){
            executor2a.execute(new Count2a(listIds2a,dataAction));
        }
        if(listIds2b.size() > 0){
            executor2b.execute(new Count2b(listIds2b,dataAction));
        }

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        executor2a.shutdown();
        executor2b.shutdown();
        executor3.shutdown();
        try (Writer writer = new FileWriter(outputFileName)) {
            writer.append("id;Nama;Age;Balanced;No 2b Thread-No;No 3 Thread-No;Previous Balanced;Average Balanced;No 1 Thread-No;Free Transfer;No 2a Thread-No")
                    .append("\r\n");
            for (Map.Entry<Integer, DataAfter> entry : Output.outputMap.entrySet()) {
                writer.append(entry.getValue().toString())
                        .append(';')
                        .append("\r\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

    }
}
