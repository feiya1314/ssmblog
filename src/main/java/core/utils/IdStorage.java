package core.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IdStorage {
    private final static int MAXNUM=200;
    List<Integer[]> idList=new ArrayList<>();
    Lock lock=new ReentrantLock();
    private Condition conditionProduct=lock.newCondition();
    private Condition conditionConsume=lock.newCondition();
    private volatile boolean isEnd=false;
    private volatile boolean isEmpty=true;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void addIds(Integer[] ids)throws InterruptedException{
        lock.lock();
        try{
            while(idList.size()==MAXNUM){
                conditionProduct.await();
                System.out.println("idList is filling");
            }
            System.out.println("idsadd-->"+ids);
            idList.add(ids);
            isEmpty=false;
            conditionConsume.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public Integer[] getIds() throws InterruptedException{
        Integer[] ids=null;
        lock.lock();
        try{
            if(!isEnd&&(idList.size()!=0)){
                ids=idList.remove(0);
                System.out.println("idsget-->"+ids);
                System.out.println("idsgetSize-->"+idList.size());
                conditionProduct.signalAll();
            }else if(!isEnd&&(idList.size()==0)){
                System.out.println("empty ");
                conditionConsume.await();
                ids=idList.remove(0);
                System.out.println("idsget-->"+ids);
                System.out.println("idsgetSize-->"+idList.size());
                conditionProduct.signalAll();
            }else if(isEnd&&(idList.size()!=0)){
                ids=idList.remove(0);
                System.out.println("idsget-->"+ids);
                System.out.println("idsgetSize-->"+idList.size());
                conditionProduct.signalAll();
            }else {
                isEmpty=true;
            }
        }finally {
            lock.unlock();
        }
        return ids;
    }
}
