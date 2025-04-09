## RabbitMQ Tutorial

## MessageListenerContainer

```java
// SimpleMessageListenerContainer.doStart()
// AsyncMessageProcessingConsumer는 비동기적으로 메시지를 처리하기 위해 TaskExecutor를 사용하여 메시지 처리를 수행한다.
AsyncMessageProcessingConsumer processor = new AsyncMessageProcessingConsumer(consumer);
processors.add(processor);
this.getTaskExecutor().execute(processor);
```


