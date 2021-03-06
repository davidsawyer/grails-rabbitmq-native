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
import org.springframework.context.ApplicationContext

/**
 * A null object implementation of the RabbitContext.
 *
 * This is created when the plugin is disabled.
 */
class NullRabbitContext implements RabbitContext {

    @Override
    public void load() {

    }

    @Override
    public void start() {

    }

    @Override
    public void start(boolean skipConsumers) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void restart() {

    }

    @Override
    public void registerMessageConverter(MessageConverter converter) {

    }

    @Override
    public void registerConsumer(Object candidate) {

    }

    @Override
    public void startConsumers() {

    }

    @Override
    public Channel createChannel() {
        throw new UnsupportedOperationException('unable to create a new channel with a disabled rabbit context')
    }

    @Override
    public Channel createChannel(String connectionName) {
        throw new UnsupportedOperationException('unable to create a new channel with a disabled rabbit context')
    }

    @Override
    public ConnectionContext getConnection() {
        throw new UnsupportedOperationException('no connections are available with a disabled rabbit context')
    }

    @Override
    public ConnectionContext getConnection(String name) {
        throw new UnsupportedOperationException('no connections are available with a disabled rabbit context')
    }

    @Override
    public void setMessageConverterManager(MessageConverterManager messageConverterManager) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {

    }

    @Override
    public void setConnectionManager(ConnectionManager connectionManager) {

    }

    @Override
    public void setConsumerManager(ConsumerManager consumerManager) {

    }

    @Override
    public void setQueueBuilder(QueueBuilder queueBuilder) {

    }
}
