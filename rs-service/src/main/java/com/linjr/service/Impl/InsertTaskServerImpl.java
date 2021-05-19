package com.linjr.service.Impl;

import com.linjr.entity.db2.PsoDelTest;
import com.linjr.mapper.db2.PsoDelTestMapper;
import com.linjr.service.InsertTaskServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class InsertTaskServerImpl implements InsertTaskServer {

    @Autowired
    private PsoDelTestMapper psoDelTestMapper;


    private static final Logger logger = LoggerFactory.getLogger(InsertTaskServerImpl.class);



    @Transactional(transactionManager = "db2TransactionManager")
    @Override
//    @Async("myTaskExecutor")
    public void insertBigDate() {
        logger.info("start executeAsync");
        System.out.println("插入1");
        long start = System.currentTimeMillis();
        List<PsoDelTest> list = psoDelTestMapper.select1000W();
//        int endList = list.size();
//        int startList = endList - 500000;
//        boolean PD = true;
//        do {
//            if (startList <= 0) {
//                startList = 0;
//                PD = false;
//            }
//            psoDelTestMapper.batchInsertList(list.subList(startList, endList));
//            endList -= 500000;
//            startList = endList - 500000;
//        } while (PD);
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时:" + (end - start) + "毫秒");
    }

    @Transactional(value = "db2TransactionManager")
    @Override
    @Async("myTaskExecutor")
    public void insertBigDate2() {
        logger.info("start executeAsync");
        System.out.println("插入2");
        long start = System.currentTimeMillis();
        List<PsoDelTest> list = psoDelTestMapper.select1000W();
        int endList = list.size();
        int startList = endList - 500000;
        boolean PD = true;
        do {
            if (startList <= 0) {
                startList = 0;
                PD = false;
            }
            psoDelTestMapper.batchInsertList(list.subList(startList, endList));
            endList -= 500000;
            startList = endList - 500000;
        } while (PD);
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时:" + (end - start) + "毫秒");

    }
}
