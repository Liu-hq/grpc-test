package com.grpc.demo.service.impl;


import com.liu.demo.demo.DemoRequest;
import com.liu.demo.demo.DemoResponse;
import com.liu.demo.demo.DemoServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DemoImpl extends DemoServiceGrpc.DemoServiceImplBase {

    @Override
    public void sayHello(DemoRequest req, StreamObserver<DemoResponse> responseObserver){
        DemoResponse reply = DemoResponse.newBuilder().setMessage(("Hello "+req.getAge())).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
