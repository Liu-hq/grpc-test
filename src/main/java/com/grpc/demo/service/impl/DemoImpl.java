package com.grpc.demo.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.grpc.demo.utils.ReturnMessage;
import com.liu.demo.demo.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@GrpcService
public class DemoImpl extends DemoServiceGrpc.DemoServiceImplBase {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sayHello(DemoRequest req, StreamObserver<DemoResponse> responseObserver) {
        try {
            logger.info("接口得到的内容为【{}】",req.toString());

            //TODO 逻辑处理

            ResultTest.Builder resultTest = ResultTest.newBuilder();
            Map<String,String> result = ReturnMessage.jsonData("true","接受消息成功","200","操作成功");
            resultTest.putAllResult(result);//自定义返回结果
            DemoResponse reply = DemoResponse.newBuilder().setResultTest(resultTest).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();




        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
