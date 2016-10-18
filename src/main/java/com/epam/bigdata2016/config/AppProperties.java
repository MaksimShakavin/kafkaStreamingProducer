package com.epam.bigdata2016.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties
public class AppProperties {

    private Kafka kafka = new Kafka();
    private Data data = new Data();

    public Kafka getKafka() {
        return kafka;
    }

    public Data getData() { return data; }

    public static class Kafka {
        private String bootstrapServer;
        private String acks;
        private int retries;
        private int batchSize;
        private int lingerMs;
        private String keySerializer;
        private String valueSerializer;
        private boolean blockOnBufferFull;
        
        public Map<String,Object> asMap(){
            Map<String,Object> result = new HashMap<>();
            result.put("bootstrap.servers", bootstrapServer);
            result.put("acks", acks);
            result.put("retries", retries);
            result.put("batch.size", batchSize);
            result.put("linger.ms", lingerMs);
            result.put("buffer.memory", 33554432);
            result.put("key.serializer", keySerializer);
            result.put("value.serializer", valueSerializer);
            return result;
        }

        //GETTERS AND SETTERS
        public String getBootstrapServer() {
            return bootstrapServer;
        }

        public void setBootstrapServer(String bootstrapServer) {
            this.bootstrapServer = bootstrapServer;
        }

        public String getAcks() {
            return acks;
        }

        public void setAcks(String acks) {
            this.acks = acks;
        }

        public int getRetries() {
            return retries;
        }

        public void setRetries(int retries) {
            this.retries = retries;
        }

        public int getBatchSize() {
            return batchSize;
        }

        public void setBatchSize(int batchSize) {
            this.batchSize = batchSize;
        }

        public int getLingerMs() {
            return lingerMs;
        }

        public void setLingerMs(int lingerMs) {
            this.lingerMs = lingerMs;
        }

        public String getKeySerializer() {
            return keySerializer;
        }

        public void setKeySerializer(String keySerializer) {
            this.keySerializer = keySerializer;
        }

        public String getValueSerializer() {
            return valueSerializer;
        }

        public void setValueSerializer(String valueSerializer) {
            this.valueSerializer = valueSerializer;
        }

        public boolean isBlockOnBufferFull() {
            return blockOnBufferFull;
        }

        public void setBlockOnBufferFull(boolean blockOnBufferFull) {
            this.blockOnBufferFull = blockOnBufferFull;
        }
    }
    public static class Data{
        private String topic;
        private String directory;

        //GETTERS AND SETTERS
        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getDirectory() {
            return directory;
        }

        public void setDirectory(String directory) {
            this.directory = directory;
        }
    }

}
