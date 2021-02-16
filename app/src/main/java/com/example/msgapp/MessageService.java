package com.example.msgapp;

public class MessageService{

    public boolean sendMessage(String ip, String message){
        if(ip != null && ip!="" && message !=null && message!=""){
            HttpClient client = new HttpClient();
            final HttpPost httpPost(ip);
            final stringEntity body = new StringEntity(message, "UTF-8");
            httpPost.setEntity(body);
            try(final ClosableHttpResponse httpResponse = this.client.execute(httpPost)){
                final int responseStatus = httpResponse.getStatusLine().getStatusCode();
                if(responseStatus != 200){
                    try(final ClosableHttpResponse secondTryhttpResponse = this.client.execute(httpPost)){
                        final int secondResponseStatus = secondTryhttpResponse.getStatusLine().getStatusCode();
                        if(responseStatus != 200){
                            return false;
                        }
                    }
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}