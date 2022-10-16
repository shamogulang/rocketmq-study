package org.apache.rocketmq.test.client.mq;

import org.apache.rocketmq.store.*;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Test {

    public static void main(String[] args) throws IOException {
//        MessageStoreConfig messageStoreConfig = new MessageStoreConfig();
//        BrokerStatsManager brokerStatsManager = new BrokerStatsManager("hhh");
//        MessageArrivingListener messageArrivingListener = new MessageArrivingListener() {
//            @Override
//            public void arriving(String topic, int queueId, long logicOffset, long tagsCode, long msgStoreTime, byte[] filterBitMap, Map<String, String> properties) {
//
//            }
//        };
//        BrokerConfig brokerConfig = new BrokerConfig();
//        DefaultMessageStore defaultMessageStore = new DefaultMessageStore(messageStoreConfig, brokerStatsManager,
//                messageArrivingListener,brokerConfig );
//        CommitLog commitLog = new CommitLog(defaultMessageStore);
//        MessageExtBrokerInner messageExtBrokerInner = new MessageExtBrokerInner();
//        commitLog.asyncPutMessage(messageExtBrokerInner);
//        commitLog.flush();

        MappedFile mappedFile = new MappedFile("C:\\Users\\Admin\\store\\jx\\00000000000000", 1073741824);

        mappedFile.appendMessage(String.valueOf(132).getBytes(),1,4);
        byte[] bytes = "1234chan".getBytes();
        mappedFile.appendMessage(bytes);
        final int readPosition = mappedFile.getReadPosition();
        // 下一次写入的位置
        final int wrotePosition = mappedFile.getWrotePosition();
        final int flushedPosition = mappedFile.getFlushedPosition();
        System.out.println(readPosition);
        System.out.println(wrotePosition);
        System.out.println(flushedPosition);
//        final int fileSize1 = MappedFile.getTotalMappedFiles();
//        long fileSize = MappedFile.getTotalMappedVirtualMemory();
//        System.out.println(fileSize1);
//        System.out.println(fileSize);

        SelectMappedBufferResult selectMappedBufferResult = mappedFile.selectMappedBuffer(0);
         ByteBuffer byteBuffer = selectMappedBufferResult.getByteBuffer();

        System.out.println("int"+byteBuffer.getInt());
        byte[] body = new byte[bytes.length];
        byteBuffer.get(body);
        System.out.println(new String(body));
        //MappedFileQueue queue = new MappedFileQueue();
    }
}
