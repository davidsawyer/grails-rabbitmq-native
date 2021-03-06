/*
 * Copyright 2015 Bud Byrd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.budjb.rabbitmq

import com.budjb.rabbitmq.connection.ConnectionContext
import com.budjb.rabbitmq.connection.ConnectionManager
import com.budjb.rabbitmq.consumer.ConsumerManager
import com.budjb.rabbitmq.converter.MessageConverter
import com.budjb.rabbitmq.converter.MessageConverterManager
import com.rabbitmq.client.Channel
import org.apache.commons.lang.NullArgumentException
import org.springframework.beans.factory.InitializingBean
import org.springframework.context.ApplicationContext

class RabbitContextProxy implements RabbitContext, InitializingBean {
    /**
     * Target rabbit context.
     */
    RabbitContext target

    /**
     * Sets the target rabbit context.
     *
     * @param target
     */
    public void setTarget(RabbitContext target) {
        if (target == null) {
            throw new NullArgumentException("rabbit context target can not be null")
        }
        if (target instanceof RabbitContextProxy) {
            throw new IllegalArgumentException("rabbit context target can not be a RabbitContextProxy")
        }
        this.target = target
    }

    /**
     * Ensures a target is set after spring initialization is complete.
     */
    public void afterPropertiesSet() {
        assert target != null: "RabbitContext proxy target is required but not set"
    }

    @Override
    public void load() {
        target.load()
    }

    @Override
    public void start() {
        target.start()
    }

    @Override
    public void start(boolean skipConsumers) {
        target.start(skipConsumers)
    }

    @Override
    public void stop() {
        target.stop()
    }

    @Override
    public void restart() {
        target.restart()
    }

    @Override
    public void registerMessageConverter(MessageConverter converter) {
        target.registerMessageConverter(converter)
    }

    @Override
    public void registerConsumer(Object candidate) {
        target.registerConsumer(candidate)
    }

    @Override
    public void startConsumers() {
        target.startConsumers()
    }

    @Override
    public Channel createChannel() {
        return target.createChannel()
    }

    @Override
    public Channel createChannel(String connectionName) {
        return target.createChannel(connectionName)
    }

    @Override
    public ConnectionContext getConnection() {
        return target.getConnection()
    }

    @Override
    public ConnectionContext getConnection(String name) {
        return target.getConnection(name)
    }

    @Override
    public void setMessageConverterManager(MessageConverterManager messageConverterManager) {
        target.setMessageConverterManager(messageConverterManager)
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        target.setApplicationContext(applicationContext)
    }

    @Override
    public void setConnectionManager(ConnectionManager connectionManager) {
        target.setConnectionManager(connectionManager)
    }

    @Override
    public void setConsumerManager(ConsumerManager consumerManager) {
        target.setConsumerManager(consumerManager)
    }

    @Override
    public void setQueueBuilder(QueueBuilder queueBuilder) {
        target.setQueueBuilder(queueBuilder)
    }
}
