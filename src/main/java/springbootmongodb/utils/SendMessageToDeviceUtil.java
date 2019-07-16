/*
 * Copyright (c) 2014-2016 Alibaba Group. All rights reserved.
 * License-Identifier: Apache-2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package springbootmongodb.utils;

import com.aliyuncs.iot.model.v20180120.*;
import com.vulnova.device.aliyun.openApi.Abstract;

import java.util.Base64;

import static com.vulnova.device.aliyun.openApi.Abstract.executeTest;

/**
 * 操纵设备
 */
public class SendMessageToDeviceUtil extends Abstract {

    private static long shadowVersion = 1;

    /**
     * pub消息
     *
     * @param productKey pk
     * @param topic topic
     * @param msg 消息内容
     */
    public static void pubTest(String productKey, String topic, String msg) {
        PubRequest request = new PubRequest();
        request.setProductKey(productKey);
        request.setTopicFullName(topic);
        request.setMessageContent(Base64.encodeBase64String(msg.getBytes()));
        request.setQos(1);
        PubResponse response = (PubResponse)executeTest(request);
        if (response != null && response.getSuccess() != false) {
            LogUtil.print("发送消息成功！messageId：" + response.getRequestId()+"   "+response.getMessageId()+response.getSuccess());
        } else {
            LogUtil.error("发送消息失败！requestId:" + response.getRequestId() + "原因：" + response.getErrorMessage());
            throw new RuntimeException("发送消息失败");
        }

    }

    /**
     * 发送广播消息
     *
     * @param productKey 产品pk
     * @param topic 广播topic /broadcast/${pk}/+
     * @param msg 消息内容
     */
    public static void pubBroadcastTest(String productKey, String topic, String msg) {
        PubBroadcastRequest request = new PubBroadcastRequest();
        request.setProductKey(productKey);
        request.setTopicFullName(topic);
        request.setMessageContent(Base64.encodeBase64String(msg.getBytes()));
        PubBroadcastResponse response = (PubBroadcastResponse)executeTest(request);
        if (response != null && response.getSuccess() != false) {
            LogUtil.print("发送消息成功！");
        } else {
            LogUtil.error("发送消息失败！requestId:" + response.getRequestId() + "原因：" + response.getErrorMessage());

        }

    }

    /**
     * 发送rrpc消息
     *
     * @param productKey 产品pk
     * @param deviceName 设备名称
     * @param msg 消息内容
     */
    public static void rrpcTest(String productKey, String deviceName, String msg) {
        RRpcRequest request = new RRpcRequest();
        request.setProductKey(productKey);
        request.setDeviceName(deviceName);
        request.setRequestBase64Byte(Base64.encodeBase64String(msg.getBytes()));
        request.setTimeout(5000);
        RRpcResponse response = (RRpcResponse)executeTest(request);
        if (response != null && response.getSuccess() != false) {
            LogUtil.print("rrpc消息发送成功！messageId:" + response.getMessageId() + ",payloadBase64Byte：" + new String(
                Base64.decodeBase64(response.getPayloadBase64Byte())));
        } else {
            LogUtil.error("rrpc消息发送失败！requestId:" + response.getRequestId() + "原因：" + response.getErrorMessage());

        }

    }



}
