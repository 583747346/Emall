package com.emall.authenticationserver.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * json序列化实现
 *
 * @author qinlang
 * @since 2020-05-14
 */
public class MyOauthExceptionSerializer extends StdSerializer<MyOauthException> {


    public MyOauthExceptionSerializer() {
        super(MyOauthException.class);
    }

    @Override
    public void serialize(MyOauthException myOauthException, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(myOauthException.getResult());
    }
}
