package com.mars.test.apache;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by yangyuchi on 26/12/2016.
 */
@Slf4j
public class TestUrlBuilder {

    @Test
    public void test1(){
        try {
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.test1.com")
                    .setPath("/search")
                    .setParameter("p0_Cmd", "Buy")
                    .setParameter("p1_MerId", "10001126856")
                    .setParameter("p2_Order", "AA0001")
                    .setParameter("p3_Amt", "100.77")
                    .setParameter("p4_Cur", "CNY")
                    .setParameter("p5_Pid", "productname")
                    .setParameter("p6_Pcat", "producttype")
                    .setParameter("p7_Pdesc", "productdesc")
                    .setParameter("p8_Url", "http://localhost:8080/callback.jsp")
                    .setParameter("p9_SAF", "0")
                    .setParameter("pa_MP", "userId")
                    .setParameter("pd_FrpId", "UU001")
                    .setParameter("pr_NeedResponse", "1")
                    .setParameter("hmac", "alsjkdfdsklfjklasjljlkj")
                    .build();
            log.info("uri = " + uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
