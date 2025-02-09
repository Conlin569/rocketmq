/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.test.factory;

import java.util.UUID;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.test.util.RandomUtil;

public class ProducerFactory {

    public static DefaultMQProducer getRMQProducer(String ns) {
        //  先 new 的一个MQProducer
        DefaultMQProducer producer = new DefaultMQProducer(RandomUtil.getStringByUUID());
        producer.setInstanceName(UUID.randomUUID().toString());
        producer.setNamesrvAddr(ns);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }

        return producer;
    }
}
